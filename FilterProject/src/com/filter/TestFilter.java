package com.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class TestFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
	
		String UserName=request.getParameter("username");
		String Password=request.getParameter("password");
		
		if(UserName.equals("RamSadhu") && Password.equals("ramsadhu"))
		{
			chain.doFilter(request, response);
		}
		else
		{
			out.println("<p color='red'>You have enter a wrong username and password.</p>");
			RequestDispatcher rd=request.getRequestDispatcher("index.html"); 
			rd.forward(request, response);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		
		
	}

}
