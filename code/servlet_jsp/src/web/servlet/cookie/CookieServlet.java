package web.servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CookieServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//�½�cookie
		Cookie c1 = new Cookie("name","zhangsan");
		Cookie c2 = new Cookie("age","20");
		//����cookie����Чʱ��setMaxAge(����)
		c1.setMaxAge(60*60*24*365);
		c2.setMaxAge(60*60*24*365);
		//��cookie�ŵ�response����
		resp.addCookie(c1);
		resp.addCookie(c2);
		
		PrintWriter out = resp.getWriter();
		out.println("<h2><a href='showCookie'>���η��ʷ����������ܵ���Cookie</a></h2>");
		out.flush();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
