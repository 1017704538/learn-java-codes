package com.briup.spring.aop;


/*
 * ��̬����
 * */
public class StaticProxy {
	public static void main(String[] args) {
		Product product = new Company(); //ί�й�˾
		Product product2 = new ComPro(product);//����˾
		product2.create();
		
	}
}


interface Product{
	public abstract void create();
}

//ί����
class Company implements Product{

	@Override
	public void create() {
		System.out.println("����Ь");
		
	}
}

//������
class ComPro implements Product{
	
	private Product product;

	public ComPro(){}
	
	public ComPro(Product product){
		this.product = product;
	}
	
	@Override
	public void create() {
		System.out.println("���ϴ�˹");
		product.create();
	}
	
}