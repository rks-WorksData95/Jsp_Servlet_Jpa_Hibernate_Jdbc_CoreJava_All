package com.Dao;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.model.A;
import com.model.Student;

public class TestStudent
{
	public static void main(String args[])
	{
		Resource resource=new ClassPathResource("applicationContext.xml");
		BeanFactory factory=new XmlBeanFactory(resource);
	
		System.out.println("******* Using Bean Factory *******");
		
		Student student=(Student) factory.getBean("studentbean");
		student.displayStudentInfo();
		
		System.out.println("******* Using Application Context *******");
		
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		Student student1=(Student) context.getBean("studentbean");
		student1.displayStudentInfo();
		
		ClassPathXmlApplicationContext ctx=(ClassPathXmlApplicationContext)context;
		ctx.close();
		
		System.out.println("******* Autowire Using byName *******");
		
		ApplicationContext context1=new ClassPathXmlApplicationContext("applicationContext.xml");
		A a=context1.getBean("a",A.class);
		a.display();
	}

}