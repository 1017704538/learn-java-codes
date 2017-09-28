package com.briup.spring.chap5;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.briup.spring.chap5.service.AccountService;

/**
 * ת�˲�����
 * */
public class SpringTransactionTest {
	
	
	/**
	 * 1���ʽ�������
	 * */
	@Test
	public void test1() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/briup/spring/chap5/applicationContext.xml");
		AccountService accountService = ac.getBean("accountService",AccountService.class);
		accountService.transfer("����", "����", 200.0);
	}
	/**
	 * 2����ʽ�������-�����������ʵ��
	 * */
	@Test
	public void test2() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/briup/spring/chap5/applicationContext2.xml");
		AccountService accountService = ac.getBean("accountServiceProxy",AccountService.class);
		accountService.transfer("����", "����", 200.0);
	}
	/**
	 * 3����ʽ�������-����AspectJʵ��
	 * */
	@Test
	public void test3() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/briup/spring/chap5/applicationContext3.xml");
		AccountService accountService = ac.getBean("accountService2",AccountService.class);
		accountService.transfer("����", "����", 200.0);
	}
	/**
	 * 4����ʽ�������-����ע���ʵ��
	 * */
	@Test
	public void test4() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/briup/spring/chap5/applicationContext4.xml");
		AccountService accountService = ac.getBean("accountService2",AccountService.class);
		accountService.transfer("����", "����", 200.0);
	}
}
