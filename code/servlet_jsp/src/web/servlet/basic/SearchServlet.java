package web.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yahoo.search.ImageSearchRequest;
import com.yahoo.search.ImageSearchResult;
import com.yahoo.search.ImageSearchResults;
import com.yahoo.search.SearchClient;


public class SearchServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
	
		PrintWriter out = resp.getWriter();
		
		String type = req.getParameter("type"); //��������
		System.out.println("----------------------------------------------"+type);
		String allowedAdult = req.getParameter("allowedAdult"); 
		String word=req.getParameter("word");  //�����ؼ���
		System.out.println(word+"000000000");
		//�Ƿ������������Checkboc�����ԣ� ���ѡ�У���Ϊ"true",����Ϊnull
		boolean adultOk = "true".equals(allowedAdult);  //ת��Ϊboolan����
		out.println("<!DOCTYPE html PUBLIC -//W3C//DTD HTML 4.01 Transitional//EN>");
		out.println("<html>");
		out.println("<head><title>word�������</title></head>");
		out.println("<body>");
			out.println("<div style='float : left; height : 40px;'><img src='images/yahoo.jpg' style='margin: 25px; width :'350px'; height : '80px';'></img></div");
			out.println("<form action='"+req.getRequestURI()+"' method='get'>");//
				out.println("<div style='height : 40px;'>");
					out.println("<input type='radio' name='type' value='web'"+(type.equals("web")?"checked":"")+">��ҳ");
					out.println("<input type='radio' name='type' value='news'"+(type.equals("news")?"checked":"")+">����");
					out.println("<input type='radio' name='type' value='image'"+(type.equals("image")?"checked":"")+">ͼ��");
					out.println("<input type='radio' name='type' value='video'"+(type.equals("video")?"checked":"")+">��Ƶ");
					out.println("<input type='checkbox' name='allowedAdult' value='true'"+(adultOk?"checked":"")+"�����������<br/>");
					out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
					out.println("<input type='text' name='word' value='' style='width: 300px;'>");
					out.println("<input type='submit' value='���Ż�����' style='width: 100px;'>");
				out.println("</div>");
			out.println("</form>");
		out.println("</body>");
		out.println("</html>");

		SearchClient client = new SearchClient("appid");

		try{
			   if("image".equals(type)){
		            ImageSearchRequest searchRequest = new ImageSearchRequest(URLEncoder.encode(word, "UTF-8"));
		            // ��ѯ��¼��
		            searchRequest.setResults(20);
		            // �ӵ� 0 ����¼��ʼ��ʾ
		            searchRequest.setStart(BigInteger.valueOf(0));
		             
		            double startTime = System.currentTimeMillis();
		            ImageSearchResults results = client.imageSearch(searchRequest);
		            double endTime = System.currentTimeMillis();
		 
		            out.println("<div align=right style='width:100%; background: #FFDDDD; height:25px; padding:2px; border-top:1px solid #FF9999; margin-bottom:5px; '>");
		            out.println("    �ܹ� " + results.getTotalResultsAvailable() + " �����ݣ�����ʱ " + ( endTime - startTime )/1000 + " �롣");
		            out.println("</div>");
		             
		            for(ImageSearchResult result : results.listResults()){
		                out.println("<div class='imgDiv'>");
		                out.println("    <div align='center'><a href=\"" + result.getClickUrl() + "\" target=_blank><img width=160 height=120 src=\"" + result.getThumbnail().getUrl() + "\" border='0'></a></div>");
		                out.println("    <div align='center'><a href=\"" + result.getRefererUrl() + "\" target=_blank>" + result.getTitle() + "</a></div>");
		                out.println("    <div align='center'>" + result.getWidth() + "x" + result.getHeight() + " " + result.getFileFormat() + "</div>");
		                out.println("    <div>" + (result.getSummary()==null ? "" : result.getSummary()) + "</div>");
		                out.println("</div>");
		            }
		        }else if("web".equals("type")) { //....��ҳ������������
													//���ţ���Ƶ��������
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
	}

	
}
