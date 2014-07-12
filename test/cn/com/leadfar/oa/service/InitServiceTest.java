package cn.com.leadfar.oa.service;

import java.io.File;

import junit.framework.TestCase;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InitServiceTest extends TestCase {

	BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext-*.xml");
	
	public void testAddInitDatas() {
		InitService is = (InitService)factory.getBean("initService");
		is.addInitDatas();
	}

}
