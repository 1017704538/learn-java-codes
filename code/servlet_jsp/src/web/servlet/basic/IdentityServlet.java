package web.servlet.basic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.image.codec.jpeg.*;
/*
 * ʹ��Servlet���ͼƬ����֤�롣ԭ���ǣ�����������һ����������ַ�����ͼƬ�����ͻ���
 * �ͻ����ύ��������Ҫ��д�ַ�����Ϊ��֤�������ַ���������ͼƬ�У���˻�������ʶ�𣬴Ӷ�
 * �ﵽ��ֹ��Щ��ʹ�ü���������������Ϣ��Ŀ��
 * */
public class IdentityServlet extends HttpServlet{
	//����ֵ�
	private static final char[] CHARS = {'2', '3', '4', '5', '6', '7', '8', '9',
			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'M', 'N', 'P',
			'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
			'a', 'b', 'c', 'd', 'e' , 'f', 'g', 'h', 'i', 'j', 'k', 'm', 'n', 'p',
			'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
			};//������0��o��l��l���ѱ��ַ�
	
	private static Random random = new Random(); //�����
	/*
	 * ��ȡ6λ�����
	 * */
	public static String getRandomString() { //��ȡ6λ�����
		StringBuffer buffer = new StringBuffer(); //�ַ�����
		for(int i = 0; i < 6; i++) {
			buffer.append(CHARS[random.nextInt(CHARS.length)]);
		}
		return buffer.toString();
	}
	
	/*
	 * �����ȡ��ɫ
	 * */
	public static Color getRandomColor() {
		return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
	}
	
	/*
	 * ����ĳ��ɫ�ķ�ɫ
	 * */
	
	public static Color getReverseColor(Color c) {
		return new Color(255 - c.getRed(), 255 - c.getGreen(), 255 - c.getBlue());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("image/jpeg");   //����������ͱ����
		String randomString = getRandomString(); //����ַ���
		req.getSession(true).setAttribute("randomString", "randomString");//����session��
		int width = 100;		//ͼƬ�Ŀ��
		int height = 30;		//ͼƬ�ĸ߶�
		
		Color color = getRandomColor();	//�����ȡ��ɫ
		Color reverse = getReverseColor(color); //��ɫ����ǰ��ɫ
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR); //����һ����ɫͼƬ
		Graphics2D g = bi.createGraphics();		//��ȡͼƬ����
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16)); //��������
		g.setColor(color);	//������ɫ
		g.fillRect(0, 0, width, height); //���ñ���
		g.setColor(reverse);	//������ɫ
		g.drawString(randomString, 18, 20);  //��������ַ�
		/*
		 * ����������100��
		 * */
		for(int i = 0 , n = random.nextInt(100); i < n; i++) {
			g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
		}
		
		ServletOutputStream out = resp.getOutputStream();
		ImageIO.write(bi, "jpg", out);
		out.flush();
	}
	
	
}


