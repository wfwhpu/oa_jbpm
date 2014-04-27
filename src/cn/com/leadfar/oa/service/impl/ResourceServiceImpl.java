package cn.com.leadfar.oa.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.MethodMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.stereotype.Service;

import cn.com.leadfar.oa.annotations.Oper;
import cn.com.leadfar.oa.annotations.Res;
import cn.com.leadfar.oa.dao.MenuDao;
import cn.com.leadfar.oa.dao.ResourceDao;
import cn.com.leadfar.oa.model.ActionMethodOper;
import cn.com.leadfar.oa.model.ActionResource;
import cn.com.leadfar.oa.model.Menu;
import cn.com.leadfar.oa.service.ResourceService;

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {

	private Logger logger = Logger.getLogger(ResourceServiceImpl.class);
	
	@Resource
	private ResourceDao resourceDao;

	@Override
	public void rebuildActionResources() {
		try {
			
			//ɨ��ĳ������package���������Ӱ��е�Action��
			//���ձ�·��ģʽ�涨�����е�Action�����Ҫ����ΪXXXAction
			String pathPattern = "cn/com/leadfar/oa/web/**/*Action.class";
			
			//Spring�е���Դ·��������
			ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
			
			//�õ��ڰ���������е��ࣨ��װ����Resource���ͣ�
			org.springframework.core.io.Resource[] res = resolver.getResources(pathPattern);
			
			if(res != null){
				
				//Ϊ�˵õ�MetadataReader���ȴ���factory
				MetadataReaderFactory metaFactory = new CachingMetadataReaderFactory();				
				
				//���ɨ����Щ��
				for(org.springframework.core.io.Resource r:res){

					//��ȡָ���������Ϣ
					MetadataReader metadataReader = metaFactory.getMetadataReader(r);

					//��ȡ�����Ϣ�������浽ActionResource����
					saveActionResource(metadataReader,metaFactory,resolver);
				}
			}
			
			//������Դ֮��ĸ��ӹ�ϵ
			List<ActionResource> allResources = resourceDao.findAll();
			for(ActionResource ar:allResources){
				//���������parentSn����������parentSn���Ҹ��ף�����������
				String parentSn = ar.getParentSn();
				if(parentSn != null && !parentSn.trim().equals("")){
					ActionResource parent = resourceDao.findActionResourceBySn(parentSn);
					if(parent != null){
						ar.setParent(parent);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("�����¹���������Դʱ�����쳣��",e);
		}		
	}
	
	private void saveActionResource(MetadataReader metadataReader,
			MetadataReaderFactory metaFactory,ResourcePatternResolver resolver) throws IOException{
		
		//�õ����Ԫ����������Ϣ
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		
		//�õ����ע��Ԫ����
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		
		//�ж�ĳ�����Ƿ�����@Resע��
		if(annotationMetadata.hasAnnotation(Res.class.getName())){
			logger.debug("ɨ�赽�ࣺ"+classMetadata.getClassName()+" ������@Resע�⣡");
			
			/////////////////////// ��ȡ��Դ��Ϣ //////////////////////////////
			//ȡ��@Resע�������
			Map resAttrs = annotationMetadata.getAnnotationAttributes(Res.class.getName());
			
			//���@Resע���е�sn���Ե�ֵ
			String resSn = (String)resAttrs.get("sn");		
			
			//���@Resע���е�name���Ե�ֵ
			String resName = (String)resAttrs.get("name");	
			
			//���@Resע���е�orderNumber���Ե�ֵ
			int orderNumber = (Integer)resAttrs.get("orderNumber");
			
			//���@Resע���е�parentSn���Ե�ֵ
			String parentSn = (String)resAttrs.get("parentSn");			
			
			//���@Resע�����ڵ�����
			String className = classMetadata.getClassName();
			
			//���ȸ���sn����ѯ���ݿ⣬����Ѿ����ڣ����ٴ���������ʹ��ԭ�е�ActionResource����
			ActionResource ar = resourceDao.findActionResourceBySn(resSn);
			if(ar == null){
				//�����Ӧ����Դ�в����ڣ��򴴽�ActionResource����
				ar = new ActionResource();
			}

			ar.addClassName(className);
			ar.setName(resName);
			ar.setSn(resSn);
			ar.setOrderNumber(orderNumber);
			ar.setParentSn(parentSn);
			
			logger.debug("ɨ�赽��Դ��"+resSn+"("+resName+")����"+className);
			
			//�������������涨����@Oper�ķ������丸�������涨����@Oper�ķ���
			searchOperAnnotations(ar, metadataReader,metaFactory,resolver);
			
			resourceDao.save(ar);
		}
		
	}
	
	/**
	 * ����������@Operע��ķ������������������ͣ��и��࣬����������������а���@Operע��ķ���
	 */
	private void searchOperAnnotations(ActionResource ar,MetadataReader metadataReader,
			MetadataReaderFactory metaFactory,ResourcePatternResolver resolver) throws IOException{
		//�õ����ע��Ԫ����
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		//ɨ�����������ķ�����Ѱ�Ұ���@Operע��ķ���
		Set<MethodMetadata> methodMetas = annotationMetadata.getAnnotatedMethods(Oper.class.getName());
		for(MethodMetadata mmd:methodMetas){
			Map<String,Object> operAttrs = mmd.getAnnotationAttributes(Oper.class.getName());
			String methodName = mmd.getMethodName();
			String operName = (String)operAttrs.get("name");
			if(operName == null || operName.equals("")){ //δ���������
				operName = getDefaultOperName(methodName);
			}
			String operSn = (String)operAttrs.get("sn");
			if(operSn == null || operSn.equals("")){
				operSn = getDefaultOperSn(methodName);
			}
			int operIndex = (Integer)operAttrs.get("index");
			if(operIndex == -1){
				operIndex = getDefaultOperIndex(methodName);
			}
			
			ar.addActionMethodOper(methodName, operName, operSn, operIndex);
			logger.debug("ɨ�赽������"+operSn+"("+operName+")��["+operIndex+"]��"+methodName);
		}
		
		//����и��࣬���Ҳ���java.lang.Object���������������������Ƿ񻹰�����@Operע��ķ���
		if(metadataReader.getClassMetadata().hasSuperClass() && !metadataReader.getClassMetadata().getSuperClassName().equals(Object.class.getName())){
			//�õ���������ƣ����磺cn.com.leadfar.oa.web.actions.PartyAction
			String superClassName = metadataReader.getClassMetadata().getSuperClassName();
			//���츸�����Դ·�������磺cn/com/leadfar/oa/web/actions/PartyAction.class
			String superClassPath = superClassName.replace('.', '/')+".class";
			org.springframework.core.io.Resource superClassResource = resolver.getResource(superClassPath);
			
			//�ݹ�������������Ĳ���
			searchOperAnnotations(ar, metaFactory.getMetadataReader(superClassResource), metaFactory,resolver);
		}
	}
	
	/**
	 * ���ݷ��������õ�ȱʡ�Ĳ�����
	 * @param methodName
	 * @return
	 */
	private String getDefaultOperName(String methodName){
		if(methodName.startsWith("add")){
			return "���";
		}else if(methodName.startsWith("update")){
			return "����";
		}else if(methodName.startsWith("del")){
			return "ɾ��";
		}else{
			return "��ѯ";
		}
	}
	private String getDefaultOperSn(String methodName){
		if(methodName.startsWith("add")){
			return "CREATE";
		}else if(methodName.startsWith("update")){
			return "UPDATE";
		}else if(methodName.startsWith("del")){
			return "DELETE";
		}else{
			return "READ";
		}
	}
	private int getDefaultOperIndex(String methodName){
		if(methodName.startsWith("add")){
			return 0;
		}else if(methodName.startsWith("update")){
			return 1;
		}else if(methodName.startsWith("del")){
			return 2;
		}else{
			return 3;
		}
	}
	
	
	@Override
	public void addActionResource(ActionResource ar) {
		resourceDao.save(ar);
	}

	@Override
	public void delActionResource(int actionResourceId) {
		resourceDao.del(findActionResourceById(actionResourceId));
	}

	@Override
	public ActionResource findActionResourceById(int actionResourceId) {
		return resourceDao.findById(ActionResource.class, actionResourceId);
	}

	@Override
	public ActionResource findActionResourceByClassName(String className) {
		return resourceDao.findByClassName(className);
	}

	@Override
	public List<ActionResource> findAllActionResources() {
		return resourceDao.findAll();
	}

	@Override
	public List<ActionResource> findAllTopActionResources() {
		return resourceDao.findAllTopActionResource();
	}

	@Override
	public void updateActionResource(ActionResource ar) {
		resourceDao.update(ar);
	}

	@Override
	public void addActionResourceOper(int actionResourceId,
			ActionMethodOper oper) {
		ActionResource ar = findActionResourceById(actionResourceId);
		ar.addActionMethodOper(oper.getMethodName(), oper.getOperName(), 
				oper.getOperSn(), oper.getOperIndex());
	}

	@Override
	public void delActionResourceOper(int actionResourceId, String operSn) {
		ActionResource ar = findActionResourceById(actionResourceId);
		ar.getOpers().remove(operSn);
	}
	
}
