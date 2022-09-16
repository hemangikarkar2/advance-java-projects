<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD html 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CITY SEARCH PAGE</title>
</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<body>
<table border="1px solid black">
<tr><td>ID</td>
<td>Country_name</td>
<td>State_name</td>
<td>City_name</td>
<td>Action</td></tr>
<c:forEach var="i" items="${sessionScope.list3}">
<tr><td>${i.id}</td>
<td>${i.c.cn}</td>
<td>${i.sv.sn}</td>
<td>${i.city}</td>
<td><a href="CityController?id=${i.id}&flag=delete">Delete</a>
<a href="CityController?id=${i.id}&flag=edit">Edit</a></td></tr>
</c:forEach>
</table>

</body>
</html>