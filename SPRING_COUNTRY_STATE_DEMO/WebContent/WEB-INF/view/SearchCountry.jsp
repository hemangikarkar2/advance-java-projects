<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>


	<table border="1" cellspacing="0px">
		<tr>
			<th>countryId</th>
			<th>countryName</th>
			<th>action</th>


		</tr>

		<c:forEach items="${searchList}" var="i" varStatus="j">
			<tr>
				<td>${j.count}</td>
				<td>${i.countryName}</td>
				<td colspan="2">
				<a href="delete.html?id=${i.countryId}">Delete</a>
				<a href="edit.html?id=${i.countryId}">Edit</a></td>
				
			</tr>
			</c:forEach>
	</table>

</body>
</html>
