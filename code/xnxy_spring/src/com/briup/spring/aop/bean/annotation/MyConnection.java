package com.briup.spring.aop.bean.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;

@Configuration
@ImportResource("classpath:com/briup/spring/chap4/config.xml")  //ָ�������ļ���·��
public class MyConnection {
	
	
	@Value("${jdbc.url}")  //�������͵ı���ʹ��@Valueע��(���������ע���ֵ)  ������ʹ��${�Ƕ�ȡ��db.properties�е�ֵ}
	private String url;
	
	@Value("${jdbc.username}")  //Ĭ��ȡ���ǵ�ǰ����ϵͳ�û������ƣ�������db.properties����username��ʱ��ʹ��jdbc.username
	private String userName;
	
	@Value("${jdbc.password}")
	private String password;
	
	@Bean(name="myDriverManager")
	@Scope("singleton")  //@Bean������@Scope���ʹ��
	public MyDriverManager MyDriverManager(){
		return new MyDriverManager(url,userName,password);
	}

}
