package com.briup.spring.aop.bean;

//ί����
public class UserDaoImpl implements UserDao {
/*
	@Override
	public void saveUser() throws RuntimeException{
		System.out.println("�����û�");
		throw new RuntimeException();
	}*/

	

	@Override
	public void saveUser(){
		System.out.println("�����û�");
	}
	
	@Override
	public void deleteUser() {
		System.out.println("ɾ���û�");
	}

	@Override
	public void updateUser() {
		System.out.println("�����û�");
	}

}
