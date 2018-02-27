package com.briup.network.ch5;

import java.io.*;
import java.net.*;
import java.util.Date;

public class TcpTimeServer {
	public static void main(String[] args){
		System.out.println("1.������������");
		ServerSocket ss = null;
		Socket s = null;
		DataOutputStream dos = null;
		DataInputStream dis = null;
		try {
			//1.����ServerSocket����
			ss = new ServerSocket(8989);
			//2.�������Ӳ������µ�socket
			s = ss.accept();
			//3.����io��
			dos = new DataOutputStream(s.getOutputStream());
			dis = new DataInputStream(s.getInputStream());
			//4.��������
			String str = dis.readUTF();
			if(str.equals("time")){
				//5.��������
				dos.writeUTF(new Date().toString());
			}else{
				dos.writeUTF("���Ŵ���");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				dos.close();
				dis.close();
				s.close();
				ss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
