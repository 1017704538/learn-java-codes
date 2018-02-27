package com.briup.io.ch12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableTest {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("src/object"));
		
		ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("src/object"));
		Employee e = new Employee("jack",2000);
		oos.writeObject(e);
		Employee e1 = (Employee)ois.readObject();  //ֻ���л������е�����,ȡ�����ݸ����µĶ���
		System.out.println(e1==e);		//false
		System.out.println(e1.name+"--"+e1.salary);
		oos.close();
	}
}	


class Employee implements Serializable{
	public String name;
	public transient double salary;		//transient ����ǰ������ݲ��ᱻ����
	public Employee(String n,double s){
		name = n;
		salary = s;
	}
}