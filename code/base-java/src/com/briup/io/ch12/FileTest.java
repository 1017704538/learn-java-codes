package com.briup.io.ch12;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {
	public FileTest() {
	}
	public static void main(String[] args) throws IOException{
	
		FileWriter fw = null;
		FileReader fr = null;
		fw = new FileWriter("src/string");
		fr = new FileReader("src/string");
		
		
		fw.write("���");
		fw.flush();
		char[] c = new char[10];
		//read ������ȡ���ַ���
		System.out.println(fr.read(c));                                                                                                 
		//����ַ������е��ַ�
		System.out.println(c);
		
	}
}
