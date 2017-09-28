package com.briup.spring.aop.bean.annotation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.spring.aop.bean.annotation.dao.InjeactionDAO;
import com.briup.spring.aop.bean.annotation.service.InjeactionService;

//ҵ���߼����ע��
@Service("injeactionServiceImpl")
public class InjeactionServiceImpl implements InjeactionService {
	
	//ʹ��autowired ע���Ա���Ե�ֵ������ʡ��getxx setxx����
	@Autowired
	private InjeactionDAO injeactionDAO;
	
	
	//setterע��ͬ�ϱ�����һ��
	@Autowired
	public void setInjeactionDAO(InjeactionDAO injeactionDAO) {
		this.injeactionDAO = injeactionDAO;
	}
	
	//����ע��ͬ����ע��һ��
	@Autowired
	public InjeactionServiceImpl(InjeactionDAO injeactionDAO) {
		this.injeactionDAO = injeactionDAO;
	}

	@Override
	public void save(String arg) {
		//ģ��ҵ�����
		System.out.println("Service���ղ���"+arg);
		injeactionDAO.save(arg);

	}

}
