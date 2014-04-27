package cn.com.leadfar.oa.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.com.leadfar.oa.model.ActionResource;
import cn.com.leadfar.oa.model.Menu;

/**
 * ��ActionResource���й����ʱ��չ��һ����
 * @author Lee
 *
 */
public class ActionResourceTreeVO {
	private String data;
	private Map attr = new HashMap();
	private List children = new ArrayList();
	
	public ActionResourceTreeVO(ActionResource ar){
		this.data = ar.getName();
		
		//���ڵ��������
		attr.put("id", ar.getId()); //���������Ǳ���ģ�������ˢ�µ�ʱ�򣬱���ס��״̬�Ĺؼ���������
		attr.put("resourceId", ar.getId());
		Set subres = ar.getChildren();
		for (Iterator iterator = subres.iterator(); iterator.hasNext();) {
			ActionResource subr = (ActionResource) iterator.next();
			ActionResourceTreeVO art = new ActionResourceTreeVO(subr);
			children.add(art);
		}		
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

	public Map getAttr() {
		return attr;
	}

	public void setAttr(Map attr) {
		this.attr = attr;
	}

	public List getChildren() {
		return children;
	}

	public void setChildren(List children) {
		this.children = children;
	}
}
