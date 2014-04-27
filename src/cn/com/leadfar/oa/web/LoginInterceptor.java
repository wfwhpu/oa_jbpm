package cn.com.leadfar.oa.web;

import org.apache.struts2.ServletActionContext;

import cn.com.leadfar.oa.vo.LoginInfoVO;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		LoginInfoVO currentUser = (LoginInfoVO)ServletActionContext.getRequest().getSession().getAttribute("login");
		
		if(currentUser == null){
			return "login";
		}
		
		//��������ִ��
		return invocation.invoke();
	}

}
