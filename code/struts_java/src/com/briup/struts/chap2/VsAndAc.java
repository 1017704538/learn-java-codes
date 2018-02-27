package com.briup.struts.chap2;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.briup.bean.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.Key;
import com.opensymphony.xwork2.util.ValueStack;
/*
 * 
 * ջ������
 * 
 * */
public class VsAndAc extends ActionSupport{
	private String  name;  //����һ�ṩget set�������Ϳ��԰ѳ�Ա������ŵ�ֵջ��
	private Student student;
	
	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String execute() throws Exception {
		System.out.println("this is vsAndac");
		name="tom";
		student = new Student();
		student.setName("jack");
		String name = "rose";
		
		
		Student student2 = new Student();
		student2.setName(name);
		ActionContext ac = ActionContext.getContext();
		ValueStack vs = ac.getValueStack();
		vs.push(student2); //��student2����ֵջ��
		//vs.pop();
		//------------------��������----------
		/*
		 * <c:property value="#name"/>���з�ʽͨ��#***ȡֵ
		 * */
		ac.put("name", name);  
		ac.put("student2", student2);
		System.out.println(ac.get("name"));
		/*
		 * ���ַ�ʽȡ������request����ԭ����map�������Ҫȡ��HttpServletRequest request��ʹ��ServletActionContext.getRequest();
		 * */
		Map<String, Object> request = (Map<String, Object>) ac.get("request");
		System.out.println(request+"------------");
		HttpServletResponse reponse	= ServletActionContext.getResponse();
		Map<String, Object> session =  ac.getSession();
		session.put("student2", student2);
		
		Set<String> keys = request.keySet();
		for(String k: keys){
			Object value = request.get(k);
			System.out.println("key:"+k+"value:"+value);
		}
		request.put("name", name);
		
		return SUCCESS;
	}
}
