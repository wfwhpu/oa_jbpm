package cn.com.leadfar.oa.web.actions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.com.leadfar.oa.SystemContext;
import cn.com.leadfar.oa.annotations.Oper;
import cn.com.leadfar.oa.annotations.Res;
import cn.com.leadfar.oa.model.Role;
import cn.com.leadfar.oa.model.User;
import cn.com.leadfar.oa.service.PartyService;
import cn.com.leadfar.oa.service.RoleService;
import cn.com.leadfar.oa.service.UserService;
import cn.com.leadfar.oa.vo.PagerVO;
import cn.com.leadfar.oa.web.JSONUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@Controller("userAction")
@Scope("prototype")
@Res(name="�û�����",sn="user",orderNumber=80,parentSn="security")
public class UserAction extends BaseAction implements ModelDriven{
	
	@Resource
	private UserService userService;
	
	@Resource
	private PartyService partyService;
	
	@Resource
	private RoleService roleService;
	
	private User user;

	private int[] roleIds;
	
	private String sSearch;
	
	@Override
	public Object getModel() {
		if(user == null){
			user = new User();
		}
		return user;
	}
	
	@Oper
	public String execute(){

		return "index";
	}
	
	//������е���Ա��Ϣ
	@Oper
	public void list(){
		Map map = new HashMap();
		
		PagerVO pv = userService.findPersonUsers(sSearch);
		
		map.put("iTotalRecords", pv.getTotal());
		map.put("iTotalDisplayRecords", pv.getTotal());
		map.put("aaData", pv.getDatas());
		JSONUtils.toJSON(map);
	}
	
	@Oper
	public String addInput(){
		
		//������еĽ�ɫ��������ѡ��
		List<Role> roles = roleService.findAllRoles();
		
		ActionContext.getContext().put("roles", roles);
		
		return "add_input";
	}
	
	@Oper
	public String add(){
		userService.addUser(user,roleIds);
		return "add_success";
	}
	
	@Oper
	public String updateInput(){
		
		user = userService.findUserById(user.getId());
		
		//��ѯ�����еĽ�ɫ�����Է����������б����ѡ������
		List<Role> roles = roleService.findAllRoles();
		ActionContext.getContext().put("roles", roles);
		
		//��ѯ��ĳ���û�ӵ�е����н�ɫ�����Է���򿪸���ҳ��ʱ���Զ�ѡ����Щ��ɫ
		List selectedRoleIds = userService.findRoleIdsOfUser(user.getId());
		ActionContext.getContext().put("selectedRoleIds", selectedRoleIds);
		
		return "update_input";
	}
	
	//�ж�roleId�Ƿ���������selectedRoleIds�б���
	public String hasSelected(int roleId,List<Integer> selectedRoleIds){
		if(selectedRoleIds == null){
			return "";
		}
		for(Integer i:selectedRoleIds){
			if(i.equals(roleId)){
				return "selected";
			}
		}
		return "";
	}
	
	@Oper
	public String update(){
		userService.updateUser(user,roleIds);
		return "update_success";
	}
	
	@Oper
	public void del(){
		userService.delUser(user.getId());
		//return "del_success";
	}

	public String getSSearch() {
		return sSearch;
	}

	public void setSSearch(String search) {
		sSearch = search;
	}

	public int[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(int[] roleIds) {
		this.roleIds = roleIds;
	}
}
