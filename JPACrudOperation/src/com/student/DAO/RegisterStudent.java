package com.student.DAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.entity.StudentInfo;
import com.student.service.StudentService;


@WebServlet("/RegisterStudent")
public class RegisterStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StudentInfo sInfo=new StudentInfo();
		sInfo.setName(request.getParameter("studentname"));
		sInfo.setAddress(request.getParameter("studentaddress"));
		
		StudentService sService=new StudentService();
		sService.insertStudent(sInfo);
		
		response.sendRedirect("ViewStudentInformation.jsp");
	}

}
