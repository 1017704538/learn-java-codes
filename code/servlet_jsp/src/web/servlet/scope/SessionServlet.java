package web.servlet.scope;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		// ��ȡSession����
		HttpSession session = req.getSession(); // req.getSession(true)��ʾÿ�η��ʴ���һ���µ�session

		String sessionid = session.getId(); // ��ȡJSESSIONID
		boolean b = session.isNew(); // �ж��Ƿ�Ϊ���µ�session
		System.out.println("id=" + sessionid);
		System.out.println("isNew=" + b);
		Integer count = (Integer) session.getAttribute("num"); // ��һ�η���num=null
		if (count == null) {
			count = 1;
			session.setAttribute("num", count);
		}
		PrintWriter out = resp.getWriter();
		String path = "session"; //
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>session:count=" + count + "</h1>");
		out.println("<a href=" + resp.encodeUrl(path) + ">url��д</a>");// �ڿͻ��˽���cookieʱ��Ҳ���Լ�¼�Ự
		out.println("</body>");
		out.println("</html>");
		out.flush();
		// session.invalidate(); //sessionʧЧ
		session.setAttribute("num", ++count);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
