package com.briup.ch08;

public class ExceptionTest {
	public static void division(){
		int i = 10;
		int j = 0;
		try{//try�����������ܻ������쳣����
			System.out.println("j="+j);
			int x = i/j;	//�쳣 ArithmeticException
			ExceptionTest ex = null;
			ex.test();		//NullPointerException
			System.out.println("Occur exception");
		}catch(ArithmeticException e){//ץȡException����������쳣����
			//�쳣����
			e.printStackTrace();//��ӡ�쳣ջ
			System.out.println("catch statement");
			//System.out.println("�����ķ�ĸ����Ϊ0");
		}catch(NullPointerException e){
			e.printStackTrace();//��ӡ�쳣ջ
			System.out.println("catch2 statement");
		}finally{
			System.out.println("method end");
		}
		
	}
	public static void main(String[] args){
		System.out.println("before invoke");
		division();
		System.out.println("later invoke");
	}
	public void test(){
		
	}
}
