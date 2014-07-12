package cn.com.leadfar.oa.service;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class ResourceServiceTest extends TestCase {
	BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext-*.xml");
	
	//�����ع����е�����Դ
	public void testRebuildActionResources() {
		ResourceService rs = (ResourceService)factory.getBean("resourceService");
		rs.rebuildActionResources();
	}
}
