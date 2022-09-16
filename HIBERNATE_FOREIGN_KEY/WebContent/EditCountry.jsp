<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD html 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EDIT COUNTRY PAGE</title>
</head>

<body>

<form action="<%=request.getContextPath()%>/CountryController" method="post">
	
	<c:forEach items="${sessionScope.EditList}" var="i">
	
		COUNTRY_NAME<input type="text" name="cn" value="${i.cn}"><br/>
	
		<input type="hidden" name="id" value="${i.id}"/><br/>
	
	</c:forEach>
	
	<input type="hidden" name="flag" value="update"><br/>
	<input type="submit" value="Edit"><br/><br/>
	
</form>
</body>
</html>