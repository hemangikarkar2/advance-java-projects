<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib  prefix="f" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>state</title>
</head>
<body>
<f:form action="insertstate.html" method="post" modelAttribute="Data">
countryName :
			<f:select path="countryVo.countryId">
			<c:forEach items="${countryList}" var="i">
			<option value="${i.countryId}"> ${i.countryName}</option>
			</c:forEach>
			</f:select>
			<br/><br/>
stateName :<f:input path="stateName"/><br/>
<f:hidden path="stateId"/>
<br/>
<input type="submit" value="submit">
</f:form> <br/>
<a href="searchstate.html">Search state</a>
</body>
</html>