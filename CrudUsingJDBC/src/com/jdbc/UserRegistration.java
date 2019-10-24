package com.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	DatabaseConnection dcon=new DatabaseConnection();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		DataSource ds=new DataSource();
		
		ds.setFirstName(request.getParameter("firstname"));
		ds.setLastName(request.getParameter("lastname"));
		ds.setEmailId(request.getParameter("emailid"));
		ds.setHobby(request.getParameter("hobby"));
		ds.setCityName(request.getParameter("cityname"));
		
		try
		{
			boolean insert=dcon.insertUser(ds);
			if(insert==true)
			{
				response.sendRedirect("ShowUserDetails.jsp");
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
