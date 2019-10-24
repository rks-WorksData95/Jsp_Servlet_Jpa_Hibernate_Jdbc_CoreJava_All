package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.StudentMain;

public class EditAndDeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	StudentMain sMain;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int studentId=Integer.parseInt(request.getParameter("studentId"));
		
		sMain=new StudentMain();
		sMain.buidSessionFactory();
		sMain.deleteStudent(studentId);
		
		response.sendRedirect("ViewStudentInformation.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int studentId=Integer.parseInt(request.getParameter("editid"));
		String studentName=request.getParameter("editname");
		String studentAddress=request.getParameter("editaddress");
		
		sMain=new StudentMain();
		sMain.buidSessionFactory();
		sMain.updateStudent(studentId,studentName,studentAddress);
		
		response.sendRedirect("ViewStudentInformation.jsp");
		
	}

}
