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
<table border="1">
<tr><td>Id</td>
	<td>CountryName</td>
	<td>StateName</td>
	<td>Action</td>
</tr>
<c:forEach items="${stateList}" var="i" varStatus="j">
<tr> <td>${j.count}</td>
	<td>${i.countryVo.countryName}</td>
	<td>${i.stateName}</td>
	<td clospan="2"><a href="deletestate.html?sid=${i.stateId}">Delete</a>&nbsp;&nbsp;
					<a href="editstate.html?sid=${i.stateId}">Edit</a>
	</td> 
</tr>
</c:forEach>
</body>
</html>