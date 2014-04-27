package cn.com.leadfar.oa.web;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import cn.com.leadfar.oa.model.ActionResource;
import cn.com.leadfar.oa.service.AclService;
import cn.com.leadfar.oa.service.ResourceService;
import cn.com.leadfar.oa.vo.LoginInfoVO;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * ��ʱ��֤������������Ҫ������LoginInterceptor֮��
 * @author Lee
 *
 */
public class AuthInterceptor extends AbstractInterceptor {

	@Resource
	private AclService aclService;
	
	@Resource
	private ResourceService resourceService;
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		//Ҫ���õ�Action����
		String className = invocation.getProxy().getAction()
			.getClass().getName();
		
		//����Ҫ���õ�����������ActionResource����
		ActionResource actionResource = resourceService.findActionResourceByClassName(className);
		
		//������Action�ಢ����һ����Դ����ʾ�������ܵ�Ȩ�޿��ƣ����ֱ����������
		if(actionResource == null){
			return invocation.invoke();
		}
		
		//�õ�Ҫ���õķ�����
		String methodName = invocation.getProxy().getMethod();
		
		//����Ҫ���õķ��������õ����Ӧ�Ĳ�����ʶ
		String operSn = actionResource.getOperSnByMethodName(methodName);
		
		//������������û�б�����Ϊ�����Դ��һ�ֲ�������ô����ζ�ű������������Ȩ�޿��ƣ�
		if(operSn == null){
			return invocation.invoke();
		}
		
		//�õ���ǰ��¼�û���ID
		int userId = ((LoginInfoVO)ServletActionContext.getRequest().getSession().getAttribute("login")).getId();
		
		//�Ƿ�����ǰ��¼�û�ִ�б���Դ�ı�������
		boolean permit = aclService.hasPermission(userId, actionResource.getSn(), operSn);
		
		//����������������ִ��
		if(permit){
			return invocation.invoke();
		}
		
		throw new RuntimeException("����Ȩִ�б�������resourceSn="+actionResource.getSn()+",operSn="+operSn+"��������ϵϵͳ����Ա��");
	}

}
