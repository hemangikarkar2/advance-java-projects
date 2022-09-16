<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>country</title>
</head>
<body>
<form  action="countrycontroller" method="post">
Country : <input type="text" name="countryname">
<input type="hidden" name="flag" value="insert">
<input type="submit" name="Submit">
<br/>
</form>
<a href="countrycontroller?flag=search">search</a>
</body>
</html>