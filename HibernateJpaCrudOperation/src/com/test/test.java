package com.test;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.entity.Student;


@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaCrudOperation");
	     EntityManager  em = emf.createEntityManager();
	     em.getTransaction().begin();
	     
		 Student s=new Student();
		 s.setName("Ram");
		 s.setAddress("Mandal");
		 
		 em.persist(s);
	     em.getTransaction().commit();
	     
	     em.close();
	     emf.close();
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		
		
	}

}
