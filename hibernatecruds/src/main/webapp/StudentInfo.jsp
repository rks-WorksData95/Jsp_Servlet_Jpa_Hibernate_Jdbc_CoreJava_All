<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<p align="center" style="font-size:21px;"><b>Student Information</b></p>
	
	<form method="post" action="insertStudent">
		<table border="1" align="center">
			
			<tr>
				<td>StudentName :</td>
				<td><input type="text"  name="studentname" required></td>
			</tr>
			
			<tr>
				<td>StudentAddress  :</td>
				<td><input type="text" name="studentaddress" required></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Register" ></td>
			</tr>
			
		</table>
		
	</form>
</body>
</html>