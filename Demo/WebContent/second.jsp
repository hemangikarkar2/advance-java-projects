
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>second</title>
</head>
<body>

<form action="third.jsp">
<%@include file="First.jsp" %>
UserName  : <input type="text" name="un" required ><br/>
Password  : <input type="password" name="pwd" required /><br/>
<input type="submit" name="Submit"/>
</form>

</body>
</html>