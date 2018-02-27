package com.briup.network.ch5;

import java.net.*;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.io.*;
public class URLTest {
	public static void main(String[] args) {
		try {
			//protocol://ip:port/��Դ·��
			URL u = new URL("http://172.17.101.250");
			//  ����һ�� URLConnection ��������ʾ�� URL �����õ�Զ�̶�������ӡ�
			URLConnection c = u.openConnection();
			Map<String,List<String>> map =c.getHeaderFields();
			//��Ӧͷheader
			Set<String> set = map.keySet();
			for(String s:set){
				System.out.println(s+":");
				for(String value:map.get(s)){
					System.out.print(value);
				}
				System.out.println();
			}
			
			//��Ӧ��body
			BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream(),"GB2312"));
			String s = "";
			while((s=br.readLine())!=null){
				System.out.println(s);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
