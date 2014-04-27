package cn.com.leadfar.oa.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.com.leadfar.oa.SystemContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class PagerInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		try{
			//ȡ����ҳ���������õ�ThreadLocal��
			SystemContext.setOffset(getOffset(request));
			SystemContext.setPagesize(getPagesize(request));
			
			return invocation.invoke();
			
		}finally{
			SystemContext.removeOffset();
			SystemContext.removePagesize();
		}
	}
	

	protected int getOffset(HttpServletRequest request){
		int offset = 0;
		// ϣ����request�л��offset����
		try {
			offset = Integer.parseInt(request.getParameter("iDisplayStart"));
		} catch (Exception ignore) {
		}
		return offset;
	}
	
	protected int getPagesize(HttpServletRequest request){
		int pagesize = 5;

		// �����request���ݹ�����pagesize��������ô����Ҫ����http session�е�pagesize��ֵ
		if (request.getParameter("iDisplayLength") != null) {
			request.getSession().setAttribute("iDisplayLength",
					Integer.parseInt(request.getParameter("iDisplayLength")));
		}

		// ϣ����http session�л��pagesize��ֵ�����û�У�������ȱʡֵΪ5
		Integer ps = (Integer) request.getSession().getAttribute("iDisplayLength");
		if (ps == null) {
			request.getSession().setAttribute("iDisplayLength", pagesize);
		} else {
			pagesize = ps;
		}
		return pagesize;
	}

}
