package com.briup.struts.chap1;

public class ActionTest1 {
	public String execute(){ //������һ��Ҫ��excute ��������һ����String
		int count = (int) (Math.random()*10);
		if(count<5){
			System.out.println(count);
			return "error";
		}else{
			System.out.println(count);
			return "success";
		}
		
	}
}
