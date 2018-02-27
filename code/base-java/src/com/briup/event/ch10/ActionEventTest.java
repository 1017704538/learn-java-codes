package com.briup.event.ch10;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class ActionEventTest {
	private JFrame frame;
	private JButton but;
	//private JTextField text;
	private JTextArea text;
	public ActionEventTest(){
		init();
		addListener();
	}
	public void init(){
		frame = new JFrame("test");
		frame.setBounds(100,50,500,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		but = new JButton("button");
		//text = new JTextField();
		text = new JTextArea();
		text.setFont(new Font("΢���ź�",Font.BOLD,36));
		but.setFont(new Font("΢���ź�",Font.BOLD,36));
		frame.setLayout(new GridLayout(2,1));
		frame.add(text);
		frame.add(but);
		//frame.pack();
		frame.setVisible(true);
	}
	public void addListener(){
		but.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("action");
				
			}
			
		});
		/*but.addMouseListener(new MouseListener(){//�������¼�

			@Override
			public void mouseClicked(MouseEvent e) { //���
				System.out.println("mouseClicked");
				System.out.println(e.getButton());
				System.out.println(e.getClickCount());
				System.out.println(e.getClickCount());
				System.out.println(e.getSource());
				System.out.println(e.getXOnScreen());
				e.getClickCount();
				e.getSource();
				e.getX();
				e.getXOnScreen();
			}

			@Override
			public void mousePressed(MouseEvent e) {//��ѹ
				System.out.println("mousePressed");
			}

			@Override
			public void mouseReleased(MouseEvent e) {//�ͷ�
				System.out.println("mouseReleased");
			}

			@Override
			public void mouseEntered(MouseEvent e) {//����
				System.out.println("mouseEntered");
			}

			@Override
			public void mouseExited(MouseEvent e) {//�Ƴ�
				System.out.println("mouseExited");
			}
			
		});*/
		but.addMouseMotionListener(new MouseMotionListener(){
			public void mouseMoved(MouseEvent e){
			/*	int x = e.getX();
				int y = e.getY();
				text.setText("x:"+x+"y:"+y);*/
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				text.setText("x:"+x+"y:"+y);
			}
		});
		
		text.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				//System.out.println("keytype");
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(" keyPressed");
				System.out.println(e.getKeyChar());
				System.out.println(e.getKeyCode());
				System.out.println(e.getKeyLocation());
				e.getKeyChar();//�ַ�
				e.getKeyCode();//�������
				e.getKeyLocation();//������λ�ã������������ظ��İ���ʱ����λ�ñ��
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				 System.out.println("keyReleased");
				
			}
			
		});
		
		//�������
		text.addFocusListener(new FocusListener(){
			public void focusLost(FocusEvent e){//�ͷŹ��
				System.out.println("focusLost");
			}
			public void focusGained(FocusEvent e){ //��ȡ���
				System.out.println("focusGained");
			}
		});
	}
	
	public static void main(String[] args){
		new ActionEventTest();
	}
}
