package cn.com.leadfar.oa.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.com.leadfar.oa.model.Menu;

/**
 * ��¼֮����ʾ�����˵������õ�VO����
 * @author Lee
 *
 */
public class AuthMenuTreeVO {

	private Map data = new HashMap();
	private Map attr = new HashMap();
	private List children = new ArrayList();
	
	public AuthMenuTreeVO(Menu m){

		//�˵�������
		this.data.put("title", m.getName());
		
		//�˵������ӵ�ַ
		Map linkAttr = new HashMap();
		linkAttr.put("href", m.getHref());
		this.data.put("attr", linkAttr);
		
		Set submenus = m.getChildren();
		for (Iterator iterator = submenus.iterator(); iterator.hasNext();) {
			Menu submenu = (Menu) iterator.next();
			AuthMenuTreeVO mtv = new AuthMenuTreeVO(submenu);
			children.add(mtv);
		}
	}
	
	public Map getData() {
		return data;
	}

	public void setData(Map data) {
		this.data = data;
	}

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
