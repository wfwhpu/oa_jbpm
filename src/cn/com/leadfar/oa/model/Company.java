package cn.com.leadfar.oa.model;

import java.util.ArrayList;
import java.util.List;

public class Company extends Party {
	
	/**
	 * �绰
	 */
	private String tel;
	
	/**
	 * ����
	 */
	private String fax;
	
	/**
	 * ��ַ
	 */
	private String address;
	
	/**
	 * �ʱ�
	 */
	private String postcode;
	
	/**
	 * ��վ
	 */
	private String site;
	
	/**
	 * �����ʼ�
	 */
	private String email;
	
	/**
	 * ������ҵ
	 */
	private String industry;

	@Override
	public String getPrincipalType() {
		return "Company";
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	
}
