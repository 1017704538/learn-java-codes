package com.briup.test;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.briup.spring.aop.bean.AwareTest;
import com.briup.spring.aop.bean.ResourceTest;
import com.briup.spring.aop.bean.annotation.BeanAnnotation;
import com.briup.spring.aop.bean.annotation.BeanInvoker;
import com.briup.spring.aop.bean.annotation.service.InjeactionService;
import com.briup.spring.ioc.UserService;
import com.briup.spring.ioc.bean.Car;
import com.briup.spring.ioc.bean.Coll;
import com.briup.spring.ioc.bean.Life;
import com.briup.spring.ioc.bean.Student;
import com.briup.spring.ioc.bean.Teacher;
import com.briup.spring.ioc.bean.User;


public class SpringTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("BeforeClass ��ע�ķ��� �������ȱ�ִ��");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("AfterClass ��ע�ķ��� �����ִ��");
	}

	@Test
	public void test() {
		System.out.println("test");
		//·���Ƚ�����
		BeanFactory factory = new ClassPathXmlApplicationContext("com/briup/spring/chap1/ioc.xml");
		UserService service = (UserService) factory.getBean("service");
		service.getUserDao().save();
	}
	@Test
	public void test2() {
		BeanFactory factory = new ClassPathXmlApplicationContext("com/briup/spring/chap1/set.xml");
		//User user = (User) factory.getBean("user");
		//User user = (User) factory.getBean("user",User.class);
		//User user = (User) factory.getBean(User.class); //ֻ��Ψһ��bean��ʱ���ʹ�����ַ�ʽ
		//System.out.println(user);
		System.out.println(factory.getType("user")); //��ȡuserʵ��������
		User user = (User) factory.getBean("user"); 
		User user2 = (User) factory.getBean("user");
		System.out.println(user == user2);//true -- ����  --���ǿ��Կ��Ƶ��������ļ��� bean scope="prototype"-->����ԭ��ģʽ ��ʱ�������false
		System.out.println(factory.isPrototype("user"));//�Ƿ�Ϊԭ��     false
		System.out.println(factory.isSingleton("user"));//�Ƿ�Ϊ����     true
		
		System.out.println(factory.isTypeMatch("user", User.class));//�ж� userʵ���Ƿ�Ϊ�������� true
		
		String[] str = factory.getAliases("user"); //��ȡ����  
		for(int i=0;i<str.length;i++){
			System.out.println(str[i]);
		}
	}
	
	/*
	 * ���ù��������� constructor-arg
	 * */
	@Test
	public void test3() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/briup/spring/chap1/constructor.xml");
		Teacher teacher = (Teacher) ac.getBean("teacher");
		System.out.println(teacher);//Teacher [id=1, name=tom, gender=male]
	}
	
	/*
	 * ��������
	 * */
	@Test
	public void test4() {
	
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/briup/spring/chap1/coll.xml");
		ClassPathResource resource = new ClassPathResource("classpath:coll.xml");
		XmlBeanFactory factory = new XmlBeanFactory(resource);
		Coll coll = factory.getBean("coll",Coll.class);
		//coll.printList();
		coll.printSet();
		//coll.printMap();
		//coll.printProperties();
	}
	@Test
	public void test5(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/briup/spring/chap1/autowire.xml");
		Student student = ac.getBean("student",Student.class);
		System.out.println(student);
	}
	@Test
	public void test6(){
		BeanFactory factory = new ClassPathXmlApplicationContext("com/briup/spring/chap1/abstract.xml");
		//Car car = (Car) factory.getBean("car"); abstract=true����ֱ�ӻ�ȡʵ��
		Car car = factory.getBean("car1",Car.class);
		System.out.println(car);
	}
	@Test
	public void test7(){
		BeanFactory factory = new ClassPathXmlApplicationContext("com/briup/spring/chap1/connection.xml");
		Connection connection = (Connection) factory.getBean("conn");
		System.out.println(connection);
	}
	
	@Test
	public void life(){//springBean����������	
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("com/briup/spring/chap2/life.xml");
		Life life = ac.getBean("life",Life.class);
		System.out.println(life);
		ac.destroy();
	}
	
	@Test
	public void AwareTest(){
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("com/briup/spring/chap1/aware.xml");
		AwareTest awareTest = ac.getBean("applicationAawareTest",AwareTest.class);
		System.out.println(awareTest);
	}
	
	@Test
	public void ResourceTest(){
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("com/briup/spring/chap1/resources.xml");
		ResourceTest resourceTest = ac.getBean("resourcetest",ResourceTest.class);
		try {
			resourceTest.resource();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void convertor(){//�Զ���ת����
		BeanFactory factory = new ClassPathXmlApplicationContext("com/briup/spring/chap2/edit.xml");
		Student student = factory.getBean("student",Student.class);
		System.out.println(student);
	}
	
	
	
	@Test
	public void testAnnotation(){
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("com/briup/spring/chap4/annotation.xml");
		//@Componentû��valueֵ��Ĭ��ʹ����������ĸСд��Ϊbean��id
		BeanAnnotation beanAnnotation1  = ac.getBean("beanAnnotation",BeanAnnotation.class);
		BeanAnnotation beanAnnotation2  = ac.getBean("beanAnnotation",BeanAnnotation.class);
		System.out.println(beanAnnotation1);
		System.out.println(beanAnnotation2);
		
		//com.briup.spring.aop.bean.annotation.BeanAnnotation@1598d5f
		//com.briup.spring.aop.bean.annotation.BeanAnnotation@505fd8
	}
	
	@Test
	public void testAutowired(){
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("com/briup/spring/chap4/annotation.xml");
		InjeactionService injeactionService = (InjeactionService) ac.getBean("injeactionServiceImpl");
		injeactionService.save("this is autowired");
	}
	
	@Test
	public void testAutowired2(){
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("com/briup/spring/chap4/annotation.xml");
		BeanInvoker beanInvoker = (BeanInvoker) ac.getBean("beanInvoker");
		beanInvoker.print();
	}
	
	@Test
	public void testBean(){
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("com/briup/spring/chap4/annotation.xml");
		System.out.println(ac.getBean("beanImplOne"));
	}
	
	@Test
	public void testBean2(){
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("com/briup/spring/chap4/annotation.xml");
		System.out.println(ac.getBean("myDriverManager"));
		System.out.println(ac.getBean("myDriverManager"));
	}
	
	@Test
	public void testJsr(){
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("com/briup/spring/chap4/annotation.xml");
		System.out.println(ac.getBean("jsrService"));
		ac.destroy();
	}
	
	
	
}
