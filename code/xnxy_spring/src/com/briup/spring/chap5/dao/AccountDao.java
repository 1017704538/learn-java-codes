package com.briup.spring.chap5.dao;

/**
 * ת�˵�dao��ӿ�
 * */
public interface AccountDao {
	
	/**
	 * @param out ת���˻�
	 * @param money ת�˽��
	 * */
	public void outMoney(String out,Double money);
	
	/**
	 * @param in ת���˻�
	 * @param money ת�˽��
	 * */
	public void inMoney(String in,Double money);

}
