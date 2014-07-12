package cn.com.leadfar.oa.service;

import java.util.List;
import java.util.Random;

import org.jbpm.api.Deployment;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.task.Task;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class LeaveServiceTest extends TestCase {

	BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext-*.xml");
	
	public void testDeployProcess() {
		LeaveService ls = (LeaveService)factory.getBean("leaveService");
		ls.deployProcess();
	}
	

}
