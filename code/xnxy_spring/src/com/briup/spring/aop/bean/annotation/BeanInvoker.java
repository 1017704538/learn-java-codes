package com.briup.spring.aop.bean.annotation;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BeanInvoker {
	
	@Autowired
	private List<BeanInterface> list;
	
	@Autowired
	private Map<String, BeanInterface> map;
	
	@Autowired
	@Qualifier("beanImplOne")  //BeanInterface���������࣬���Դ��ڶ��@Autowired���ڶ��bean��������Ҫ���@Qualifier("beanName")ע���Ǹ�
	private BeanInterface beanInterface;
	
	public void print(){
		if(list != null && 0 != list.size()){
			System.out.println("list...");
			for(BeanInterface beanInterface:list){
				System.out.println(beanInterface.getClass().getName());
			}
		}
		if(map != null && 0 != map.size()){
			System.out.println("map...");
			Set<Entry<String, BeanInterface>> entrySet = map.entrySet();
			for(Entry<String, BeanInterface> entry: entrySet){
				System.out.println(entry.getKey()+"--"+entry.getValue().getClass().getName());
			}
		}
		
		System.out.println(beanInterface);
	}
	
	

}
