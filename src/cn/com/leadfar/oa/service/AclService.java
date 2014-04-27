package cn.com.leadfar.oa.service;

import java.util.List;

import cn.com.leadfar.oa.vo.AuthVO;

public interface AclService {
	
	/**
	 * ��ѯĳ���������ĳ�����ͣ�������Menu��Դ����ActionResource��Դ������Դ����Ȩ���
	 * 
	 * @param principalType �������ͣ����磺Role/User/Position/Department
	 * @param principalId ����ID
	 * @param resourceType ��Դ����
	 * @return [��ԴID��������ʶ(CREATE/UPDATE/DELETE/READ�������κ��Զ����ֵ)������״̬(true/false)���Ƿ�̳�(true/false)]
	 */
	public List findAclList(String principalType,int principalId,String resourceType);
	
	/**
	 * ��ĳ��������Ȩ
	 * @param principalType ��������
	 * @param principalId ����ID
	 * @param acls ��Ȩ�б�
	 */
	public void addOrUpdatePermission(String principalType,int principalId,String resourceType,List<AuthVO> acls);
	
	/**
	 * ��ѯĳ���û���һ���ǵ�ǰ��¼�û������з���Ȩ�޵Ĳ˵���Դ
	 * ��¼�Ժ�����ʾ����˵���ʱ�򣬽����ñ�����
	 * @param userId
	 * @return
	 */
	public List findPermitMenus(int userId);
	
	/**
	 * �ж�ĳ���û����Ƿ�ӵ�ж�ĳ����Դ��ĳ������
	 * @param userId
	 * @param resourceSn
	 * @param operSn
	 * @return
	 */
	public boolean hasPermission(int userId,String resourceSn,String operSn);
	
}
