<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form><input type="hidden" name="flag" value="delete"></form>
<table border="2" align="center">
<tr><td>id</td>
<td>firstname</td>
<td>lastname</td>
<td>Action</td>
</tr>
<tr>
<c:forEach items="${sessionScope.ls}" var="i">
<td>${i.id}</td>
<td>${i.fn}</td>
<td>${i.ln}</td>
<td><a href="regcon?id=${i.id}&flag=delete">delete&nbsp;&nbsp;&nbsp;
<a href="regcon?uid=${i.id}&flag=edit">edit</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>