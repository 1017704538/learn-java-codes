package com.briup.reflect.ch07;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;

public class ReflectTest {
	public static void main(String[] args) throws Exception{
		//��ȡ��ľ���1
		String name = "com.briup.reflect.ch07.Food";
		Class c1 =Class.forName(name); //��ȡ��Food���͵ľ���
		//��2
		Class c2 =Food.class;
		//��3
		Object obj = new Food();
		Class c3 = obj.getClass();
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c1==c2);
		System.out.println(c2==c3);
		System.out.println(obj);
		//ͨ���ྵ���ȡ����������
		//��ȡ���е�ǰ��Χ�ڿɼ��Ĺ������ľ���
		Constructor[] cs1 = c1.getConstructors();
		//��ȡ���е����еĹ������ľ���
		Constructor[] sc2 = c1.getDeclaredConstructors();
		
		
		Constructor con1 = c1.getConstructor();
		Constructor con2 = c1.getConstructor(String.class,String.class);
		System.out.println(con1+"=======");
		System.out.println(con2+"----");
		
		Constructor con3 = c1.getDeclaredConstructor(String.class);
		System.out.println(con3+"~~~~~~~");
		//����������
		//ͨ����������޲ι�����
		Food f3 = (Food)c1.newInstance();//ͨ���ྵ����ù�����
		Food f1=(Food)con1.newInstance();
		Food f2 = (Food)con2.newInstance("xiangcai","yutuo");
		System.out.println(f1);
		System.out.println(f2);
		System.out.println(f3);
		//�Բ��ɼ��ĳ�Ա�����������ÿɼ���
		con3.setAccessible(true);
		//��ô���Ƿ�ɼ���
		System.out.println("modifyiers:"+Modifier.toString(con3.getModifiers()));
		con3.newInstance("yutou");
		
		//��ȡ���Եľ���
		//��ȡ����
		Field[] fields = c1.getDeclaredFields();
		for(Field f:fields){//��ӡ����
			System.out.println(f);
		}
		Field f = c1.getDeclaredField("type");
		f.setAccessible(true);
		//��ĳ�������type���Ը�ֵ
		f.set(obj, "chuancai");
		//��ȡĳ�������type����ֵ
		String type=(String)f.get(obj);
		System.out.println(type);
		Field fi = c1.getDeclaredField("price");
		fi.set(null, 1000.0);
		System.out.println(Food.price);
		
		//��ȡ��������
		Method m1 = c1.getMethod("method1", String.class,int.class);
		
		Class cl1 = int.class;
		Class cl2 = Integer.class;
		System.out.println(cl1==cl2);
		System.out.println("--------------------------------------");
		//ͨ�������������ĳ�������еķ���
		m1.invoke(obj, "String",100);
		//��ȡ��������
		Method m2 = c1.getDeclaredMethod("method2");
		m2.setAccessible(true);
		m2.invoke(obj);
		
		for(Constructor c :cs1){
			Class[] cla = c.getParameterTypes();
			TypeVariable[] t =c.getTypeParameters();
			System.out.println();
		}
		
		System.out.println("--------------------------------------");
		Object t=c1.newInstance();
		Method addMethod = c1.getMethod("test", new Class[]{int.class,Integer.class});
		Object result=addMethod.invoke(t,
				new Object[]{new Integer(100),new Integer(200)});
		
	}

}
class Food
{
	private String type;
	public String name;
	static double price;
	public Food(){
	}
	public Food(String type, String name){
		this.type = type;
		this.name = type;
	}
	private Food(String name){
		this.name = name;
	}
	public void method1(String s,int i){
		System.out.println("method1:"+s+","+i);
	}
	private void method2(){
		System.out.println("method2");
	}
	public String toString(){
		return type+","+name;
	}
	public int test(int p1,Integer p2){
		return p1+p2;
	}
}
