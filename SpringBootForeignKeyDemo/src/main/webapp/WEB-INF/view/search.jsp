<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search page</title>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
</head>
<body>
<table border="2" align="center">
<tr>
<td>ID</td>
<td>FirstName</td>
<td>LastName</td>
<td>UserName</td>
<td>Password</td>

</tr>
<c:forEach items="${searchList}" var="p" varStatus="j">
<tr>
	<td>${j.count}</td>
	<td>${p.regVO.firstName}</td>
	<td>${p.regVO.lastName}</td>
	<td>${p.loginVO.userName}</td>
	<td>${p.loginVO.password}</td>
	
</tr>
</c:forEach>
</table>
</body>
</html>