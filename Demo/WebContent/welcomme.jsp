<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>4th welcome</title>
</head>
<body>
<%
String s1 = (String)session.getAttribute("f1");
String s2 = (String)session.getAttribute("f2");
out.println("Welcome "+s1+"\t\t"+s2+"<br/>");
%>
<form action="loginn.jsp">
<input type="submit" name="Logout">
</form>
</body>
</html>