package com.jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;

public class DatabaseConnection 
{
	String connectionUrl="jdbc:mysql://localhost:3306/test";
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
	
	public void disConnect()
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
	
	public boolean insertUser(DataSource ds) throws SQLException
	{
		String insertQuery="INSERT INTO userdetails (FirstName, LastName, EmailId, Hobby, CityName) VALUES (?, ?, ?, ?, ?)";
			
		connect();
			
		PreparedStatement statement=con.prepareStatement(insertQuery);
		statement.setString(1, ds.getFirstName());
		statement.setString(2, ds.getLastName());
		statement.setString(3, ds.getEmailId());
		statement.setString(4, ds.getHobby());
		statement.setString(5, ds.getCityName());
		boolean insert=statement.executeUpdate() > 0;
		
		statement.close();
		disConnect();
		
		return insert;
	}
	
	public boolean fetchUser(String username,String password) throws SQLException
	{
		String fetchQuery="SELECT UserName,Password FROM userregistration";
		
		connect();
			
		Statement statement=con.createStatement();
		ResultSet resultset=statement.executeQuery(fetchQuery);
		
		boolean fetchUser=false;
		
		while(resultset.next())
		{
			String UserName=resultset.getString("UserName");
			String Password=resultset.getString("Password");
			
			if(UserName.equals(username) && Password.equals(password))
			{
				fetchUser=true;
			}
		
		}
		
		statement.close();
		resultset.close();
		disConnect();
		
		return fetchUser;
		
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
	
	public boolean updateUser(DataSource ds) throws SQLException
	{
		String updateQuery="UPDATE userdetails SET FirstName=?, LastName=?, EmailId=?, Hobby=?, CityName=? WHERE Id=?";
		connect();
			
		PreparedStatement statement=con.prepareStatement(updateQuery);
		statement.setString(1, ds.getFirstName());
		statement.setString(2, ds.getLastName());
		statement.setString(3, ds.getEmailId());
		statement.setString(4, ds.getHobby());
		statement.setString(5, ds.getCityName());
		statement.setInt(6, ds.getId());
		
		boolean update=statement.executeUpdate() > 0;
		
		statement.close();
		disConnect();
		
		return update;
	}
	
	public boolean deleteUser(DataSource ds) throws SQLException
	{
		String deleteQuery="DELETE FROM userdetails WHERE Id=?";
		connect();
			
		PreparedStatement statement=con.prepareStatement(deleteQuery);
		statement.setInt(1, ds.getId());
		
		boolean delete=statement.executeUpdate() > 0;
		
		statement.close();
		disConnect();
		
		return delete;
	}
}
