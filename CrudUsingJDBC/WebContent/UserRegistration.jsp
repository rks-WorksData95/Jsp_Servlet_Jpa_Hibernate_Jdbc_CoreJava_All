<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New User Registration</title>
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
	<p align="center" style="font-size:21px;"><b>Welcome : <%=checkSession %></b></p>
	<form method="post" action="UserRegistration" >
		
		<p align="center" style="font-size:21px;"><b>User Registration</b></p>
		<table border="1" align="center">
			
			<tr>
				<td>FirstName :</td>
				<td><input type="text"  name="firstname" required></td>
			</tr>
			
			<tr>
				<td>Lastname  :</td>
				<td><input type="text" name="lastname" required></td>
			</tr>
			
			<tr>
				<td>EmailId  :</td>
				<td><input type="text" name="emailid" required></td>
			</tr>
			
			<tr>
				<td> Hobby  :</td>
				<td>
					<select name="hobby" required pattern="[A-Z]">
						<option value="" selected disabled hidden>Select Hobby</option>
						<option value="Cricket">Cricket</option>
						<option value="Football">Football</option>
						<option value="Reading">Reading</option>
						<option value="Music">Music</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<td> CityName  :</td>
				<td><input type="text" name="cityname" required></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Register" ></td>
			</tr>
			
		</table>
		
	</form>
</body>
</html>