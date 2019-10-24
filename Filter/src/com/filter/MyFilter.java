package com.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, urlPatterns = { "/MyFilter" }, servletNames = { "First" })
public class MyFilter implements Filter {


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		
		PrintWriter out = response.getWriter();
		String UserName = request.getParameter("username");
        String Password = request.getParameter("password");
        if(UserName.equals("RamSadhu") && Password.equals("ramsadhu"))
        {
        	chain.doFilter(request, response);   
        }
        else
        {
            out.println("You have enter a wrong password");
            RequestDispatcher rs = request.getRequestDispatcher("index.html");
            rs.include(request, response);
        }
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
	
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	

}
