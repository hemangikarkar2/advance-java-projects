<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="<%=request.getContextPath() %>/regController" method="post">
<table border="1px solid black">

<c:forEach items="${sessionScope.EditList}" var="i">
<tr>
	<td>First Name</td>
	<td><input type="text" name="firstName" value="${i.fn}"></td>
</tr>

<tr>
	<td>Last Name</td>
	<td><input type="text" name="lastName"  value="${i.ln}"></td>
</tr>

<tr>
	<td>Department</td>
	<td>
		<select name="department" value="${i.dept}"><option>Manager</option>
				<option>Developer</option>
				<option>Designer</option>
				<option>Tester</option>
		</select>
	</td>
</tr>

<tr>
	<td>employee id</td>
	<td><input type="text" name="empid"  value="${i.empid}"></td>
</tr>

<tr>
	<td>password</td>
	<td><input type="text" name="password"  value="${i.pwd}"></td>
</tr>

<tr>
	<td colspan="2">
		<input type="hidden" name="flag" value="update">
		<input type="hidden" name="id" value="${i.id}">
		<center><input type="submit" value="update"></center>
		
	</td>
</tr>
</c:forEach>
</table>
</form>

</body>
</html>