package cn.com.leadfar.oa.dao;

import java.util.List;

import cn.com.leadfar.oa.model.ActionResource;

public interface ResourceDao extends BaseDao{
	public void delAllActionResources();
	public ActionResource findActionResourceBySn(String sn);
	
	/**
	 * ��������ѯ���е�ActionResource����
	 * @return
	 */
	public List<ActionResource> findAll();
	
	/**
	 * �������ж�����ActionResource���󣨼�û��parent��ActionResource����
	 * @return
	 */
	public List<ActionResource> findAllTopActionResource();
	
	public void update(ActionResource ar);
	
	/**
	 * ����ȫ·�����������Ҷ�Ӧ��ActionResource����
	 * @param className ȫ·������
	 * @return
	 */
	public ActionResource findByClassName(String className);
}
