<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD html 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>STATE PAGE</title>
</head>
<body>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %> 
<body>
<form action="StateController" method="post">
COUNTRY_NAME:
<select name="country">
<c:forEach items="${sessionScope.CountryList}" var="i" >
	<option value="${i.id}">${i.cn}</option>
</c:forEach>	
</select><br/>
STATE_NAME:<input type="text" name="sn"/><br/><br/>
<input type="hidden" name="flag" value="insert">
<input type="submit" value="SUBMIT"/>
</form>
<a href="StateController?flag=searchState">SEARCH HERE</a>
</body>
</html>