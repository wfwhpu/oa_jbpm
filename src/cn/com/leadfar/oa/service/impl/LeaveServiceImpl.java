package cn.com.leadfar.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.RepositoryService;
import org.springframework.stereotype.Service;

import cn.com.leadfar.oa.model.Leave;
import cn.com.leadfar.oa.service.LeaveService;

@Service("leaveService")
public class LeaveServiceImpl implements LeaveService{

	@Resource
	private RepositoryService repositoryService;
	
	
	@Override
	public void addLeave(Leave leave) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deployProcess() {
		
		this.repositoryService
			.createDeployment()
			.addResourceFromClasspath("cn/com/leadfar/oa/jbpm/leave.jpdl.xml")
			.deploy();
		
	}

	@Override
	public void startProcess(int LeaveId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProcessDefinition> getAllProcess() {
		return this.repositoryService.createProcessDefinitionQuery().list();
	}

}
