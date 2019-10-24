package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseConnection 
{
	String connectionUrl="jdbc:mysql://localhost:3307/test";
	String userName="root";
	String Password="root";
	Connection con=null;
	
	ArrayList<DataSource> UserData=new ArrayList<DataSource>();
	
	public void connect()
	{
		try
		{
			if(con==null || con.isClosed())
			{
				Class.forName("com.mysql.jdbc.Driver");
				con=(Connection)DriverManager.getConnection(connectionUrl,userName, Password);
				System.out.println("Connected successfully to database.");
			}
		}
		catch(Exception e)
		{
			System.out.println("Not Connected to database."+e);
		}
	}
	
	public void disConnect() throws SQLException
	{
		if(con!=null || !con.isClosed())
		{
			try
			{
				con.close();
			}
			catch (SQLException e)
			{	
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<DataSource> fetchUserDetails() throws SQLException
	{
		String fetchQuery="SELECT * FROM userdetails";
		
		connect();
			
		Statement statement=con.createStatement();
		ResultSet resultset=statement.executeQuery(fetchQuery);
		
		
		while(resultset.next())
		{
			 DataSource ds=new DataSource();
			 ds.setId(resultset.getInt("Id"));
			 ds.setFirstName(resultset.getString("FirstName"));
			 ds.setLastName(resultset.getString("LastName"));
			 ds.setEmailId(resultset.getString("EmailId"));
			 ds.setHobby(resultset.getString("Hobby"));
			 ds.setCityName(resultset.getString("CityName"));
			 
			 UserData.add(ds);
		}
		
		resultset.close();
		statement.close();
		disConnect();
		
		return UserData;
	}
	
}
