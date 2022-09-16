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
<table border="1px solid black">
<tr>
	<td>Id</td>
	<td>FirstName</td>
	<td>LastName</td>
	<td>Action</td>
</tr>

<c:forEach items="${sessionScope.SearchList}" var="i" varStatus="j">
<tr>

	<td>${j.count}</td>
	<td>${i.firstName}</td>
	<td>${i.lastName}</td>
	<td>
		<a href="<%=request.getContextPath() %>/RegController?flag=delete&id=${i.id}">Delete</a>&nbsp&nbsp&nbsp
		<a href="<%=request.getContextPath() %>/RegController?flag=edit&id=${i.id}">Edit</a>&nbsp&nbsp&nbsp
	</td>
		
</tr>
</c:forEach>

</table>
</body>
</html>