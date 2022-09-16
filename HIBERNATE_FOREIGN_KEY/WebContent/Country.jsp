<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD html 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>COUNTRY PAGE</title>
</head>
<body>
<form action="CountryController" method="post">
COUNTRY_NAME:<input type="text" name="cn"/><br/><br/>
<input type="hidden" name="flag" value="insert">
<input type="submit" value="SUBMIT"/>

</form>

<a href="CountryController?flag=search">SEARCH HERE</a>

</body>
</html>