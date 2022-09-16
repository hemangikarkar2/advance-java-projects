<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete</title>
</head>
<body>
<%
Class.forName("com.mysql.jdbc.Driver");
Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/demodb","root","root");
String did = request.getParameter("did");
Statement s1 = c.createStatement();
if(did!=null){
	s1.executeUpdate("delete from registration where id='"+did+"'");
}
else{
	out.print("There is prome in Delete row");
}
response.sendRedirect("search.jsp");


%>
</body>
</html>