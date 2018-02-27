package web.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTest extends HttpServlet{

	
	/*
	 * ��GET��ʽ����ҳ����ִ�иú���
	 * ִ��doGet��ʽǰ����ִ��getLastModified,�������getLastModified���ص���ֵ
	 * ����һ�η���ʱ����idea��ֵ��ͬ������Ϊ���ĵ�û�и��£���������û������ִ��doGet
	 * ���getLastModified����-1����Ϊ��ʱ�̸��µģ�����ִ�иú���
	 * */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			this.log("ִ��doGet����");  //����Servlet�Դ�����־�������
			this.execute(req,resp);
	}

	/*
	 * ��POST��ʽ����ҳ��ʱִ�иú�����ִ��ǰ����ִ��getLastModified
	 * */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.log("ִ��doPost����");  //����Servlet�Դ�����־�������
		this.execute(req,resp);
	}
	
	//ִ�з���
	private void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setCharacterEncoding("UTF-8");  //����resp�ı����ʽ
		req.setCharacterEncoding("UTF-8");	//����req�ı����ʽ
		String reqURI = req.getRequestURI(); //����Servlet��URI
		String param = req.getParameter("param");//�ͻ����ύ����paramֵ
		System.out.println(param);
		String method = req.getMethod();
		
		resp.setContentType("text/html");	//�����ĵ�����Ϊhtml
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<html>");
		out.println("<head><title></title></head>");
		out.println("<body>");
			out.println("��"+method+"��ʽ���ʸ�ҳ�档������param����Ϊ"+param+"<br/>");
			out.println("<form action='"+reqURI+"' method='get'>"
					+ "<input type='text' name='prama' value='prama String'>"
					+ "<input type='submit' value='��GET��ʽ��ѯҳ��'"+reqURI+"'>"
							+ "</form>");
			out.println("<form action='"+reqURI+"' method='post'>"
					+ "<input type='text' name='prama' value='prama String'>"
					+ "<input type='submit' value='��Post��ʽ��ѯҳ��'"+reqURI+"'>"
							+ "</form>");
			//�пͻ����������ȡ���ĵ��ĸ���ʱ��
			out.println("<script>document.write('��ҳ��������ʱ�䣺'+document.lastModified);</script>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
	}
	
}
