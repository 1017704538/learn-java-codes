package com.briup.orm;

public class TestSession {
	public static void main(String[] args) throws Exception {
		Student s = new Student();
		s.setId(10);
		s.setName("s1");
		s.setAge(1);
		SessionTest session = new SessionTest();//��Session�������Լ������Session
		session.save(s);

	}
}
