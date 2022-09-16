<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD html 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>COUNTRY SEARCH PAGE</title>
</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<body>
<table border="1px solid black">
<tr>
	<td>ID</td>
	<td>Country_name</td>
	<td>Action</td>
</tr>

<c:forEach var="i" items="${sessionScope.CountryList}" varStatus="j">
<tr>
	<td>${j.count}</td>
	<td>${i.cn}</td>
	<td><a href="CountryController?id=${i.id}&flag=delete">Delete</a>
	<a href="CountryController?id=${i.id}&flag=edit">Edit</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>