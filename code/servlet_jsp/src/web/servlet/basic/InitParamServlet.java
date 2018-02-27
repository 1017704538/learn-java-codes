package web.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;


public class InitParamServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");   //����request�ı����ʽ
		response.setCharacterEncoding("UTF-8");  //����response�ı����ʽ
		
		response.setContentType("text/html");   //��������ΪHTML
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<html>");
		out.println("<head>");
			out.println("<title>���¼�鿴</title>");
			out.println("<style>body, td, div {font-size:12px;}</style>");
		out.println("</head>");
			out.println("<body>");
				out.println("<form actioin='"+request.getRequestURI()+"'method='post'>");
					out.println("�˺�:<input type='text' name='username' style='width:200px;'><br/>");
					out.println("����:<input type='password' name='password' style='width:200px;'><br/>");
					out.println("<input type='submit' value='��¼'>");
				out.println("</form>");
			out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username"); //�ύ��username����
		String password	= request.getParameter("password");	//�ύ��password����
		
		Enumeration params = this.getInitParameterNames(); 	//��ȡweb.xml�е����г�ʼ����������
		
		while(params.hasMoreElements()) { //�������еĳ�ʼ������
			String usernameParam = (String) params.nextElement();   //��ȡ�û���
			String passwordParam = getInitParameter(usernameParam);	//��ȡ����
			if(usernameParam.equalsIgnoreCase(username)&&password.equals(passwordParam)) {  //����û���������ȷ�򷵻�ҳ��
				request.getRequestDispatcher("WEB-INF/web.xml").forward(request, response);
				return;
			}
		}
		this.doGet(request,response);  //username, password��ƥ����ʾ��¼ҳ��
	}
	
}
