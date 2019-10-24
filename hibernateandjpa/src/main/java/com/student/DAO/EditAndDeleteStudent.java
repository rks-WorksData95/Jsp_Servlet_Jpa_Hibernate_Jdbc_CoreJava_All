package com.student.DAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.service.StudentService;


@WebServlet("/EditAndDeleteStudent")
public class EditAndDeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int studentId=Integer.parseInt(request.getParameter("studentId"));
		StudentService sService=new StudentService();
		sService.deleteStudent(studentId);
		
		response.sendRedirect("ViewStudentInformation.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int studentId=Integer.parseInt(request.getParameter("editid"));
		String studentName=request.getParameter("editname");
		String studentAddress=request.getParameter("editaddress");
		
		StudentService sService=new StudentService();
		sService.updateStudent(studentId,studentName,studentAddress);
		
		response.sendRedirect("ViewStudentInformation.jsp");
	}

}
