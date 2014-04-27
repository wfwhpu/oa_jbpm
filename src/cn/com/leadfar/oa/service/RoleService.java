package cn.com.leadfar.oa.service;

import java.util.List;

import cn.com.leadfar.oa.model.Role;
import cn.com.leadfar.oa.vo.PagerVO;

public interface RoleService {
	
	/**
	 * ��ӽ�ɫ
	 * @param role
	 */
	public void addRole(Role role);
	
	/**
	 * ����ID��ѯ��ɫ����
	 * @param roleId
	 * @return
	 */
	public Role findRoleById(int roleId);
	
	/**
	 * ɾ����ɫ����
	 * @param roleId
	 */
	public void delRole(int roleId);
	
	/**
	 * ���½�ɫ����
	 * @param role
	 */
	public void updateRole(Role role);
	
	/**
	 * ����������ѯ���еĽ�ɫ����
	 * ��ѯ������ƥ���ɫ������
	 * 
	 * ��������Ҫ���ڽ�ɫ�����������
	 * @param query ��ѯ����
	 * @return �����б��е�Ԫ�������飺��ɫID����ɫ����
	 */
	public PagerVO findAllRoles(String query);
	
	/**
	 * ������������ѯ�����еĽ�ɫ����
	 * @return
	 */
	public List<Role> findAllRoles();
}
