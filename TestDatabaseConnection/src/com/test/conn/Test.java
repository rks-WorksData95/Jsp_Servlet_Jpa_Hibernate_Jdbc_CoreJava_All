package com.test.conn;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static final String url = "jdbc:mysql://localhost:3306/test";
	   private static final String user = "root"; 
	   private static final String password = "root"; 
	   

	   
	   private static Connection con;
	   private static Statement stmt; 
	   private static ResultSet rs;
	   
    public Test() {
       
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   System.out.println("----------------Test---------------------");
	   
	   String query = "select count(*) from userdetails"; 
		try {
				con = DriverManager.getConnection(url, user, password);
				stmt = con.createStatement();
				rs = stmt.executeQuery(query);
				while (rs.next()) 
					{
						int count = rs.getInt(1);
						System.out.println("Total number no of recordes in the table : " + count); 
					}
		   }
			catch (SQLException sqlEx) {
	            sqlEx.printStackTrace();
	        } 
		 
	}

}
