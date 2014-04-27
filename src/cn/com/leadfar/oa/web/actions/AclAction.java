package cn.com.leadfar.oa.web.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.com.leadfar.oa.model.ACL;
import cn.com.leadfar.oa.model.ActionMethodOper;
import cn.com.leadfar.oa.model.ActionResource;
import cn.com.leadfar.oa.model.Menu;
import cn.com.leadfar.oa.model.Role;
import cn.com.leadfar.oa.service.AclService;
import cn.com.leadfar.oa.service.MenuService;
import cn.com.leadfar.oa.service.ResourceService;
import cn.com.leadfar.oa.service.RoleService;
import cn.com.leadfar.oa.service.UserService;
import cn.com.leadfar.oa.vo.AuthVO;
import cn.com.leadfar.oa.vo.MenuTreeVO;
import cn.com.leadfar.oa.web.JSONUtils;

import com.opensymphony.xwork2.ActionContext;

@Controller("aclAction")
@Scope("prototype")
public class AclAction extends BaseAction{
	
	@Resource
	private RoleService roleService;
	
	@Resource
	private ResourceService resourceService;	
	
	@Resource
	private UserService userService;
	
	@Resource
	private MenuService menuService;
	
	@Resource
	private AclService aclService;
	
	private String principalType;
	private int principalId;
	
	private int topMenuId;
	
	//�������ո��˵���Ȩʱ��ѡ�еĲ˵�ID�б�
	private List<AuthVO> authvos;
	
	//�������ղ�ѯ���������û���Ȩ�����ϣ�����������������ѯ��Ա��
	private String sSearch;
	
	/**
	 * �򿪽�ɫ��Ȩ������
	 */
	public String roleAuthIndex(){
		return "role_auth_index";
	}
	/**
	 * ��ɫ��Ȩ����������ʾ�Ľ�ɫ�б���
	 */
	public void roleAuthIndexTree(){
		//������еĽ�ɫ����
		List<Role> roles = roleService.findAllRoles();
		
		//��ɫ��
		List roleTreeVOs = new ArrayList();
		
		//ÿ����ɫ����һ��VO����
		for(Role r:roles){
			Map roleTreeVO = new HashMap();
			roleTreeVO.put("data", r.getName());
			
			Map attr = new HashMap();
			attr.put("id", r.getId());
			attr.put("principalId", r.getId());
			attr.put("principalType", "Role");
			
			roleTreeVO.put("attr", attr);
			
			roleTreeVOs.add(roleTreeVO);
		}
		JSONUtils.toJSON(roleTreeVOs);
	}
	
	//�û���Ȩ������
	public String userAuthIndex(){
		return "user_auth_index";
	}
	//�û���Ȩ����������ʾ���û��б�
	public void userAuthIndexList(){
		//ֻ��Ҫ�����Щ�����˵�¼�ʺŵ���Ա���ɣ���Ϊ���û�з����¼�ʺţ����޷�
		//������Ȩ�ģ�����Ȩ��������User��������Person
		List persons = userService.findPersonsWithUser(sSearch);
		Map map = new HashMap();
		map.put("aaData", persons);
		JSONUtils.toJSON(map);
	}
	
	//����/��λ��Ȩ������
	public String partyAuthIndex(){
		return "party_auth_index";
	}
	//����/��λ��Ȩ�������ϵĲ���/��λ��
	public void partyAuthIndexTree(){
		
	}
	
	//�����帳��˵���Ȩ
	public void authMenu(){
		aclService.addOrUpdatePermission(principalType, principalId, "Menu", authvos);
	}
	
	//�����帳��ActionResource��Ȩ
	public void authActionResource(){
		aclService.addOrUpdatePermission(principalType, principalId, "ActionResource", authvos);
	}
	
	//���еĲ˵���Դ������
	public String allMenuResource(){
		
		//��ѯ�����ж����˵���ID�б�
		List<Integer> topMenuIds = menuService.findAllTopMenuIds();
		
		ActionContext.getContext().put("menuIds", topMenuIds);
		
		return "all_menu_resource";
	}
	//�ڲ˵���Դ����������ʾ�˵���
	public void allMenuResourceTree(){
		
		//���ն����˵���ID�����챾�˵��Ĳ˵���
		Menu topMenu = menuService.findMenuById(topMenuId);
		MenuTreeVO mtv = new MenuTreeVO(topMenu);
		JSONUtils.toJSON(mtv);
	}
	//�Ѳ˵�����ʾ���֮����Ҫ��������Ȩ��ѯ��������ʾ
	public void findMenuAcls(){
//		List<ACL> acls = aclService.findAclList(principalType, principalId, "Menu");
//		List<AuthVO> vos = new ArrayList<AuthVO>();
//		for(ACL acl:acls){
//			AuthVO vo = new AuthVO();
//			vo.setResourceId(acl.getResourceId());
//			vo.setOperIndex(0);
//			vo.setPermit(acl.isPermit(0));
//			vo.setExt(acl.isExt(0));
//			vos.add(vo);
//		}
		List<AuthVO> vos = aclService.findAclList(principalType, principalId, "Menu");
		JSONUtils.toJSON(vos);
	}
	
	//���еĲ�����Դ������
	public String allActionResource(){
		
		List<ActionResource> res = resourceService.findAllActionResources();
		System.out.println(res.size());
		ActionContext.getContext().put("ress", res);
		
		return "all_action_resource";
	}
	public void findActionResourceAcls(){
//		List<ACL> acls = aclService.findAclList(principalType, principalId, "ActionResource");
//		List<AuthVO> vos = new ArrayList<AuthVO>();
//		for(ACL acl:acls){
//			
//			int resourceId = acl.getResourceId();
//			
//			//����ACL��¼��Ӧ����Դ�ж����ֲ���
//			Collection<ActionMethodOper> opers =
//				resourceService.findActionResourceById(resourceId)
//					.getOpers().values();
//			
//			//���ÿ�ֲ�������һ��AuthVO����
//			for(ActionMethodOper oper:opers){
//				AuthVO vo = new AuthVO();
//				vo.setResourceId(acl.getResourceId());
//				vo.setOperIndex(oper.getOperIndex());
//				vo.setPermit(acl.isPermit(oper.getOperIndex()));
//				vo.setExt(acl.isExt(oper.getOperIndex()));
//				vos.add(vo);
//			}
//		}
		List<AuthVO> vos = aclService.findAclList(principalType, principalId, "ActionResource");
		JSONUtils.toJSON(vos);
	}
	
	public String getPrincipalType() {
		return principalType;
	}
	public void setPrincipalType(String principalType) {
		this.principalType = principalType;
	}
	public int getPrincipalId() {
		return principalId;
	}
	public void setPrincipalId(int principalId) {
		this.principalId = principalId;
	}
	public int getTopMenuId() {
		return topMenuId;
	}
	public void setTopMenuId(int topMenuId) {
		this.topMenuId = topMenuId;
	}

	public List<AuthVO> getAuthvos() {
		return authvos;
	}
	public void setAuthvos(List<AuthVO> authvos) {
		this.authvos = authvos;
	}
	public String getSSearch() {
		return sSearch;
	}
	public void setSSearch(String search) {
		sSearch = search;
	}
}
