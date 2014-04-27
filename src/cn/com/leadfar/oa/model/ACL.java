package cn.com.leadfar.oa.model;

public class ACL {
	private int id;
	private String principalType;
	private int principalId;
	private String resourceType;
	private int resourceId;
	private int aclState;
	private int aclTriState;
	
	public void setPermission(int index,boolean permit,boolean ext){
		if(index < 0 || index > 31){
			throw new RuntimeException("��������ֵ����");
		}
		if(ext){
			//Ҫ����aclTriState��Ӧ��λΪ1����ʾ�̳�
			aclTriState = setBit(aclTriState,index,true);
		}else{
			//Ҫ����aclTriState��Ӧ��λΪ0����ʾ���̳�
			aclTriState = setBit(aclTriState,index,false);
		}
		
		//����aclState��Ӧλ��ȡֵ��
		aclState = setBit(aclState,index,permit);
	}
	
	public boolean isPermit(int index){
		return getBit(aclState,index);
	}
	
	public boolean isExt(int index){
		return getBit(aclTriState,index);
	}
	
	/**
	 * ��ĳ��int���͵�ֵ�ĵ�indexλ��Ϊ1��0
	 * @param i ĳ����Ҫ�ı��ֵ
	 * @param index �ڼ�λ
	 * @param value true��ʾ��Ϊ1��false��ʾ��Ϊ0
	 * @return
	 */
	private int setBit(int i,int index,boolean value){
		int temp = 1;
		temp = temp << index;
		if(value){ //���Ҫ����һλ����Ϊ1
			i = i | temp;
		}else{ //���Ҫ����һλ����Ϊ0
			temp = ~temp;
			i = i & temp;
		}
		return i;
	}
	
	private boolean getBit(int i,int index){
		int temp = 1;
		temp = temp << index;
		temp = i & temp;
		if(temp == 0){
			return false;
		}else{
			return true;
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrincipalType() {
		return principalType;
	}
	public void setPrincipalType(String principalType) {
		this.principalType = principalType;
	}
	public int getPrincipalId() {
		return principalId;
	}
	public void setPrincipalId(int principalId) {
		this.principalId = principalId;
	}
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	public int getResourceId() {
		return resourceId;
	}
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}
	public int getAclState() {
		return aclState;
	}
	public void setAclState(int aclState) {
		this.aclState = aclState;
	}
	public int getAclTriState() {
		return aclTriState;
	}
	public void setAclTriState(int aclTriState) {
		this.aclTriState = aclTriState;
	}
}
