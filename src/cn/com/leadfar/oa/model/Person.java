package cn.com.leadfar.oa.model;

public class Person extends Party {
	
	/**
	 * Ա�����
	 */
	private String snumber;
	
	/**
	 * �Ա�
	 */
	private String sex;
	
	/**
	 * �ֻ�
	 */
	private String phone;
	
	/**
	 * ְ��
	 */
	private String duty;
	
	/**
	 * ��ַ
	 */
	private String address;
	
	/**
	 * QQ��
	 */
	private String qq;
	
	/**
	 * MSN
	 */
	private String msn;
	
	/**
	 * �����ʼ�
	 */
	private String email;

	/**
	 * ��Ӧ�ĵ�¼�ʺ�
	 */
	private User user;
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSnumber() {
		return snumber;
	}
	public void setSnumber(String snumber) {
		this.snumber = snumber;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getMsn() {
		return msn;
	}
	public void setMsn(String msn) {
		this.msn = msn;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
