package cn.com.leadfar.oa.model;

import java.util.List;

public class Role implements Principal{
	private int id;
	private String name;
	
	@Override
	public List<Principal> getParentPrincipal() {
		//��ɫ�ͽ�ɫ֮��û�и��ӹ�ϵ
		return null;
	}
	@Override
	public int getPrincipalId() {
		return id;
	}

	@Override
	public String getPrincipalType() {
		return "Role";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
