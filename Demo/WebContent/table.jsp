<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Table</h1>
<table border='1' height='250' width='250'>
<%		for(int i=0;i<=10;i++)
	{ if(i%2==0){ %>
	
	<tr><td bgcolor='Blue'><%out.println(i); %></td></tr>
	<% }else { %>
	<tr>
	<td bgcolor='green'><%out.println(i);%></td></tr><%} %>
	<%} %>
	
	




</table>
</body>
</html>