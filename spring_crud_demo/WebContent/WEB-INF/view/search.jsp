<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
</head>
<body>
<table align="center" border="2">
<tr>
	<th>ID</th>
	<th>FIRSTNAME</th>
	<th>LASTNAME</th>
	<th>ACTION</th>
</tr>
<c:forEach items="${SearchList}" var="p">
<tr>
	<td>${p.id}</td>
	<td>${p.FirstName}</td>
	<td>${p.LastName}</td>
	<td colspan="1"><a href="delete.html?Id=${p.id}">Delete</a>&nbsp;&nbsp;&nbsp;<a href="edit.html?Id=${p.id}">Edit</a></td><td></td>
</tr>
</c:forEach>
</table>
</body>
</html>