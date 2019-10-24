package com.loginandcrudoperation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditUser")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int Id=Integer.parseInt(request.getParameter("editid"));
		String FirstName=request.getParameter("editfirstname");
		String LastName=request.getParameter("editlastname");
		String EmailId=request.getParameter("editemailid");
		String Hobby=request.getParameter("edithobby");
		String CityName=request.getParameter("editcityname");
		
		DataSource ds=new DataSource();
		ds.setId(Id);
		ds.setFirstName(FirstName);
		ds.setLastName(LastName);
		ds.setEmailId(EmailId);
		ds.setHobby(Hobby);
		ds.setCityName(CityName);
		
		DataSourceList dsl=new DataSourceList();
		dsl.updateData(ds);
		
		response.sendRedirect("ShowRegisterUser.jsp");
	}

}
