<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
</head>
<body>
<f:form action="insert" method="post" modelAttribute="Data">
	
FirstName : <f:input path="firstName"/><br/><br/>

LastName: <f:input path="lastName"/><br/><br/>

<f:hidden path="id"/>

<input type="submit" value="Submit"> 

</f:form><br/>
<a href="Search">Search</a><br/>
</body>
</html>