<%@page import="com.Util.StudentInfo"%>
<%@page import="com.Dao.StudentMain"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Information</title>
</head>
<body>
	<h2 align="center">Student Details</h2>
	
	<table border="1" align="center">
	
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Address</td>
			<td>Edit</td>
			<td>Delete</td>
		<tr>
	
	<%
		StudentMain sMain=new StudentMain();
		List<StudentInfo> viewStudent=sMain.viewStudent();
	%>
	
	<% for(StudentInfo sInfo :viewStudent) 
		{
	%>
		<tr>
			<td><%=sInfo.getId() %></td>
			<td><%=sInfo.getName() %></td>
			<td><%=sInfo.getAddress() %></td>
			<td><a href="EditStudent.jsp?studentId=<%=sInfo.getId()%>">Edit</a></td>
			<td><a href="EditAndDeleteStudent?studentId=<%=sInfo.getId()%>">Delete</a></td>
		<tr>
	<%	} %>
	</table>
	
	<br><br><br>
	<center>
		<a href="StudentInfo.jsp">Register New Student</a>
	</center>
</body>
</html>