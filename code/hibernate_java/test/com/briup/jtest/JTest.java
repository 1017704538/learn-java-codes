package com.briup.jtest;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JTest {
	/*
	  	ͨ��junit.Test�Ŀ������@Test��ǵķ���
	  	Test��ǵķ�������ֱ��ִ��
	  	���ͬʱ���ֶ��Test������ѡ���Ǹ�����ִ�У����ִ��ȫ��Test��Ƿ���
	  	ע�⣺���ִ��Test��ǵķ�������Before��After��ǵķ���һ����ִ��
	  *
	  */
	@Test   
	public void testA() {
		System.out.println("testA");
	}
	@Before
	public void testB() {
		System.out.println("testB");
	}
	@After
	public void testC() {
		System.out.println("testC");
	}
	
	/*public static void main(String[] args) {
	
	}*/
}
