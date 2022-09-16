<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title >3rd verify</title>
</head>
<body>

<%
String s1= (String)session.getAttribute("f3");
String uname =request.getParameter("username");

String s2=(String)session.getAttribute("f4");
String pass = request.getParameter("password");

if(uname.equals(s1) && pass.equals(s2))
{
	response.sendRedirect("welcomme.jsp");
}
//else if(uname.equals(null) || pass.equals(null)){
	//session.setAttribute("message","Invalid Username OR Password !!");}
else{
	
	session.setAttribute("message","Invalid Username OR Password !!");
	response.sendRedirect("loginn.jsp");
	
	}
%>
</body>
</html>