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
String Firstname = request.getParameter("FirstName");
String Lastname  = request.getParameter("LastName");
String ADdress  = request.getParameter("Address");
String HObbies  = request.getParameter("Hobbies");
String GEnder = request.getParameter("Gender");
String course11 ="";
String COurse[]  = request.getParameterValues("Course");
for(int i=0;i<COurse.length;i++)
{
	course11+=COurse[i]+" ";
}

Class.forName("com.mysql.jdbc.Driver");
Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/demodb","root","root");
Statement s= c.createStatement();
int result=s.executeUpdate("Insert into registration (firstname,lastname,address,hobbies,gender,course) values ('"+Firstname+"','"+Lastname+"','"+ADdress+"','"+HObbies+"','"+GEnder+"','"+course11+"')");
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