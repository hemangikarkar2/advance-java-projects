<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
</head>
<body>
<f:form action="insert.html" method="post" modelAttribute="Data">
First Name :<f:input path="firstName"/><br/>
Last Name  :<f:input path="lastName"/><br/>
User Name  :<f:input path="LoginVO.userName"/><br/>
Password   :<f:input path="loginVO.password"/><br/>
<f:hidden path="id"/>
<input type="submit" value="SUBMIT" />

</f:form>
<a href="search.html">Search Here.....</a>
</body>
</html>