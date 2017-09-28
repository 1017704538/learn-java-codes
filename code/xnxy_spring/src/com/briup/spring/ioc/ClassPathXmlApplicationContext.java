/*package com.briup.spring.ioc;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class ClassPathXmlApplicationContext implements BeanFactory {

	private Map<String, Object> beans = new HashMap<String, Object>();
	
	public ClassPathXmlApplicationContext() {}
	public ClassPathXmlApplicationContext(String path) {
		//jdom������������sax������dom����
		try {
			//����������
			SAXBuilder builder = new SAXBuilder();
			//���������ĵ�
			Document document = builder.build(path);
			//��ȡ���ڵ�
			Element root = document.getRootElement();
			//��ȡ��һ���ڵ�
			List<Element> list = root.getChildren("bean");
			for(Element e:list){
				String name = e.getAttributeValue("name");
				String cls = e.getAttributeValue("class");
				//newInstance()ʵ��������
				Object object = Class.forName(cls).newInstance();
				beans.put(name, object);
				//��ȡ��һ���ڵ�
				List<Element> list2 = e.getChildren("property");
				for(Element e2:list2){
					String name2 = 	e2.getAttributeValue("name");
					String ref = e2.getAttributeValue("ref");
					//����setXxxx������        setUserDao
					String setMethodName = "set"+name2.substring(0, 1).toUpperCase()+name2.substring(1);
					//o UserDao��ʵ��
					Object o = beans.get(ref);  
					//����object.getClass().getMethod()ָ��������Դ���Ǹ���
					//������������������ָ����������Ǹ��������ķ���
					//�ڶ��������������Ĳ���											
					Method method = object.getClass().getMethod(setMethodName, o.getClass());
					 //ִ�з���invoke
					//��һ������ ˭ִ��
					//�ڶ������� ִ��˭  
					method.invoke(object, o);
				}
			}
		} catch (JDOMException | IOException e) {
			e.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (NoSuchMethodException e1) {
			e1.printStackTrace();
		} catch (SecurityException e1) {
			e1.printStackTrace();
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
		}
	}
	
	@Override
	public Object getBean(String name) {
		return beans.get(name);  
	}
}
*/