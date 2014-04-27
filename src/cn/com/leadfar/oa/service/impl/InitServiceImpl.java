package cn.com.leadfar.oa.service.impl;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

import cn.com.leadfar.oa.dao.InitDao;
import cn.com.leadfar.oa.service.InitService;
import cn.com.leadfar.oa.service.ResourceService;

/**
 * ��������󣬽���Spring�����ļ��н������ã���ҪĿ����Ϊ�˰ѳ�ʼ�����ݵ��ļ���ת�Ƶ�
 * �����ļ��У���Spring�������ļ��У�����
 * @author Lee
 *
 */
public class InitServiceImpl implements InitService,BeanFactoryAware {

	/**
	 * ָ����ʼ���������ڵ�XML�ļ�������ļ����������·���£����ֱ�ӷ�����·����Ŀ¼�£�
	 * ��ôֱ��ָ�����ļ����Ƽ��ɣ���������������ڵ�·���������磺
	 * init.xml - ����·���ĸ�Ŀ¼��
	 * ��
	 * cn/com/leadfar/oa/service/init.xml - ��ĳ��·����
	 */
	private String path;
	
	private BeanFactory factory;
	
	@Resource
	private InitDao initDao;
	
	/**
	 * Spring��ʵ����InitServiceImpl�����ʱ�����InitServiceImpl��ʵ����
	 * BeanFactoryAware�ӿڣ�Spring���Զ�������BeanFactory��ע�뵽�˶���
	 */
	@Override
	public void setBeanFactory(BeanFactory factory) throws BeansException {
		this.factory = factory;
	}

	@Override
	public void addInitDatas() {
		try {
			//����·���ĸ�Ŀ¼�ж�ȡָ���İ�����ʼ�����ݵ�XML�ļ�
			Document document = new SAXReader().read(Thread.currentThread().getContextClassLoader().getResourceAsStream(path));
			
			//�ĵ���Ԫ��
			Element root = document.getRootElement();
			
			//���ĵ���Ԫ������ȡ��ʵ�������ڵİ���
			String pkg = root.attributeValue("package");
			
			//�õ���Ԫ��������������е�entityԪ��
			List entityElements = root.elements("entity");
			for (Iterator iterator = entityElements.iterator(); iterator
					.hasNext();) {
				Element entityElement = (Element) iterator.next();
				addEntity(pkg,entityElement,null,null);
			}
			
			//�ؽ����е�ActionResource��Դ
			ResourceService resourceService = (ResourceService)factory.getBean("resourceService");
			resourceService.rebuildActionResources();
			
			//
			initDao.addInitAdmin();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	private void addEntity(String pkg,Element entityElement,Object parentEntity,String callString){
		try {
			
			//���ݰ������������õ�ȫ·������
			String clz = pkg + "." +entityElement.attributeValue("class");
			
			//����ȫ·������������ʵ�����
			Object entity = Class.forName(clz).newInstance();
			
			//��entity����ֵ
			//����ȡ����ǰElement�е��������ԣ����÷�����Ƹ�entity����ֵ
			Iterator iterator = entityElement.attributeIterator();
			while(iterator.hasNext()){
				Attribute attribute = (Attribute)iterator.next();
				String propertyName = attribute.getName();
				if(!propertyName.equals("class") && !propertyName.equals("call")){
					String propertyValue = attribute.getValue();
					//��entity��Ӧ�����Ը�ֵ������ʹ�õ���apache-commons-beanutils���߰���������Ҫ�������������
					BeanUtils.copyProperty(entity, propertyName, propertyValue);
				}
			}
			
			//�ж�parentEntity�Ƿ�Ϊ�գ�������ǿգ����parent����ֵ
			if(parentEntity != null){
				Method[] ms = entity.getClass().getMethods();
				for(Method m:ms){
					if(m.getName().equals("setParent")){
						m.invoke(entity, parentEntity);
					}
				}
			}
			
			//Ҫ�����ĸ����������ĸ�����
			String call = entityElement.attributeValue("call");
			if(call != null){
				callString = call;
			}
			
			if(callString == null){
				throw new RuntimeException("û���ҵ�call���ԣ��޷���֪Ҫ�����ĸ����������ĸ�������������call���ԣ�");
			}
			
			//�õ���������ID
			String serviceId = callString.substring(0, callString.indexOf("."));
			//�õ�Ҫ���õķ�������
			String methodName = callString.substring(callString.indexOf(".")+1);
			
			//ͨ��BeanFactory�õ��������
			Object service = factory.getBean(serviceId);
			
			//�õ�service��������з���
			Method[] ms = service.getClass().getMethods();
			for(Method m:ms){
				if(m.getName().equals(methodName)){
					//��������������Ҫ���õķ���
					m.invoke(service, entity);
				}
			}
			
			//�жϵ�ǰentity�����Ƿ���������entityԪ��
			List subEntityElements = entityElement.elements("entity");
			for (Iterator iterator2 = subEntityElements.iterator(); iterator2
					.hasNext();) {
				Element e = (Element) iterator2.next();
				//�ݹ���뱾entityԪ�����������entity����
				addEntity(pkg,e,entity,callString);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void setPath(String path) {
		this.path = path;
	}

}
