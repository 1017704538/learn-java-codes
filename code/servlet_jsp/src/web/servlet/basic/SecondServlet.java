package web.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondServlet extends GenericServlet {

	public SecondServlet() {
		System.out.println("secondServlet����");
	}
	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		//�����������Ӧ�����������Լ������ʽ
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out  = response.getWriter();
			out.println("<html>");
				out.println("<head>");
					out.println("<title>servlet2</title>");
				out.println("</head>");
				out.println("<body>");
					out.println("<table width='200' border='1'>"
							+ "<tr><tr><td>����</td><td>����</td>"
							+ "<tr><tr><td>С��</td><td>20</td>");
					out.println("</table>");
				out.println("</body>");
			out.println("</html>");
			out.flush();
			out.close();
	}

}
