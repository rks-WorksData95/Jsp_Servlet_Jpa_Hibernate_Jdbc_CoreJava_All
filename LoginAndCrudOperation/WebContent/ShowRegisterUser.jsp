<%@page import="java.util.ArrayList"%>
<%@page import="com.loginandcrudoperation.DataSourceList"%>
<%@page import="com.loginandcrudoperation.DataSource"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Register User</title>
</head>
<body>
	
	<%
		HttpSession getSessionObject=request.getSession();
		String checkSession=(String)getSessionObject.getAttribute("UserName");
		if(checkSession==null)
		{
			response.sendRedirect("Login.jsp");
		}
	%>
	
	<h2 align="center">Welcome : <%=checkSession %></h2>
	
	<h2 align="center">User Details</h2>
	
	<table border="1" align="center">
	
		<tr>
			<td>ID</td>
			<td>FirstName</td>
			<td>LastName</td>
			<td>EmailId</td>
			<td>MobileNo</td>
			<td>CityName</td>
			<td>Edit</td>
			<td>Delete</td>
		<tr>
	
	<% for(DataSource ds1 :DataSourceList.RegisterData) 
		{
	%>
		<tr>
			<td><%=ds1.getId() %></td>
			<td><%=ds1.getFirstName() %></td>
			<td><%=ds1.getLastName() %></td>
			<td><%=ds1.getEmailId() %></td>
			<td><%=ds1.getHobby() %></td>
			<td><%=ds1.getCityName() %></td>
			<td><a href="EditForm.jsp?Id=<%=ds1.getId()%>">Edit</a></td>
			<td><a href="DeleteUser?Id=<%=ds1.getId()%>">Delete</a></td>
		<tr>
	<%	} %>
	</table>
	
	<br><br><br>
	<center>
		<a href="UserRegistrationForm.jsp">Register New User</a>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="Logout">Logout</a>
	</center>
	
</body>
</html>