package cn.com.leadfar.oa.dao;

import java.util.List;

import cn.com.leadfar.oa.model.ACL;
import cn.com.leadfar.oa.model.Principal;
import cn.com.leadfar.oa.model.SysResource;

public interface AclDao extends BaseDao{
	
	/**
	 * ɾ��ĳ�����������ĳ����Դ���͵�������Ȩ
	 * @param principalType
	 * @param principalId
	 * @param resourceType
	 */
	public void delAcls(String principalType, int principalId,
			String resourceType);
	
	/**
	 * ��ѯACL����
	 * @param principalType
	 * @param principalId
	 * @param resourceType
	 * @param resourceId
	 * @return
	 */
	public ACL findACL(String principalType,int principalId,String resourceType,int resourceId);

	/**
	 * ����ֱ�ӷ����ĳ�������ĳ����Դ���͵�������Ȩ��¼
	 * @param principalType
	 * @param principalId
	 * @param resourceType
	 * @return
	 */
	public List<ACL> findAcls(String principalType,int principalId,String resourceType);
	
	/**
	 * ��ѯĳ�����͵�������Դ����
	 * @param resourceType
	 * @return
	 */
	public List<SysResource> findAllSysResources(String resourceType);
	
	/**
	 * �����������ͺ�����ID��ѯ�������
	 * @param principalType
	 * @param principalId
	 * @return
	 */
	public Principal findPrincipal(String principalType,int principalId);
	
	/**
	 * ������Դ��Ψһ��ʶ��ѯ��Դ����
	 * @param resourceSn
	 * @return
	 */
	public SysResource findSysResourceBySn(String resourceSn);
}
