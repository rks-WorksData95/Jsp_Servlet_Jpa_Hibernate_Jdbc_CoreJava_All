package com.loginandcrudoperation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Validate")
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		String UserName=request.getParameter("username");
		String Password=request.getParameter("password");
		
		if(UserName.equals("abc@cignex.com") && Password.equals("cignex"))
		{
			HttpSession session=request.getSession();
			session.setAttribute("UserName", UserName);
			response.sendRedirect("UserRegistrationForm.jsp");
		}
		else
		{
			out.println("<html><body color='red'><center>You have enter wrong username and password.</center></body></html>");
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);
		}
		
	}

}
