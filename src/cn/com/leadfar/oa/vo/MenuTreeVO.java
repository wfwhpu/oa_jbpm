package cn.com.leadfar.oa.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.com.leadfar.oa.model.Menu;

/**
 * ���ڲ˵�����Ĳ˵���
 * @author Lee
 *
 */
public class MenuTreeVO {
	//private String data;
	private Map data = new HashMap();
	private Map attr = new HashMap();
	private List children = new ArrayList();
	
	public MenuTreeVO(Menu m){
		//this.data = m.getName();
		this.data.put("title", m.getName());
		Map linkAttr = new HashMap();
		linkAttr.put("menuId", m.getId());
		this.data.put("attr", linkAttr);
		
		//���ڵ��������
		attr.put("id", m.getId()); //���������Ǳ���ģ�������ˢ�µ�ʱ�򣬱���ס��״̬�Ĺؼ���������
		attr.put("menuId", m.getId());
		
		Set submenus = m.getChildren();
		for (Iterator iterator = submenus.iterator(); iterator.hasNext();) {
			Menu submenu = (Menu) iterator.next();
			MenuTreeVO mtv = new MenuTreeVO(submenu);
			children.add(mtv);
		}
	}
	
	public Map getData() {
		return data;
	}

	public void setData(Map data) {
		this.data = data;
	}

	//	public String getData() {
//		return data;
//	}
//	public void setData(String data) {
//		this.data = data;
//	}
	public List getChildren() {
		return children;
	}
	public void setChildren(List children) {
		this.children = children;
	}

	public Map getAttr() {
		return attr;
	}

	public void setAttr(Map attr) {
		this.attr = attr;
	}
}
