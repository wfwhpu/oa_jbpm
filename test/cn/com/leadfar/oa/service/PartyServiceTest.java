package cn.com.leadfar.oa.service;

import java.util.Random;

import junit.framework.TestCase;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.leadfar.oa.model.Company;
import cn.com.leadfar.oa.model.Department;
import cn.com.leadfar.oa.model.Party;
import cn.com.leadfar.oa.model.Person;
import cn.com.leadfar.oa.model.Position;

public class PartyServiceTest extends TestCase {

	private BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext-*.xml");
	
	public void testAddParty() {
		PartyService ps = (PartyService)factory.getBean("partyService");
		
		Company c = new Company();
		c.setName("北京领航致远科技有限公司");
		ps.addParty(c);
		
		Department d = new Department();
		d.setName("技术部");
		d.setParent(c);
		ps.addParty(d);
		
		Position p = new Position();
		p.setName("高级工程师");
		p.setParent(d);
		ps.addParty(p);
		
		Person person = new Person();
		person.setName("张三");
		person.setParent(p);
		ps.addParty(person);
		
	}
	
	public void testAddSomePersons() {
		PartyService ps = (PartyService)factory.getBean("partyService");

		Party parent = new Party();
		parent.setId(2);
		
		for(int i=0; i<100; i++){
			Person p = new Person();
			p.setName("测试人员"+new Random().nextInt(9999));
			p.setSex("男");
			p.setPhone("8347837438");
			p.setDescription("kdjfdkjf");
			
			p.setParent(parent);
			
			ps.addParty(p);
		}
		
	}

}
