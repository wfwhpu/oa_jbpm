package cn.com.leadfar.oa.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ActionResource implements SysResource {
	
	private int id;
	
	/**
	 * ��Դ����Ӧ��Action�����������ж������"|"������
	 */
	private String className;
	
	/**
	 * ��Դ�����������磺
	 * ��֯�����������Ĺ���
	 */
	private String name;
	
	/**
	 * ��Դ��Ψһ��ʶ
	 * ���磺
	 * org,document�ȵ�
	 */
	private String sn;
	
	/**
	 * ����Դ��Ψһ��ʶ
	 * ���磺
	 * party
	 */
	private String parentSn;
	
	/**
	 * �����
	 */
	private int orderNumber;
	
	/**
	 * ��Դ�������Ĳ���
	 * key�ǲ�����Ψһ��ʶ�����Ƿ��������磺UPDATE,DEL,READ,CREATE
	 */
	private Map<String,ActionMethodOper> opers;

	/**
	 * ����Դ
	 */
	private ActionResource parent;
	
	private Set<ActionResource> children;
	
	@Override
	public int getResourceId() {
		return id;
	}

	@Override
	public int[] getOpersIndex() {
		if(opers != null){
			Collection<ActionMethodOper> amo = opers.values();
			int[] opersIndex = new int[amo.size()];
			int i = 0;
			for(ActionMethodOper o:amo){
				opersIndex[i++] = o.getOperIndex();
			}
			return opersIndex;
		}
		return null;
	}

	@Override
	public String getResourceType() {
		return "ActionResource";
	}

	@Override
	public List<SysResource> getChildrenResource() {
		if(children != null){
			List<SysResource> cs = new ArrayList<SysResource>();
			cs.addAll(children);
			return cs;
		}
		return null;
	}

	@Override
	public int getOperIndexBySn(String operSn) {
		return opers.get(operSn).getOperIndex();
	}
	
	/**
	 * ���ݷ��������õ���Ӧ�Ĳ�����Ψһ��ʶ
	 * @param methodName
	 * @return
	 */
	public String getOperSnByMethodName(String methodName){
		if(opers == null){
			return null;
		}
		for( ActionMethodOper amo : opers.values() ){
			if(contains(amo.getMethodName(),methodName)){
				return amo.getOperSn();
			}
		}
		return null;
	}
	
	/**
	 * amoMethodName�ַ����Ƿ������methodName�ַ���
	 * amoMethodName�ַ����ĸ�ʽ�ǣ�
	 * add|addInput|...
	 * @param amoMethodName
	 * @param methodName
	 * @return
	 */
	private boolean contains(String amoMethodName,String methodName){
		//����"|"����������
		String[] allMethods = amoMethodName.split("\\|");
		for(String m:allMethods){
			if(m.equals(methodName)){
				return true;
			}
		}
		return false;
	}

	public void addClassName(String clsName){
		if(this.className == null){
			this.className = clsName;
		}else{
			this.className = this.className + "|" + clsName;
		}
	}
	
	public void addActionMethodOper(String methodName,String operName,String operSn,int operIndex){
		if(opers == null){
			opers = new HashMap();
		}
		ActionMethodOper amo = opers.get(operSn);
		if(amo != null){
			amo.addMethodName(methodName);
		}else{
			
			//���ȣ��ж�����ֵ�Ƿ��Ѵ��ڣ�����Ѿ����ڣ����׳��쳣���������ظ�
			for(ActionMethodOper o:opers.values()){
				if(o.getOperIndex() == operIndex){
					throw new RuntimeException("�����Դ��"+name+"���Ĳ���" +
							"��"+o.getOperName()+"���Ѿ���������"+o.getOperIndex()+"���󶨣�" +
									"�޷��ٴΰ�һ���µĲ�����"+operName+"���󶨵�������ֵ");
				}
			}
			
			amo = new ActionMethodOper();
			amo.setMethodName(methodName);
			amo.setOperName(operName);
			amo.setOperIndex(operIndex);
			amo.setOperSn(operSn);
			opers.put(operSn, amo);
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public Map<String, ActionMethodOper> getOpers() {
		return opers;
	}

	public void setOpers(Map<String, ActionMethodOper> opers) {
		this.opers = opers;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public ActionResource getParent() {
		return parent;
	}

	public void setParent(ActionResource parent) {
		this.parent = parent;
	}

	public Set<ActionResource> getChildren() {
		return children;
	}

	public void setChildren(Set<ActionResource> children) {
		this.children = children;
	}

	public String getParentSn() {
		return parentSn;
	}

	public void setParentSn(String parentSn) {
		this.parentSn = parentSn;
	}
}
