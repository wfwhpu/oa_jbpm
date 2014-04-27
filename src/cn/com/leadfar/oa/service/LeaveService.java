package cn.com.leadfar.oa.service;

import java.util.List;

import org.jbpm.api.ProcessDefinition;

import cn.com.leadfar.oa.model.Leave;

public interface LeaveService {
	
	public void deployProcess();
	public void startProcess(int LeaveId);
	public void addLeave(Leave leave);
	public List<ProcessDefinition> getAllProcess();

}
