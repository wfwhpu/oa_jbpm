package cn.com.leadfar.oa.service;

import java.util.List;

import cn.com.leadfar.oa.model.Menu;

public interface MenuService {
	/**
	 * ��Ӳ˵���Դ
	 * @param menu
	 */
	public void addMenu(Menu menu);
	
	/**
	 * ���²˵���Դ
	 * @param menu
	 */
	public void updateMenu(Menu menu);
	
	/**
	 * ɾ���˵���Դ
	 * @param menuId
	 */
	public void delMenu(int menuId);
	
	/**
	 * ��ѯ�����ж����˵�
	 * @return
	 */
	public List<Menu> findAllTopMenus();
	
	public Menu findMenuById(int menuId);
	
	public List<Integer> findAllTopMenuIds();
}
