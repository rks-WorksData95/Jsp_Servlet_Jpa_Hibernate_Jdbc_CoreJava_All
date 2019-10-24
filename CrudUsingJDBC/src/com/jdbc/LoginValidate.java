package com.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginValidate")
public class LoginValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    DatabaseConnection dcon=new DatabaseConnection();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		String UserName=request.getParameter("username");
		String Password=request.getParameter("password");
		
		try
		{
			boolean fetchUser=dcon.fetchUser(UserName,Password);
			System.out.println(fetchUser);
			if(fetchUser==true)
			{
				HttpSession session=request.getSession();
				session.setAttribute("UserName", UserName);
				
				response.sendRedirect("UserRegistration.jsp");	
					
			}
			else
			{
				out.println("<center><h3>You have enter wrong username and password.</h3></center>");
				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				rd.include(request, response);
				//response.sendRedirect("Login.jsp");
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

}
