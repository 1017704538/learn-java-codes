package web.servlet.encode;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8"); //��֤post�ύ��ʽ��������
		resp.setCharacterEncoding("UTF-8"); //��֤��Ӧ�ı����ʽ
		resp.setContentType("text/html;charset=UTF-8"); //��������������ı����ʽ
		String name = req.getParameter("name");
		System.out.println(name);
		PrintWriter out = resp.getWriter();
		out.println("name="+name);
	}
	
	

}
