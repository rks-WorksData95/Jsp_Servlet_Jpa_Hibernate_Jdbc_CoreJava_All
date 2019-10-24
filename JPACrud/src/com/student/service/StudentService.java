package com.student.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.student.entity.StudentInfo;

public class StudentService
{
	EntityManagerFactory emFactory=Persistence.createEntityManagerFactory("JPACrud");
	EntityManager eManager=emFactory.createEntityManager();
	
	public void insertStudent(StudentInfo sInfo)
	{
		eManager.getTransaction().begin();
		eManager.persist(sInfo);
		eManager.getTransaction().commit();
		
		eManager.close();
		emFactory.close();
	}
	
	public List<StudentInfo> ViewStudent()
	{
		Query viewAllStudent = eManager.createQuery("SELECT s FROM StudentInfo s");
		List<StudentInfo> studentInfoView=viewAllStudent.getResultList();
		
		eManager.close();
		emFactory.close();
		
		return studentInfoView;
	}
	
	public void updateStudent(int studentId, String studentName, String studentAddress)
	{
		eManager.getTransaction().begin();
		StudentInfo sInfo=eManager.find(StudentInfo.class, studentId);
		sInfo.setName(studentName);
		sInfo.setAddress(studentAddress);
		eManager.getTransaction().commit();
		
		eManager.close();
		emFactory.close();
	}
	
	public void deleteStudent(int studentId)
	{
		eManager.getTransaction().begin();
		StudentInfo sInfo=eManager.find(StudentInfo.class, studentId);
		eManager.remove(sInfo);
		eManager.getTransaction().commit();
		
		eManager.close();
		emFactory.close();
	}
}
