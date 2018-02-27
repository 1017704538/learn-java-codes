package com.briup.network.ch5;

import java.io.*;
import java.net.*;

public class TimeTcpClient {

	public static void main(String[] args) {
		System.out.println("�ͻ���������");
		Socket s = null;
		DataOutputStream dos = null;
		DataInputStream dis = null;
		try {
			//1.�������ڽ��ܺͷ������ݵ�Socket����
			//Socket(String host,int port)
			s = new Socket("127.0.0.1",8989);
			//2.����������������ڽ��ܺͷ�������
			dos = new DataOutputStream(s.getOutputStream());
			dis = new DataInputStream(s.getInputStream());
			//3.��������
			dos.writeUTF("time");
			//4.��������
			String str = dis.readUTF();
			System.out.println(str);
		} catch(IOException e) {
			e.printStackTrace();
		}finally{//�ͷ���Դ
			try {
				dos.close();
				dis.close();
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

}
