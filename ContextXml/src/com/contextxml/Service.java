package com.contextxml;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public class Service 
{
	//String connectionUrl="jdbc:mysql://localhost:3307/test";
	//String userName="root";
	//String Password="root";
	public static Connection getConnection() throws NamingException, SQLException {
		
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/TestDB");
		Connection con = ds.getConnection();
		return con;
	}
}