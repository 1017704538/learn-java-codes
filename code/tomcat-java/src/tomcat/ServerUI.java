package tomcat;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerUI {
	JFrame frame;
	JLabel label;	//xxx������
	JPanel panel;	//���÷������رհ�ť���˿ں�����
	JPanel panel2;	//����ɾ��ָ���Ŀͻ���
	JTextField text; // ����Ŀ¼�������Ķ˿ں�
	JTextField text2; // ������Ҫ�Ͽ����ӵĿͻ���ip
	JTextArea textArea;//��ʾ��ǰѡ�ж�ͻ��˵���������
	JScrollPane srollPane;//�����ı���
	JButton but; // �رշ�����
	JButton but2; // �رտͻ���ָ���Ŀͻ�������
	JButton but3; //����������
	File floder;
	String[] files;
	ServerSocket server;
	Socket s;
	static boolean onoff=false;
	public static void main(String[] args){
		ServerUI ui = new ServerUI();
		ui.initGui();
		ui.control(ui);
	}

	public void initGui() {
		// ��������
		frame = new JFrame("������");
		// �������������ˢ�°�ť��·���ı���ʾ��
		panel = new JPanel();
		panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		label = new JLabel("�������˿ں�");
		text = new JTextField(20);
		text2 = new JTextField(26);
		// �����ı���,��ʾĿ¼�µ��ļ���Ŀ¼��
		textArea = new JTextArea();
		srollPane = new JScrollPane(textArea);
		frame.add(srollPane, BorderLayout.CENTER);
		but = new JButton("�رշ�����");
		// ����ˢ�°�ť����ȡ��ǰ·���µ�Ŀ¼�����ļ���
		but.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				ServerUI ui = new ServerUI();
				try {
					server.close();
					new JOptionPane().showMessageDialog(null, "�������ѹر�");
					textArea.setText("");
					System.out.println("�������ѹر�");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		});
		but2 = new JButton("�Ͽ��ÿͻ���");
		but2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				text2.getText().trim();
				new JOptionPane().showMessageDialog(null, "ɾ���ɹ�");
			}

		});
		but3 =new JButton("����������");
		but3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				ServerUI ui = new ServerUI();
				ui.setOnOff(true);
			}

		});
		panel.add(label, FlowLayout.LEFT);
		panel.add(text, FlowLayout.CENTER);
		panel.add(but, FlowLayout.RIGHT);
		panel.add(but3);
		panel2.add(text2);
		panel2.add(but2);
		// ������
		frame.add(panel, BorderLayout.NORTH);
		frame.add(panel2, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(250, 150, 600, 400);
		frame.setVisible(true);
	}
	public String getText(){
		return text.getText().trim();
	}
	public static boolean setOnOff(boolean flag){
		return onoff=flag;
	}
	public void control(ServerUI ui){
		while(true){
			if(onoff){
				try {
					onoff = false;
					int port = Integer.parseInt(ui.getText());
					System.out.println("����������"+port);
					server = new ServerSocket(port);
					while (true) {
						// ���������� ������socket����
						s = server.accept();
						if(s!=null){
							ui.textArea.setText(ui.textArea.getText()+"\n"+s.getInetAddress()+new Date().toString());
						}
						Handler h = new Handler(s);
						h.start();
					}
				}catch(SocketException e2){
					control(ui);
				}catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
	}

}
