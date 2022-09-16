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
String s1= (String)request.getAttribute("fn");
String s2=(String)session.getAttribute("mn");
String s3=(String)application.getAttribute("ln");
//String s4=(String)session.getAttribute("hi");
//int s4 =(int)session.getAttribute("hi");
Integer s4 =(Integer)session.getAttribute("hi");
out.println(s1+"</br>");
out.println(s2+"</br>");
out.println(s3+"</br>");
out.println(s4);
session.removeAttribute("mn");
%>
<a href="session4.jsp">click</a>
</body>
</html>