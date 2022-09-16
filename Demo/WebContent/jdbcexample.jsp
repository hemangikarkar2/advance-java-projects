<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String s1 = new String("Carran");
	String s2 = new String("Ghelani");

	Class.forName("com.mysql.jdbc.Driver");
	Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/demodb","root","root");
	Statement s = c.createStatement();
	s.executeUpdate("INSERT INTO reg(firstname,lastname) VALUES('"+s1+"','"+s2+"')");
	c.close();
	s.close();
	
	
%>
</body>
</html>