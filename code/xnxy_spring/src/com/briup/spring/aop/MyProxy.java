package com.briup.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//������ ---��̬����ʵ��InvocationHandler ��֪������˭--����֪��ί������˭
public class MyProxy implements InvocationHandler{

	private Object target;//���ڲ�֪��ί������˭����������Object����
	
	public MyProxy() {}

	public MyProxy(Object target) {
		this.target = target;
	}
	public void before(){
		System.out.println("���");
	}
	//��������õķ������÷���������Լ����߼�
	@Override
	public Object invoke(Object obj, Method method, Object[] args)
			throws Throwable {
		before();
		//ʹ�÷����ȡ���� Ҫ����߼��ķ���
		//invoke�е�һ������˭ִ�� ί���� target
		//�ڶ���������ʾ�����Ĳ���
		method.invoke(target, args);
		return null;
	}

}
