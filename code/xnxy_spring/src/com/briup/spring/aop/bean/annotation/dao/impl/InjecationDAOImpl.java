package com.briup.spring.aop.bean.annotation.dao.impl;

import org.springframework.stereotype.Repository;

import com.briup.spring.aop.bean.annotation.dao.InjeactionDAO;


//dao�־ò�ע��
@Repository("InjeactionDAO")
public class InjecationDAOImpl implements InjeactionDAO {

	@Override
	public void save(String arg) {
		//ģ�����ݿⱣ������
		System.out.println("�������ݣ�"+arg);
		
	}

}
