package com.loginandcrudoperation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		String FirstName=request.getParameter("firstname");
		String LastName=request.getParameter("lastname");
		String EmailId=request.getParameter("emailid");
		String Hobby=request.getParameter("hobby");
		String CityName=request.getParameter("cityname");
		
		DataSource ds=new DataSource();
		
		ds.setFirstName(FirstName);
		ds.setLastName(LastName);
		ds.setEmailId(EmailId);
		ds.setHobby(Hobby);
		ds.setCityName(CityName);
		
		DataSourceList dsl=new DataSourceList();
		dsl.insertData(ds);
		
		response.sendRedirect("ShowRegisterUser.jsp");
		
	}

}
