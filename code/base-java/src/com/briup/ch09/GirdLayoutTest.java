package com.briup.ch09;

import java.awt.*;
import javax.swing.*;
public class GirdLayoutTest extends JFrame {
	public GirdLayoutTest(){
		setTitle("GirdLyaoutTest");
		setBounds(100,100,500,400);
		setDefaultCloseOperation(3);	//3=JFrame.EXIT_ON_CLOSE
		GridLayout grid = new GridLayout(3,4,10,10);	//3�У�4�У�10�����࣬5������
		setLayout(grid);
		for(int i=0;i<12;i++){
			add(new JButton("button"+i));
		}
		//��ָ���������һ���µ����
		//add(new JButton("button14"),13);
		setVisible(true);
	}
	public static void main(String[] args){
		new GirdLayoutTest();
	}
}
