package tomcat;
/*
 * ������������͹���������
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Requst {
	//���������л�ȡ����������
	private InputStream in;
	private BufferedReader br;
	//��Դ·��
	private String path;
	//Э��
	private String  protocol;
	//����
	private String method;
	public Requst(InputStream in){
		this.in = in;
	}
	//��ȡ������е���������
	public void parseData() throws IOException, NullPointerException{
		br = new BufferedReader(new InputStreamReader((in)));
		String line="";
		line=br.readLine();
		String li="";
	/*	while((li=br.readLine())!=null){
			System.out.println(li+"=========");
		}*/
		//GET /index.html HTTP/1.1
		String[] ss = line.split(" ");
		method = ss[0];
		path = "webContent"+ss[1];
		System.out.println(path);
		protocol = ss[2];
	}
	public String getPath() {
		return path;
	}
	public String getMethod(){
		return method;
	}
	public String getProtocol() {
		return protocol;
	}
}
