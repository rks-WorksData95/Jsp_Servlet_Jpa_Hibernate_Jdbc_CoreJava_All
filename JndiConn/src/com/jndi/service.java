package com.jndi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class service 
{
	Connection conn=null;
	
	ArrayList<details> data=new ArrayList<details>();
	
	public void getConnection() throws NamingException, SQLException
	{
		if(conn==null || conn.isClosed())
		{
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env/");
			DataSource ds = (DataSource)envContext.lookup("jdbc/TestDB");
			conn = ds.getConnection();
			System.out.println("Connected successfully to database.");
		}
	}	
	
	public void disConnect() throws SQLException
	{
		if(conn!=null || !conn.isClosed())
		{
			conn.close();
			System.out.println("Disconnected to database successfully.");
		}
	}
	
	public ArrayList<details> viewRecord()
	{
		try
		{
			String fetchQuery="SELECT * FROM userdetails";
			
			getConnection();
				
			Statement statement=conn.createStatement();
			ResultSet resultset=statement.executeQuery(fetchQuery);
			
			
			while(resultset.next())
			{
				 details d=new details();
				 d.setId(resultset.getInt("Id"));
				 d.setFirstName(resultset.getString("FirstName"));
				 d.setLastName(resultset.getString("LastName"));
				 d.setEmailId(resultset.getString("EmailId"));
				 d.setHobby(resultset.getString("Hobby"));
				 d.setCityName(resultset.getString("CityName"));
				 
				 data.add(d);
			}
			
			resultset.close();
			statement.close();
			disConnect();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(NamingException n)
		{
			n.printStackTrace();
		}
		
		return data;
	}
}
