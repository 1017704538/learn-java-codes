package com.briup.struts.chap2;

import com.briup.bean.Student;
import com.opensymphony.xwork2.ActionSupport;

public class ParamAction extends ActionSupport {
/*
 * ����1
 * 	//��������Ҫ��ǰ̨�������Ĳ���һ�� �����ò���ֵ
	private String name;
	private String pwd;
	private int age;
	private String gender;
	private String province;
	private String hobby;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	@Override
	public String execute() throws Exception {
		Student student = new Student(name, pwd, age, gender, province, hobby);
		System.out.println(student);
		return SUCCESS;
	}
*/
	/*
	 * ����2
	 * 
	 * ǰ̨ҳ�洫�Ͳ���
	 * 
	 * <input type="text" name="student.name">
	 * <input type="password" name="student.password">
	 * 
	 * student.�е�student������Ҫͬ�����еĳ�Ա����student����һ��
	 * student.name �е�name��Ҫ��Student.java�еĳ�Ա��������һ��
	 * student.passowrd �е�password��Ҫ��Student.java�еĳ�Ա��������һ��
	 * ....
	 * */
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	

}
