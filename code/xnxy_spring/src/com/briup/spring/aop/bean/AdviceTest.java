package com.briup.spring.aop.bean;

import java.util.Date;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AdviceTest implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation method) throws Throwable {
		System.out.println("������ʼִ��"+new Date());
		method.proceed();
		System.out.println("����ִ�����"+new Date());
		return null;
	}
	

}
