<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<body>

<table border="1px solid black">
<tr><td>ID</td>
<td> Country name </td>
<td> State name </td>
<td> Action </td></tr>
<c:forEach var="i" items="${sessionScope.StateList}" varStatus="j">
<tr>
	<td>${j.count}</td>
	<td>${i.con.countryname}</td>
	<td>${i.statename}</td>
	<td><a href="Statecontroller?id=${i.id}&flag=delete">Delete</a>
		<a href="Statecontroller?id=${i.id}&flag=edit">Edit</a></td>
</tr>
</c:forEach>
</table>

</body>
</html>