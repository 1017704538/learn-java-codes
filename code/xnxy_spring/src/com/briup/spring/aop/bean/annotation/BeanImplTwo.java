package com.briup.spring.aop.bean.annotation;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)  //Order����ע��ֻ��list,�����鼯����Ч
@Component
public class BeanImplTwo implements BeanInterface {

}
