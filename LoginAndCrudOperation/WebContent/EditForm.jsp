<%@page import="com.loginandcrudoperation.DataSourceList"%>
<%@page import="com.loginandcrudoperation.DataSource"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Form</title>
</head>
<body>
	<form method="post" action="EditUser" >
		
		<p align="center" style="font-size:large;"><b>Update User</b></p>
		<table border="1" align="center">
			<% int Id=Integer.parseInt(request.getParameter("Id")); %>
			<%for(DataSource ds:DataSourceList.RegisterData)
			  {
				if(Id==ds.getId())
				{
			%>
			    
			<tr>
				<td>FirstName :</td>
				<td><input type="text"  name="editfirstname" value="<%=ds.getFirstName()%>"></td>
			</tr>
			
			<tr>
				<td>Lastname  :</td>
				<td><input type="text" name="editlastname" value="<%=ds.getLastName()%>"></td>
			</tr>
			
			<tr>
				<td>EmailId  :</td>	
				<td><input type="text" name="editemailid" value="<%=ds.getEmailId()%>"></td>
			</tr>
			
			<tr>
				<td> Hobby  :</td>
				<td>
					<select id="hobby" name="edithobby">
						<option value="0" selected disabled hidden>Select Hobby</option>
						<option value="Cricket" <%if(ds.getHobby().equals("Cricket")) { %> selected <% } %>>Cricket</option>
						<option value="Football" <%if(ds.getHobby().equals("Football")) { %> selected <% } %> >Football</option>
						<option value="Reading" <%if(ds.getHobby().equals("Reading")) { %> selected <% } %> >Reading</option>
						<option value="Music" <%if(ds.getHobby().equals("Music")) { %> selected <% } %> >Music</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<td> CityName  :</td>
				<td><input type="text" name="editcityname" value="<%=ds.getCityName()%>"></td>
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