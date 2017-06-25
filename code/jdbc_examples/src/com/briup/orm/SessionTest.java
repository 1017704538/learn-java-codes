package com.briup.orm;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class SessionTest {
	String tableName = "Student";
	Map<String,String> cfs = new HashMap<String,String>();
	String[] methodNames;//���ڴ���ʵ�����е�get��������
	
	public SessionTest() {
		cfs.put("_id", "id");
		cfs.put("_name", "name");
		cfs.put("_age", "age");
		methodNames = new String[cfs.size()];
	}
	
	public void save(Object o) throws Exception {
		String sql = createSQL(); //����SQL��
		System.out.println(sql);
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/com/briup/orm/db.properties"));
		String driver = prop.getProperty("driver");
		System.out.println(driver);
		String url = prop.getProperty("url");
		String user = prop.getProperty("user");
		String password = prop.getProperty("password");
		Class.forName(driver); //ע������
		System.out.println(url);
		Connection conn = DriverManager.getConnection(url, user, password);
		
		PreparedStatement ps = conn.prepareStatement(sql);
		for(int i = 0; i < methodNames.length; i++) {
			///����һ�� Method ��������ӳ�� Class ��������ʾ�����ӿڵ�ָ��������Ա����
			Method method = o.getClass().getMethod(methodNames[i]);
			//����һ�� Class ���󣬸ö��������˴� Method ��������ʾ�ķ�������ʽ��������
			Class r = method.getReturnType();
			if(r.getName().equals("java.lang.String")) {
				//�Դ���ָ��������ָ����������ɴ� Method �����ʾ�ĵײ㷽����
				//����������Զ�������Ա�������β���ƥ�䣬�������������ò�����������ӷ�������ת��
				String returnValue = (String)method.invoke(o);
				System.out.println(returnValue);
				ps.setString(i+1, returnValue);
			} else if(r.getName().equals("int")) {
				Integer returnValue = (Integer)method.invoke(o);
				System.out.println(returnValue);
				ps.setInt(i+1, returnValue);
			} 
			System.out.println(method.getName()+"|"+r.getName());
		}
		ps.executeUpdate();
		conn.commit();
		ps.close();
		conn.close();
	}
	
	public String createSQL() {
		String str1 = "";
		int index = 0;
		for(String s : cfs.keySet()) {
			String v = cfs.get(s);//ȡ��ʵ�����Ա����
			//����Ա���Ե�һ���ַ���д,ƴʵ�����Ա���Ե�getter����
			methodNames[index] = "get" + Character.toUpperCase(v.charAt(0)) + v.substring(1);
			str1 += v + ","; ////���ݱ����ֶ���ƴ���ֶδ�
			index++;
		}
		str1 = str1.substring(0,str1.length() -1);
		String str2 = "";
		//���ݱ����ֶ�����ƴ��?��
		for (int i = 0; i < cfs.size(); i++){	
			str2 += "?,";
		}
		str2 = str2.substring(0,str2.length() -1);
		String sql = "insert into " + tableName + "(" + str1 + ")" + " values (" + str2 + ")";
		System.out.println(sql);
		return sql;
	}
	
}
