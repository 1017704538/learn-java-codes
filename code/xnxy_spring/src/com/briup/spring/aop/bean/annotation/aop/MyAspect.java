package com.briup.spring.aop.bean.annotation.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/*
 * ����һ��������
 * */
public class MyAspect {
	
	public void before(){
		System.out.println("aspect before");
	}

	public void afterReturning(){
		System.out.println("aspect afterReturning");
	}
	
	public void afteThrowing(){
		System.out.println("aspect afteThrowing");
	}
	
	public void after(){
		System.out.println("aspect after(finally)");
	}
	
	public void around(ProceedingJoinPoint joinPoint){
		Object object = null;
		try{
			System.out.println("aspect around 1"); //����ִ��ǰ
			object = joinPoint.proceed();  //����ҵ�񷽷���ִ��
			System.out.println("aspect around 2"); //����ִ�к�
		}catch(Throwable e){
			e.printStackTrace();
		}
	}
	
	//AOP�в����Ĵ���
	public void aroundInit(ProceedingJoinPoint joinPoint,String bizName,int times){
		System.out.println(bizName+"--"+times);
		Object object = null;
		try{
			System.out.println("aspect around 1"); //����ִ��ǰ
			object = joinPoint.proceed();  //����ҵ�񷽷���ִ��
			System.out.println("aspect around 1"); //����ִ�к�
		}catch(Throwable e){
			e.printStackTrace();
		}
	}
}
