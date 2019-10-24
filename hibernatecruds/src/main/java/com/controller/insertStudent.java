package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.StudentMain;
import com.Util.StudentInfo;

public class insertStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	StudentMain sMain;
	StudentInfo s;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		s=new StudentInfo();
		s.setName(request.getParameter("studentname"));
		s.setAddress(request.getParameter("studentaddress"));
		
		sMain=new StudentMain();
		sMain.buidSessionFactory();
		sMain.insertStudent(s);
		
		response.sendRedirect("ViewStudentInformation.jsp");
	}

}
