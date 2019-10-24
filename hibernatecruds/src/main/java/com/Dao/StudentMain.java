package com.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


import com.Util.StudentInfo;

public class StudentMain
{
	SessionFactory sessionfactoryobj;
	public void buidSessionFactory()
	{
		Configuration cfgobj=new Configuration();
		cfgobj.addAnnotatedClass(com.Util.StudentInfo.class);
		cfgobj.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceregobj=new StandardServiceRegistryBuilder().applySettings(cfgobj.getProperties()).build();
		sessionfactoryobj=cfgobj.buildSessionFactory(serviceregobj);
	}

	public void insertStudent(StudentInfo sInfo)
	{
		Session sessionobj=sessionfactoryobj.openSession();
		sessionobj.beginTransaction();
	
		sessionobj.save(sInfo);
		
		sessionobj.getTransaction().commit();
		sessionobj.close();
	}
	
	public List<StudentInfo> viewStudent()
	{
		buidSessionFactory();
		Session sessionobj=sessionfactoryobj.openSession();
		sessionobj.beginTransaction();
		
		List<StudentInfo> studentData=sessionobj.createQuery("FROM StudentInfo").list();
		
		return studentData;
	}
	
	public void updateStudent(int studentId, String studentName, String studentAddress)
	{
		Session sessionobj=sessionfactoryobj.openSession();
		sessionobj.beginTransaction();
		
		StudentInfo sInfo=sessionobj.get(StudentInfo.class, studentId);
		sInfo.setName(studentName);
		sInfo.setAddress(studentAddress);
		
		sessionobj.update(sInfo);
		
		sessionobj.getTransaction().commit();
		sessionobj.close();
	}
	
	public void deleteStudent(int studentId)
	{
		Session sessionobj=sessionfactoryobj.openSession();
		sessionobj.beginTransaction();
		
		StudentInfo sInfo=sessionobj.get(StudentInfo.class, studentId);
		
		sessionobj.delete(sInfo);
		
		sessionobj.getTransaction().commit();
		sessionobj.close();
	}
}
