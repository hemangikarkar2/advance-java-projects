<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<%@taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<f:form action="insertState.html" method="post" modelAttribute="data">

CountryName:
	<f:select path="countryVO.countryId">
		<c:forEach items="${countryList}" var="i">
			<option value="${i.countryId}">${i.countryName}</option>
		</c:forEach>
	</f:select>
	
	<br><br>

StateName:<f:input path="stateName"/>
<br>
<f:hidden path="stateId"/>
<br>



<input type="submit" value="submit">
</f:form><br/>

<a href="searchState.html"> Search State</a>

</body>
</html>