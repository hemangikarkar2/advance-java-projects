<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Country Page</title>
</head>
<body>
<f:form action="insert.html" method="post" modelAttribute="Data">
Country Name :<f:input path="countryName" /><br/><br/>
<f:hidden path="countryId" />
<input type="submit" value="submit">

</f:form>
<a href="search1.html">Search Country</a>
</body>
</html>