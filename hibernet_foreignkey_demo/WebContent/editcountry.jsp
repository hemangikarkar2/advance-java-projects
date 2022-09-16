<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        
<%@ taglib  prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Country page</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/countrycontroller" method="post">
	
	<c:forEach items="${sessionScope.EditList}" var="i">
	
		country name<input type="text" name="countryName" value="${i.countryName}"><br/>
	
		<input type="hidden" name="id" value="${i.id}"/><br/>
	
	</c:forEach>
	
	<input type="hidden" name="flag" value="update"><br/>
	<input type="submit" value="Edit"><br/><br/>
	
</form>
</body>
</html>