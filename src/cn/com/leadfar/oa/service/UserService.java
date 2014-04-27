package cn.com.leadfar.oa.service;

import java.util.List;

import cn.com.leadfar.oa.model.Person;
import cn.com.leadfar.oa.model.User;
import cn.com.leadfar.oa.vo.PagerVO;

public interface UserService {
	
	/**
	 * ����û�����
	 * @param user
	 */
	public void addUser(User user);
	
	/**
	 * ������û���Ϣ��ͬʱ�������û����ɫ֮��Ĺ���
	 * @param user
	 * @param roleIds
	 */
	public void addUser(User user,int[] roleIds);
	
	/**
	 * ɾ���û�����
	 * ��ע�⡿��ɾ���û�����ʱ�򣬽��Զ����û����ɫ֮��Ĺ���ɾ��
	 * @param userId
	 */
	public void delUser(int userId);
	
	/**
	 * �жϵ�¼�û���Ϣ
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String username,String password);
	
	/**
	 * �����û�����
	 * @param user
	 */
	public void updateUser(User user);
	
	/**
	 * �����û������ͬʱ�������û����ɫ֮��Ĺ���
	 * @param user
	 * @param roleIds
	 */
	public void updateUser(User user,int[] roleIds);
	
	/**
	 * ����username��ѯ�û�����
	 * @param username
	 * @return
	 */
	public User findUserByUsername(String username);
	
	/**
	 * ����ID��ѯ�û�����
	 * @param userId
	 * @return
	 */
	public User findUserById(int userId);
	
	/**
	 * ���ض��Ľ�ɫ���û�֮�佨������
	 * @param userId
	 * @param roleId
	 */
	public void addRoleToUser(int userId,int roleId);
	
	/**
	 * ɾ���ض��Ľ�ɫ���û�֮��Ĺ���
	 * @param userId
	 * @param roleId
	 */
	public void delRoleFromUser(int userId,int roleId);
	
	/**
	 * ������Ա��������ѯ����ԱID����Ա��������λ/�������ơ��û��ʺ�
	 * ����ѯ��Ҫ���ڡ��û����������桱������������ϣ���Ҫ��ʾ�����е���Ա�����ʺţ�����
	 * δ�����ʺŵ���Ա�����Է����ʺ�
	 * @param personName
	 * @return ���ص��б�Ԫ�������飺��ԱID����Ա��������λ/�������ơ��û��ʺ�
	 */
	public PagerVO findPersonUsers(String personName);
	
	/**
	 * ������Ա��������ѯ����ԱID����Ա����������ҳ
	 * ����ѯ��Ҫ���ڡ��û���Ȩ�����棬����������ϣ���Ҫ��ʾ�������ѷ����˵�¼�ʺŵ���Ա
	 * �б����ĳ����Ա��δ�����¼�ʺţ��������ѯ������
	 * @param personName ��Ա��������ѯ����
	 * @return ���ص��б�Ԫ�������飺��ԱID����Ա����
	 */
	public List findPersonsWithUser(String personName);
	
	/**
	 * ��ѯĳ���û�ӵ�еĽ�ɫID�б�
	 * @param userId
	 * @return
	 */
	public List<Integer> findRoleIdsOfUser(int userId);
}
