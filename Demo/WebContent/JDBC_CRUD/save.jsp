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
String firstname = request.getParameter("FirstName");
String lastname  = request.getParameter("LastName");
String address  = request.getParameter("Address");
String hobbies  = request.getParameter("Hobbies");
String gender = request.getParameter("Gender");
String course11 ="";
String course[]  = request.getParameterValues("Course");
for(int i=0;i<course.length;i++)
{
	course11+=course[i]+" ";
}

Class.forName("com.mysql.jdbc.Driver");
Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/demodb","root","root");
Statement s= c.createStatement();
int result=s.executeUpdate("Insert into registration (firstname,lastname,address,hobbies,gender,course) values ('"+firstname+"','"+lastname+"','"+address+"','"+hobbies+"','"+gender+"','"+course11+"')");
c.close();
s.close();

if(result==1){
	response.sendRedirect("search.jsp");
}
else{
	response.sendRedirect("form.jsp");
}
%>

</body>
</html>