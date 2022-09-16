<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert</title>
</head>
<body>

	<% 
String id = request.getParameter("id");
String firstname = request.getParameter("firstname");
String lastname = request.getParameter("lastname");
String username2 = request.getParameter("username");
String password2 = request.getParameter("password");


Class.forName("com.mysql.jdbc.Driver");
Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/demodb","root","root");
Statement s= c.createStatement();

int result =s.executeUpdate("INSERT INTO emp_reg (efirstname,elastname,username,password) VALUES ('"+firstname+"','"+lastname+"','"+username2+"','"+password2+"')");


	if(result==1)
    {
	response.sendRedirect("login.jsp");
    }

	else
	{
	response.sendRedirect("registration.jsp");
    }

	

c.close();
s.close();

%>
</body>
</html>