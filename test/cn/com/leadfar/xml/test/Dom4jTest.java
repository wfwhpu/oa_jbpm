package cn.com.leadfar.xml.test;

import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import junit.framework.TestCase;

public class Dom4jTest extends TestCase {
	
	//采用DOM方式来解释XML文档
	public void testReadXml01() throws Exception{
		
		Document document = new SAXReader().read(this.getClass().getResourceAsStream("demo.xml"));
		
		//使用XPATH来访问XML文档
		//要使用XPATH，请加入XPATH的实现包：jaxen
		List nodes = document.selectNodes("//name");
		for (Iterator iterator = nodes.iterator(); iterator.hasNext();) {
			Element e = (Element) iterator.next();
			System.out.println(e.getText());
		}
	}
	
	public void testReadXml02() throws Exception{
		
		Document document = new SAXReader().read(this.getClass().getResourceAsStream("demo.xml"));
		
		List nodes = document.selectNodes("//person");
		for (Iterator iterator = nodes.iterator(); iterator.hasNext();) {
			Element e = (Element) iterator.next();
			System.out.println(e.attributeValue("personid"));
		}
	}
	
	public void testReadXml03() throws Exception{
		
		Document document = new SAXReader().read(this.getClass().getResourceAsStream("demo.xml"));
		
		List nodes = document.selectNodes("//person");
		for (Iterator iterator = nodes.iterator(); iterator.hasNext();) {
			Element e = (Element) iterator.next();
			//List list = e.selectNodes("name");
			List list = e.elements("name");
			for (Iterator iterator2 = list.iterator(); iterator2.hasNext();) {
				Element e1 = (Element) iterator2.next();
				System.out.println(e1.getName());
			}
		}
	}
}
