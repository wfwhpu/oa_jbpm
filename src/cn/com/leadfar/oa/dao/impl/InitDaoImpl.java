package cn.com.leadfar.oa.dao.impl;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import cn.com.leadfar.oa.dao.InitDao;
import cn.com.leadfar.oa.model.ACL;
import cn.com.leadfar.oa.model.ActionResource;
import cn.com.leadfar.oa.model.Menu;
import cn.com.leadfar.oa.model.Person;
import cn.com.leadfar.oa.model.Principal;
import cn.com.leadfar.oa.model.Role;
import cn.com.leadfar.oa.model.SysResource;
import cn.com.leadfar.oa.model.User;
import cn.com.leadfar.oa.model.UsersRoles;

@Repository("initDao")
public class InitDaoImpl extends BaseDaoImpl implements InitDao {

	@Override
	public void addInitAdmin() {

		getSession().flush();
		getSession().clear();
		
		//��ӳ�������Ա����Ա����¼�ʺţ�
		Person adminPerson = new Person();
		adminPerson.setName("��������Ա");
		getSession().save(adminPerson);
		User adminUser = new User();
		adminUser.setUsername("admin");
		adminUser.setPassword("admin");
		adminUser.setPerson(adminPerson);
		getSession().save(adminUser);
		
		//����ϵͳ����Ա��ɫ
		Role adminRole = new Role();
		adminRole.setName("ϵͳ����Ա");
		getSession().save(adminRole);
		
		//������ͨԱ����ɫ
		Role commonRole = new Role();
		commonRole.setName("��ͨԱ��");
		getSession().save(commonRole);
		
		//�ù���Ա�û�ӵ��ϵͳ����Ա��ɫ
		UsersRoles ur1 = new UsersRoles();
		ur1.setRole(adminRole);
		ur1.setUser(adminUser);
		getSession().save(ur1);
		
		//�ù���Ա�û�ӵ����ͨԱ����ɫ
		UsersRoles ur2 = new UsersRoles();
		ur2.setRole(commonRole);
		ur2.setUser(adminUser);
		getSession().save(ur2);
		
		//��ѯ����ϵͳ������ز˵�����ȫ��ز�������֯������ز���
		String hql = "select r from cn.com.leadfar.oa.model.SysResource r " +
				"where r.sn = 'system' or r.sn='security' or r.sn = 'party'";
		List<SysResource> res = getSession().createQuery(hql).list();
		for(SysResource r:res){
			saveAllPermitAcl(adminRole,r); //����ЩȨ��ȫ������ϵͳ����Ա��ɫ
			saveAllPermitAcl(adminUser,r); //����ЩȨ��ȫ���������Ա�û�
		}
		
		//���˰칫�빤������صĲ˵�����Դ
		hql = "select r from cn.com.leadfar.oa.model.SysResource r " +
			"where r.sn = 'personal' or r.sn='workflow'";
		res = getSession().createQuery(hql).list();
		for(SysResource r:res){
			saveAllPermitAcl(commonRole,r); //����ЩȨ��ȫ��������ͨԱ����ɫ
		}
//		hql = "select ar from ActionResource ar where ar.sn = 'security' or ar.sn = 'party'";
//		List<ActionResource> ars = getSession().createQuery(hql).list();
//		for(SysResource ar:ars){
//			saveAllPermitAcl(u,ar);
//		}
	}
	
	/**
	 * ��ĳ����Դ���󣨰����������Ӷ��󣩵����в���������Ȩ������principal����
	 * @param principal
	 * @param resource
	 */
	private void saveAllPermitAcl(Principal principal,SysResource resource){
		ACL acl = new ACL();
		acl.setPrincipalType(principal.getPrincipalType());
		acl.setPrincipalId(principal.getPrincipalId());
		acl.setResourceType(resource.getResourceType());
		acl.setResourceId(resource.getResourceId());
		acl.setAclState(-1); //ȫ������������
		acl.setAclTriState(0); //ȫ�����������̳�
		getSession().save(acl);
		
		List<SysResource> children = resource.getChildrenResource();
		if(children != null){
			for(SysResource c:children){
				saveAllPermitAcl(principal,c);
			}
		}
	}

}
