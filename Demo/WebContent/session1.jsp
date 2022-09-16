<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>session-1</title>
</head>
<body>

<%
request.setAttribute("fn","hemangi" );
session.setAttribute("mn", "natvarbhai");
application.setAttribute("ln", "karkar");
session.setAttribute("hi", 456);
%>
<a href="session2.jsp">click me</a>
</body>
</html>