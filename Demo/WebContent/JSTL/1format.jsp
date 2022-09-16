<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="P.*"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transi tional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>format-16/03/2020</title>
</head>
<body>

Choose Language???

<a href="1format.jsp">English</a><br/>
<a href="1format.jsp?flag=hi">Hindi</a><br/>
<a href="1format.jsp?flag=gu">Gujarati</a>


<fmt:setLocale value="${param.flag}"/>
<fmt:setBundle basename="m" var="i"/>

<fmt:message bundle="${i}" key="fn"></fmt:message><input type="text"></input><br/>
<fmt:message bundle="${i}" key="ln"></fmt:message><input type="text"></input><br/>




</body>
</html>