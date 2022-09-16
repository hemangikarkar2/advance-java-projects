<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>  
</head>
<body>
<table>
<tr>
	<td>Id</td>
	<td>Country name</td>
	<td>Action</td>
	</tr>

<c:forEach var="i" items="${sessionScope.countryList}" varStatus="j">
<tr>
	<td>${j.count}</td>
	<td>${i.countryName}</td>
	<td><a href="countrycontroller?id=${i.id}&flag=delete">Delete</a>
		<a href="countrycontroller?id=${i.id}&flag=edit">edit</a>
	</td>
</tr>
</c:forEach>
</table>
</body>
</html>