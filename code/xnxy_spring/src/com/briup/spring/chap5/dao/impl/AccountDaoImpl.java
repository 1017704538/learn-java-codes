package com.briup.spring.chap5.dao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.briup.spring.chap5.dao.AccountDao;

/**
 * ת�˵�dao��ӿ�ʵ��
 * */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao{

	@Override
	public void outMoney(String out, Double money) {
		String sql = "update account set money = money - ?  where name = ?";
		this.getJdbcTemplate().update(sql, money,out);
		
	}

	@Override
	public void inMoney(String in, Double money) {
		String sql = "update account set money = money + ?  where name = ?";
		this.getJdbcTemplate().update(sql, money,in);
	}

}
