package com.briup.spring.aop;

//ί����
public class UserDaoImpl implements UserDao{

	@Override
	public void saveUser(User user){
		System.out.println("�����û�");
	}
	
}
