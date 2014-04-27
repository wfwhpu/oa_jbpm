package cn.com.leadfar.oa.model;

import org.apache.commons.lang.xwork.ArrayUtils;

/**
 * Action����������
 * @author Lee
 *
 */
public class ActionMethodOper {
	
	/**
	 * ��������ͬһ�ֲ������Զ�Ӧ�������
	 * ���磺addInput,add,del,update|updateInput
	 */
	private String methodName;
	
	/**
	 * ��������
	 * ���磺��ӡ�ɾ�������¡������ȵȵȵ�
	 */
	private String operName;
	
	/**
	 * ����Ψһ��ʶ��
	 * ���磺ADD,DEL,UPDATE,READ
	 */
	private String operSn;
	
	/**
	 * �����洢�������������ֵ������ڻ����0������С�ڻ����31
	 * ͬһ����Դ�������Ĳ����У�������ֵ��Ψһ�ģ��������ظ���
	 */
	private int operIndex;
	
	public void addMethodName(String mn){
		if(methodName == null){
			this.methodName = mn;
		}else{
			String[] methodNames = this.methodName.split("\\|");
			if(!ArrayUtils.contains(methodNames, mn)){
				this.methodName = this.methodName + "|" + mn;
			}
		}
	}
	
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getOperName() {
		return operName;
	}
	public void setOperName(String operName) {
		this.operName = operName;
	}
	public String getOperSn() {
		return operSn;
	}
	public void setOperSn(String sn) {
		this.operSn = sn;
	}
	public int getOperIndex() {
		return operIndex;
	}
	public void setOperIndex(int operIndex) {
		this.operIndex = operIndex;
	}
}
