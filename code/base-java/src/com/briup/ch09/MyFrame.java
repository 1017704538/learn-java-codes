package com.briup.ch09;

import java.awt.*;
import javax.swing.*;

public class MyFrame {
	public MyFrame(){
		//1.ѡ������
		JFrame frame = new JFrame("myFrame");
		//���ô�С
		/*frame.setSize(500, 400);
		frame.setLocation(400, 200);*/
		frame.setBounds(400, 200, 500, 400);
		//ʹ����ر�,������������Xֻ��ʹ���򲻿ɼ������򻹴���������
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//��Ӳ��ֹ�����
		BorderLayout l = new BorderLayout();
		frame.setLayout(l);
		//������
		JPanel p = new JPanel();
		FlowLayout flow = new FlowLayout(FlowLayout.LEFT,20,10);  //���ü��
		p.setLayout(flow);
		for(int i=0;i<5;i++){
			p.add(new JButton("��ť"+i));
		}
		frame.add(p, BorderLayout.NORTH);
		frame.add(new JButton("button2"), BorderLayout.SOUTH);
		frame.add(new JButton("button3"), BorderLayout.WEST);
		frame.add(new JButton("button4"), BorderLayout.EAST);
		frame.add(new JButton("button5"), BorderLayout.CENTER);
		//���panel����
	
		//frame.add(p);
		frame.setVisible(true);
	}
	
	public static void main(String[] args){
		new MyFrame();
	}
}
