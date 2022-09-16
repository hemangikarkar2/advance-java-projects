<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD html 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CITY JSP PAGE</title>
</head>
<body>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %> 
<body>
<form action="CityController" method="post">
COUNTRY_NAME:
<select name="country">
<c:forEach items="${sessionScope.list1}" var="i" >
	<option value="${i.id}">${i.cn}</option>
</c:forEach>	
</select><br/>

STATE_NAME:
<select name="state">
<c:forEach items="${sessionScope.list2}" var="i" >
	<option value="${i.id}">${i.sn}</option>
</c:forEach>	
</select><br/>

CITY_NAME:<input type="text" name="city"/><br/><br/>
<input type="hidden" name="flag" value="insert">
<input type="submit" value="SUBMIT"/>
</form>

<a href="CityController?flag=searchCity">SEARCH HERE</a>

</body>
</html>