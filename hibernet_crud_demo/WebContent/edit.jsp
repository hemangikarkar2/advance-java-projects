<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="<%=request.getContextPath() %>/regcontroller" method="post">
<table border="1px solid black">

<c:forEach items="${sessionScope.EditList}" var="i">
<tr>
	<td>First Name</td>
	<td><input type="text" name="firstName" value="${i.firstName}"></td>
</tr>

<tr>
	<td>Last Name</td>
	<td><input type="text" name="lastName"  value="${i.lastName}"></td>
</tr>

<tr>
	<td colspan="2">
		<input type="hidden" name="flag" value="update">
		<input type="hidden" name="id" value="${i.id}">
		<center><input type="submit" value="Edit"></center>
		
	</td>
</tr>
</c:forEach>
</table>
</form>

</body>
</html>