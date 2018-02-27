package com.briup.ch072;


/*
 * ����һ��Enum�࣬ ö����Ĭ�ϼ̳���java.lang.Enum
 * 
 * ��������������ɴ���������ö��ʵ��
 * MAIL("��") --> public static final MAIL = new Gender(��);
 * �����е����ԣ�����������Ϊ˽�е�Ϊ��ʵ�����õķ�װ
 * */
public enum Gender {
	MAIL("��"),FEMALE("Ů");
	private String name;
	
	private Gender(){
		
	}
	private Gender(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
}


