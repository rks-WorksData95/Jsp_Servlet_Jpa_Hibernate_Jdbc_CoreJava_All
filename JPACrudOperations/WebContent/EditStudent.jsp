<%@page import="com.student.entity.StudentInfo"%>
<%@page import="com.student.service.StudentService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="EditAndDeleteStudent" >
		
		<p align="center" style="font-size:large;"><b>Update Student Information</b></p>
		<table border="1" align="center">
			<% int Id=Integer.parseInt(request.getParameter("Id"));
			   StudentService sService=new StudentService();
			%>
			<%for(StudentInfo sInfo : sService.ViewStudent())
			  {
				if(Id==sInfo.getId())
				{
			%>
			    
			<tr>
				<td>StudentName :</td>
				<td><input type="text"  name="editname" value="<%=sInfo.getName()%>"></td>
			</tr>
			
			<tr>
				<td>StudentAddress  :</td>
				<td><input type="text" name="editaddress" value="<%=sInfo.getAddress()%>"></td>
			</tr>
			
			<%	
				}
			  }
			%>
			<input type="hidden" name="editid" value="<%=Id%>">
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Update" ></td>
			</tr>
			
		</table>
		
	</form>
</body>
</html>