<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>demo</title>
</head>

<%!
	int count=0;
%>
<%
	String user=request.getParameter("user");
	String BorderNo=request.getParameter("tborder");
	int RowNo=Integer.parseInt(request.getParameter("row"));
%>


<jsp:useBean id="id" class="com.demo.infoBean" scope="request"/>
<jsp:setProperty property="id" value="11" name="id"/>
<jsp:setProperty property="name" value="Ram Sadhu" name="id"/>
<body>

<h1>Welcome User</h1>
<h1>${param.name}</h1>
<%--Code to show count number --%>
Page Count Is : <% out.println(++count); %>
<br>

<%
	if(user.equals("ram"))
	{
%>
		<p>Hello.Ram Sadhu</p>
<%
	}
	else
	{
%>
		<p>Hello, User</p>
<%
	}
%>

UserName Is : <% out.println(user); %>
<table border="<%=BorderNo%>">
	<%
		for(int i=0;i<RowNo;i++)
		{
	%>
			<tr>
				<td>Number</td>
				<td><%=i+1 %></td>
			</tr>
	<%
		}
	%>
	
</table>

Id   : <jsp:getProperty property="id" name="id"/>
Name : <jsp:getProperty property="name" name="id"/>

</body>
</html>