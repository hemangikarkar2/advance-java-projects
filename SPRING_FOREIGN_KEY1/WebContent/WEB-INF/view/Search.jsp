<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<body>

<table border="1px solid black">
<tr>
	<th>Id</th>
	<th>FirstName</th>
	<th>LastName</th>
	<th>UserName</th>
	<th>Password</th>
	<th colspan="2">Action</th>
	
</tr>
<c:forEach items="${searchList}" var="p" varStatus="j">
<tr>
	<td>${j.count}</td>
	<td>${p.firstName}</td>
	<td>${p.lastName}</td>
	<td>${p.loginVO.userName}</td>
	<td>${p.loginVO.password}</td>
	<td>
		<a href="delete.html?rid=${p.id}&lid=${p.loginVO.id}">Delete</a>
		<a href="edit.html?rid=${p.id}&lid=${p.loginVO.id}">Edit</a>
	</td>
</tr>
</c:forEach>
</table>

</body>
</html>