package com.briup.spring.chap5.service.impl;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import com.briup.spring.chap5.dao.AccountDao;
import com.briup.spring.chap5.service.AccountService;

/**
 * ת��ҵ��ӿڵľ���ʵ��
 * 
 * @Transactional��ע������ԣ�
 * propagation:����Ĵ�����Ϊ
 * isolation:����ĸ��뼶��
 * readOnly:�Ƿ�ֻ��
 * rollbackFor��������Щ�쳣�ع�
 * noRollbackFor:������Щ�쳣���ع�
 * */
@Transactional(propagation=Propagation.REQUIRED,readOnly=true,rollbackFor={RuntimeException.class, Exception.class})
public class AccountServiceImpl2 implements AccountService {
	
	private AccountDao accountDao;
	
	
	private TransactionTemplate transactionTemplate;  //�������ģ��
		

	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}



	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}



	public AccountDao getAccountDao() {
		return accountDao;
	}



	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}


	@Override
	public void transfer(final String out, final String in, final Double money) {
		accountDao.outMoney(out, money);
		//int i = 1/0;
		accountDao.inMoney(in, money);
	}

}
