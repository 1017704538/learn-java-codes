package com.briup.spring.aop.bean.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StoreConfig {

	
	
	//initMethod����desotryMethod��BeanImplOne��ߵķ���
	@Bean(name="beanImplOne",initMethod="init",destroyMethod="destory")  //���û��ָ��Bean��name���ԣ���bean��nameĬ��Ϊ����������
	public BeanInterface BeanImplOne(){
		return new BeanImplOne();
	}
}
