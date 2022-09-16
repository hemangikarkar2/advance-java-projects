<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD html 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CITY SEARCH PAGE</title>
</head>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<body>

<form action="CityController" method="post">
<c:forEach items="${sessionScope.list3}" var="i">

	Country <select name="cn">
			<c:forEach items="${sessionScope.list1}" var="j">
				<option value="${j.id}">${j.cn}</option>
			</c:forEach>
		</select><br/>
	
	State <select name="sn">
			<c:forEach items="${sessionScope.list2}" var="k">
				<option value="${k.id}">${k.sn}</option>
			</c:forEach>
		</select><br/>
	
	CITY_NAME<input type="text" name="city" value="${i.city}"><br/>
	<input type="hidden" name="id" value="${i.id}"/><br/>
	<input type="hidden" name="flag" value="update"><br/>
	<input type="submit" value="Edit"><br/><br/>
	
</c:forEach>
</form>
</body>
</html>