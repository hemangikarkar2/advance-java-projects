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
String s5 =request.getParameter("fn");
String s6 =request.getParameter("ln");
String s7 =request.getParameter("un");
String s8 =request.getParameter("pwd");

out.println(s5);
out.println(s6);
out.println(s7);
out.println(s8);

%>

</body>
</html>
