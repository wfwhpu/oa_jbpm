package cn.com.leadfar.oa.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.com.leadfar.oa.model.Party;

/**
 * ��VO��Ϊ���ܹ���ҳ������ʾjsTree���������������ġ�
 * ����jsTree����JSON��ʽ����Ҫ��������ص����ԡ�
 * 
 * ����֯�������й���ʱ�õ�
 * @author Lee
 *
 */
public class PartyTreeVO {
	private String data;
	private Map attr = new HashMap();
	private List children = new ArrayList();
	
	public PartyTreeVO(Party p){
		this.data = p.getName();
		
		//���ڵ��������
		attr.put("id", p.getId()); //���������Ǳ���ģ�������ˢ�µ�ʱ�򣬱���ס��״̬�Ĺؼ���������
		attr.put("partyId", p.getId());
		attr.put("partyType", p.getClass().getSimpleName().toLowerCase());
		
		Set parties = p.getChildren();
		for (Iterator iterator = parties.iterator(); iterator.hasNext();) {
			Party subparty = (Party) iterator.next();
			PartyTreeVO ptv = new PartyTreeVO(subparty);
			children.add(ptv);
		}
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
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
