package com.briup.base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.briup.bean.Car;

public class HibernateBase {
		@Test
		public void test() {
			//1.����Configuration���󣬶�ȡ�����ļ���ӳ���ļ�
			/*	new Configuration()Ĭ���Ƕ�ȡhibernate.properties
			 *	����ʹ��configure()��ȡhibernate.cfg.xml
			 *
			 */
			Configuration cfg = new Configuration();
			//��src�²���hibernate.cfg.xml�ļ�
			cfg.configure();
			//2.����SessionFactory����
			/*
			 * ����SessionFactory
			 * һ�����ݿ��Ӧһ��SessionFactory 
			 * SessionFactory�����̰߳�ȫ�ġ�
			 */
			SessionFactory factory = cfg.buildSessionFactory();
			
			//3.����Session����-->ͨ��openSession()����һ���µ�Session
			//����session
			//�˴���session������web�е�session
			//sessionֻ������ʱ���Ž���concation,session�������档
			//session����󣬱���رա�
			//session�Ƿ��̰߳�ȫ��һ����һ������һ��session.
			Session session = factory.openSession();
			//4.��������
			//�ֶ���������(������hibernate.cfg.xml�����ļ��������Զ���������)
			Transaction tran = session.beginTransaction();
			//5.�������ݿ�
			Car car = new Car(100,"BYD",50000.0);
			/*
			 * �������ݣ��˴��������Ǳ�����������hibernate��������ĺô���
			 * ���ǲ���д��ô���JDBC���룬ֻҪ����session������������hibernat��δ��ڶ����ⲻ��Ҫ����ȥ��������
			 * ��Щ����hibernate����ɡ�����ֻҪ�����󴴽���󣬽���hibernate�Ϳ����ˡ�
			 */
			session.save(car);
			//Class c = car.getClass();
			//Object o = session.get(c, session);
			//System.out.println(o);
			//6.�����ύ
			tran.commit();
			//7.��Դ����
			session.close();
			factory.close();
		}
}	
