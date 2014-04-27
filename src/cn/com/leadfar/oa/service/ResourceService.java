package cn.com.leadfar.oa.service;

import java.util.List;

import cn.com.leadfar.oa.model.ActionMethodOper;
import cn.com.leadfar.oa.model.ActionResource;
import cn.com.leadfar.oa.model.Menu;

public interface ResourceService {
	
	/**
	 * ���������Լ��ؽ����е�ActionResource����
	 */
	public void rebuildActionResources();
	
	/**
	 * �������е�ActionResources����
	 * @return
	 */
	public List<ActionResource> findAllActionResources();
	
	/**
	 * �������ж�����ActionResources����
	 * @return
	 */
	public List<ActionResource> findAllTopActionResources();
	
	/**
	 * ���ActionResource
	 * @param ar
	 */
	public void addActionResource(ActionResource ar);
	
	/**
	 * ����ActionResource
	 * @param ar
	 */
	public void updateActionResource(ActionResource ar);
	
	/**
	 * ɾ��ActionResource
	 * @param actionResourceId
	 */
	public void delActionResource(int actionResourceId);
	
	/**
	 * ����ID��ѯActionResource����
	 * @param actionResourceId
	 * @return
	 */
	public ActionResource findActionResourceById(int actionResourceId);
	
	/**
	 * �������������Ҷ�Ӧ��ActionResource����
	 * @param className ȫ·������
	 * @return
	 */
	public ActionResource findActionResourceByClassName(String className);
	
	/**
	 * ɾ��ĳ����Դ��Ӧ��ĳ������
	 * @param actionResourceId
	 * @param operSn
	 */
	public void delActionResourceOper(int actionResourceId,String operSn);
	
	/**
	 * �����Դ��ĳ������
	 * @param actionResourceId
	 * @param oper
	 */
	public void addActionResourceOper(int actionResourceId,ActionMethodOper oper);
	
}
