package com.briup.thread.ch11;

public class NumberRunnable implements Runnable{
	public void run(){
		for(int i=0;i<=100;i++){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				//e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"i="+i);
		}
	}
	
	public static void main(String[] args) throws InterruptedException{
		NumberRunnable n = new NumberRunnable();
		Thread t1 = new Thread(n,"ooooooo");
		Thread t2 = new Thread(n,"pppp");
		t1.start();//�����߳�
		t2.start();
		t1.join();	//���̵߳���t1�����join������������ߣ����̣߳���ȴ�t1�߳�ִ�����
		t2.join();
		Thread.sleep(2000);	//��̬������������ĳ����������ĳ����ô�˯�ߵ���main
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getPriority());
	}
}
