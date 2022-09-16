<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD html 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MENU PAGE</title>
</head>
<body>
<a href="Country.jsp">ADD COUNTRY</a><br/>
<a href="<%=request.getContextPath()%>/StateController?flag=searchCountry">ADD STATE</a><br/>
<a href="<%=request.getContextPath()%>/CityController?flag=searchState">ADD CITY</a><br/><br/>
</body>
</html>