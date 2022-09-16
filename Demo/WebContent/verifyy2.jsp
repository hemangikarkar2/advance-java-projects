<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>2nd save</title>
</head>
<body>
<%

String s1= request.getParameter("fname");
String s2= request.getParameter("lname");
String s3= request.getParameter("username");
String s4= request.getParameter("password");

session.setAttribute("f1",s1);
session.setAttribute("f2",s2);
session.setAttribute("f3",s3);
session.setAttribute("f4",s4);

String uname =request.getParameter("username");
String pass = request.getParameter("password");

response.sendRedirect("loginn.jsp");

%>

</body>
</html>