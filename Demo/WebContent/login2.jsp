<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String s1 =new String("admin");
String s2=new String("admin");

String uname =request.getParameter("username");
out.println(uname);
String pass = request.getParameter("password");
out.println(pass);

if(uname.equals(s1) && pass.equals(s2))
{
	response.sendRedirect("welcome.jsp");
}else{
	response.sendRedirect("login.jsp");
	
}
%>
</body>
</html>