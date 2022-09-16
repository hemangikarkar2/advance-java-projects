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
<table border="1px solid black">
<tr>
	<td>Id</td>
	<td>FirstName</td>
	<td>LastName</td>
	<td>Department</td>
	<td>Employee id</td>
	<td>Action</td>
</tr>

<c:forEach items="${sessionScope.SearchList}" var="i" varStatus="j">
<tr>

	<td>${j.count}</td>
	<td>${i.fn}</td>
	<td>${i.ln}</td>
	<td>${i.dept}</td>
	<td>${i.empid}</td>
	<td>${i.pwd}</td>
	<td>
		<a href="<%=request.getContextPath() %>/regController?flag=delete&id=${i.id}">Delete</a>&nbsp&nbsp&nbsp
		<a href="<%=request.getContextPath() %>/regController?flag=edit&id=${i.id}">Edit</a>&nbsp&nbsp&nbsp
	</td>
		
</tr>
</c:forEach>

</table>
</body>
</html>