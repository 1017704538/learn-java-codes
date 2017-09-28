package com.briup.spring.aop;

import java.lang.reflect.Proxy;


public class DnyProxy {
	public static void main(String[] args) {
		User user = new User();
		user.setName("tom");
		//ί����
		UserDao userDao = new UserDaoImpl();
		//������
		MyProxy proxy = new MyProxy(userDao);
		//��һ������ ί����ļ�����classLoader�����ȡ������
		//�ڶ������� ��ȡί����ʹ�����ʵ�ֵĹ�ͬ�Ľӿ�
		//���������� �����ʵ������
		userDao = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(), 
				userDao.getClass().getInterfaces(), proxy);
		userDao.saveUser(user); //userDao���õ��Ǵ������е�invoke();
	}
}
