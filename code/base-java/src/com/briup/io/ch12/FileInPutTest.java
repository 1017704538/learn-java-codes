package com.briup.io.ch12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInPutTest {
	public static void main(String[] args){
		FileInputStream fis = null;
		//1.������
		try {
			fis = new FileInputStream("src/com/briup/io/ch12/test");
			int count=fis.available();
			byte[] b = new byte[count];
			//��0��ʼ�����������ֽ�
			//fis.skip(2);
			for(int i=0;i<count;i++){
				int r = fis.read();		//readÿ�ζ�ȡһ���ֽڣ���������
				System.out.println(r);
				b[i] =(byte)r;
			}
			//fis.read(b);		//��ȡָ�����鳤�ȵ��ֽ������������ݴ����������
			String s = new String(b);
			//System.out.println(s);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fis.close();	//�ر���
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
