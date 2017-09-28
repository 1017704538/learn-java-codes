package com.briup.spring.aop.bean;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;


//���е�ApplicationContextʵ����ResourceLoader�ӿ�
public class ResourceTest implements ApplicationContextAware{
	
	private ApplicationContext ApplicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.ApplicationContext = applicationContext;
	}
	
	public void resource() throws IOException{
		//Resource resource = ApplicationContext.getResource("config.txt");//Ĭ��Ϊclasspath
		//Resource resource = ApplicationContext.getResource("classpath:config.txt");
		//Resource resource = ApplicationContext.getResource("file:D:\\workspace\\xnxy_spring\\src\\config.txt");
		Resource resource = ApplicationContext.getResource("url:http://repo.springsource.org/libs-release-local/org/springframework/spring/3.2.4.RELEASE/spring-framework-3.2.4.RELEASE-dist.zip");
		System.out.println(resource.getFilename());//��ȡ�ļ���
		System.out.println(resource.contentLength()); //��ȡ�ļ�����
		System.out.println(resource.getInputStream());//��ȡ������
	}
}
