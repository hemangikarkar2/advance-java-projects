<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>2nd login</title>
</head>
<body>

<form action="verifyy.jsp">
Username<input type="text" name="username" required></br>
Password<input type="password" name="password" required></br>
<input type="submit" name="submit">

</form>
<%
String s1= (String)session.getAttribute("message");

if(s1 != null ){
out.println(s1);

}
session.removeAttribute("message");

%>
</body>
</html>