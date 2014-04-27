package cn.com.leadfar.oa.web.actions;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import cn.com.leadfar.oa.service.AclService;
import cn.com.leadfar.oa.vo.LoginInfoVO;

public class BaseAction {
	
	@Resource
	private AclService aclService;
	
	/**
	 * ��HTTP SESSION��ȡ���ѵ�¼��User������Ϣ
	 * @return
	 */
	protected LoginInfoVO currentUser(){
		return (LoginInfoVO)ServletActionContext.getRequest().getSession().getAttribute("login");
	}
	
	public boolean permit(String resourceSn,String operSn){
		try{
			return aclService.hasPermission(currentUser().getId(), resourceSn, operSn);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
