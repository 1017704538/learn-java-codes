package com.briup.spring.ioc.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;

public class Life implements BeanNameAware,BeanFactoryAware{
	private String name;
	
	public Life(){//һ���ؾͻ������
		System.out.println("�����޲ι�����");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("����setName����");
		this.name = name;
	}
	
	public void myInit() {
		System.out.println("����myInit����");
	}
	
	public void myDestory(){
		System.out.println("����myDestory����");
	}

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.println("����setBeanFactory����");
		
	}

	@Override
	public void setBeanName(String arg0) {
		System.out.println("����setBeanName����");
	}
	
	
	/**
	 * �����޲ι�����
����setName����
����setBeanName����
����setBeanFactory����
����myInit����
com.briup.spring.ioc.bean.Life@4f0b5b
����myDestory����
AfterClass ��ע�ķ��� �����ִ��

	 * 
	 * */
}
