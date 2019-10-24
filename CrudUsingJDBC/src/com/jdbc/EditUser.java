package com.jdbc;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditUser")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int UserId=Integer.parseInt(request.getParameter("Id"));
		DatabaseConnection dcon=new DatabaseConnection();
		DataSource ds=new DataSource();
		ds.setId(UserId);
		
		try 
		{
			boolean delete=dcon.deleteUser(ds);
			if(delete==true)
			{
				response.sendRedirect("ShowUserDetails.jsp");
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int Id=Integer.parseInt(request.getParameter("editid"));
		
		DataSource ds=new DataSource();
		DatabaseConnection dcon=new DatabaseConnection();
		
		ds.setId(Id);
		ds.setFirstName(request.getParameter("editfirstname"));
		ds.setLastName(request.getParameter("editlastname"));
		ds.setEmailId(request.getParameter("editemailid"));
		ds.setHobby(request.getParameter("edithobby"));
		ds.setCityName(request.getParameter("editcityname"));
		
		try
		{
			boolean update=dcon.updateUser(ds);
			if(update==true)
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
