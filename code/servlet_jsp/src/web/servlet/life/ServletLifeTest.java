package web.servlet.life;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletLifeTest extends HttpServlet {

	public ServletLifeTest() {
		System.out.println("ServletLife���캯������");
	}
	
	//��ʵtomcat���õ���service����������HttpServlet��ʵ�ֵ�Service������
	//ͨ���Ե�ǰservlet���ʵķ�ʽ��get��psot...�������жϣ��Ӷ����õ�doXxx����
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			System.out.println("doGet��������");
	}

	@Override
	public void destroy() {
		System.out.println("destroy��������");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("servletLifeTest��ʼ����������");
	}

/*	@Override
	public void init(ServletConfig config) throws ServletException {
	
		super.init(config);
	}*/

	
}
