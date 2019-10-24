package com.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test 
{

	public static void main(String[] args) 
	{
		System.out.println("******* Autowire Using byName *******");
		ApplicationContext context1=new ClassPathXmlApplicationContext("applicationContext.xml");
		A a=context1.getBean("a",A.class);
		a.display();
	}

}
