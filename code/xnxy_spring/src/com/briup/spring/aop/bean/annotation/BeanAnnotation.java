package com.briup.spring.aop.bean.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


//���ڲ�֪����������DAO��Service����ʹ��ͨ��ע��
//@Component -->Ĭ��ʹ������Сд��Ϊbean��name
@Scope("prototype") //������ΪScope�ķ�Χ,��������Ϊԭ��ģʽ
@Component("beanAnnotation")
public class BeanAnnotation {
	
	public void say(String arg){
		System.out.println("BeanAnnotation: "+arg);
	}

}
