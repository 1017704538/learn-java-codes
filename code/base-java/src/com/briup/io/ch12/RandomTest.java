package com.briup.io.ch12;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomTest {
	public static void main(String[] args) throws IOException{
		RandomAccessFile r = new RandomAccessFile("src/random","rw");
		//r.writeUTF("qerioio");
		//r.writeChars("qerioio");		//uniCode
		//r.writeBytes("qerioio");
		//r.writeChar('a');
		r.seek(6);//ָ�������ֽ������ж�д����
		r.writeBytes("b");
		r.close();
	}
}
