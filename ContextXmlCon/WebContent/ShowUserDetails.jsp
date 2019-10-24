<%@page import="com.context.*"%>
<%@page import="com.context.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show User Details</title>
</head>
<body>
	
	<h2 align="center">User Details</h2>
	
	<table border="1" align="center">
	
		<tr>
			<td>ID</td>
			<td>FirstName</td>
			<td>LastName</td>
			<td>EmailId</td>
			<td>MobileNo</td>
			<td>CityName</td>
		<tr>
		
	<%
		service s=new service();
		ArrayList<details> data=s.viewRecord();
	%>
	
	<% for(details ds1:data) 
		{
	%>
		<tr>
			<td><%=ds1.getId() %></td>
			<td><%=ds1.getFirstName() %></td>
			<td><%=ds1.getLastName() %></td>
			<td><%=ds1.getEmailId() %></td>
			<td><%=ds1.getHobby() %></td>
			<td><%=ds1.getCityName() %></td>
		<tr>
	<%	} %>
	</table>
</body>
</html>