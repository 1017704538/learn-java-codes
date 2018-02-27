package web.servlet.scope;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//��Χ����request
public class RequestServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//������request��Χ�ڷ���age��ֵ20
		req.setAttribute("age", 20);
		
		Integer age = (Integer) req.getAttribute("age");
		
		System.out.println("age="+age);
		//�ڲ���ת
		/*req.getRequestDispatcher("/forwardA").forward(req, resp);*/
		//�ض���
		resp.sendRedirect("forwardA");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
