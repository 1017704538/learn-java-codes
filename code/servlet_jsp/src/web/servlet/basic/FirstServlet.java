package web.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet implements Servlet{

	public FirstServlet() {
		System.out.println("firstServlet����");
	}
	@Override
	public void destroy() {
		
		
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		
	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		/*
		 * ���������������͹����������װ����һ��SerletRequset���͵Ķ���
		 * �����������ظ����������Ӧ��װ����һ��SerletResponse���ĵĶ���
		 * */
		PrintWriter out = response.getWriter();

		out.println("hello servlet1");
		out.flush();
		out.close();
	}

}
