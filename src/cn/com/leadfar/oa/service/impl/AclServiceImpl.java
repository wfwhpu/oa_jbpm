package cn.com.leadfar.oa.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.leadfar.oa.dao.AclDao;
import cn.com.leadfar.oa.dao.MenuDao;
import cn.com.leadfar.oa.dao.UserDao;
import cn.com.leadfar.oa.model.ACL;
import cn.com.leadfar.oa.model.Menu;
import cn.com.leadfar.oa.model.Principal;
import cn.com.leadfar.oa.model.SysResource;
import cn.com.leadfar.oa.model.User;
import cn.com.leadfar.oa.service.AclService;
import cn.com.leadfar.oa.vo.AuthVO;

@Service("aclService")
public class AclServiceImpl implements AclService {

	@Resource
	private AclDao aclDao;
	
	@Resource
	private MenuDao menuDao;
	
	@Resource
	private UserDao userDao;
	
	@Override
	public List findAclList(String principalType, int principalId,
			String resourceType) {
		List<AuthVO> vos = new ArrayList<AuthVO>();
		
		//��ѯ���������
		Principal principal = aclDao.findPrincipal(principalType, principalId);
		
		//��ѯ��ĳ�����͵�������Դ
		List<SysResource> resources = aclDao.findAllSysResources(resourceType);
		for(SysResource res:resources){
			//��Դ���Դ�����в���
			int[] indexs = res.getOpersIndex();
			if(indexs != null){
				for(int operIndex:indexs){
					//��ѯ�������Ӧ��ĳ��Դ��ĳ������Ȩ��
					AuthVO vo = searchAcl(principal, resourceType, res.getResourceId(), operIndex);
					if(vo != null){
						vos.add(vo);
					}
				}
			}
		}
		return vos;
	}
	
	private AuthVO searchAcl(Principal principal,String resourceType, int resourceId,int operIndex){
		//���Ȳ�ѯ��������Դ֮���Ƿ��й��������Ƿ�������Ȩ�ޣ�
		ACL acl = aclDao.findACL(principal.getPrincipalType(), principal.getPrincipalId(), resourceType, resourceId);
		AuthVO vo = null;
		
		//���������Ȩ�ޣ����Ҳ��Ǽ̳еģ������Ͽ��Եõ���Ȩ��Ϣ
		if(acl != null && !acl.isExt(operIndex)){
			vo = new AuthVO();
			vo.setResourceId(resourceId);
			vo.setOperIndex(operIndex);
			vo.setExt(false);
			vo.setPermit(acl.isPermit(operIndex));
			return vo;
		}
		
		//���û�ж�����Ȩ����������Ȩ���Ǽ̳еģ�����������丸�׵�Ȩ��
		List<Principal> parents = principal.getParentPrincipal();
		if(parents == null){
			return null;
		}
		
		//����ÿһ�����ף��ж�����Ȩ��Ϣ
		for(Principal parent:parents){
			AuthVO pvo = searchAcl(parent, resourceType, resourceId, operIndex);
			
			//�����������Ȩ�������Ǿܾ��ģ������̷���
			if(pvo != null && !pvo.isPermit()){
				vo = new AuthVO();
				vo.setResourceId(resourceId);
				vo.setOperIndex(operIndex);
				vo.setExt(true); //�̳�
				vo.setPermit(false); //�ܾ�
				return vo;
			}
			
			//�����������Ȩ�������������
			if(pvo != null && pvo.isPermit()){
				if(vo == null){ //ֻ�贴��һ��
					vo = new AuthVO();
					vo.setResourceId(resourceId);
					vo.setOperIndex(operIndex);
					vo.setExt(true);
					vo.setPermit(true);					
				}
			}
		}
		
		return vo;
	}

	@Override
	public void addOrUpdatePermission(String principalType, int principalId,
			String resourceType,List<AuthVO> acls) {
		
		//�Ȱ�������Ȩɾ��
		aclDao.delAcls(principalType, principalId, resourceType);
		
		//��������
		if(acls != null){
			for(AuthVO auth:acls){
				int resourceId = auth.getResourceId();
				int operIndex = auth.getOperIndex();
				boolean permit = auth.isPermit();
				boolean ext = auth.isExt();
				ACL acl = aclDao.findACL(principalType, principalId, resourceType, resourceId);
				if(acl == null){ //����ACL����
					acl = new ACL();
					acl.setAclTriState(-1); //Ĭ��Ϊ�̳У������ĳ����Դ�����������ĳЩ����δ���壬Ĭ�ϼ��Ǽ̳�
					acl.setPrincipalType(principalType);
					acl.setPrincipalId(principalId);
					acl.setResourceType(resourceType);
					acl.setResourceId(resourceId);
					acl.setPermission(operIndex, permit,ext);
					aclDao.save(acl);
				}else{ //����ACL����
					acl.setPermission(operIndex, permit,ext);
					aclDao.update(acl);
				}
			}
		}
	}

	@Override
	public List findPermitMenus(int userId) {
		
		//���Ȳ�ѯ�����ж����˵�
		List<Menu> topMenus = menuDao.findAllTopMenus();
		
		//���ÿһ�������˵���������ĺ��ӽڵ㣬�ж��û������Ƿ�ӵ�з��ʵ�����Ȩ��
		//���û�������Ȩ�ޣ���Ѵ˲˵��ڵ�ɾ��
		removeDenyMenus(topMenus,userId);
		
		return topMenus;
	}
	//ɾ����Щ������Ĳ˵���
	private void removeDenyMenus(Collection<Menu> menus,int userId){
		
		for (Iterator<Menu> iterator = menus.iterator(); iterator.hasNext();) {
			Menu menu = iterator.next();
			
			//��ѯ����ǰ�û���Զ�Ӧ�˵����Ȩ��
			AuthVO vo = searchAcl(userDao.findById(User.class, userId), 
					menu.getResourceType(), menu.getResourceId(), menu.getOpersIndex()[0]);
			
			//����˲˵���δ��Ȩ��������Ȩ����������ʱ��˵���
			if(vo == null || !vo.isPermit()){
				iterator.remove();
			}else{
				//������˵���������ģ�������������Ӳ˵�
				removeDenyMenus(menu.getChildren(), userId);
			}
		}
	}

	@Override
	public boolean hasPermission(int userId, String resourceSn, String operSn) {
		
		//�������
		User user = userDao.findById(User.class, userId);
		
		//������ԴΨһ��ʶ������Դ����
		SysResource resource = aclDao.findSysResourceBySn(resourceSn);
		
		//����Դ�����У����ݲ�����Ψһ��ʶ���õ�����������ֵ
		int operIndex = resource.getOperIndexBySn(operSn);
		
		AuthVO vo = searchAcl(user, resource.getResourceType(), 
				resource.getResourceId(), operIndex);
		
		if(vo != null && vo.isPermit()){
			return true;
		}
		
		return false;
	}

}
