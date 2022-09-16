<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD html 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LOGIN PAGE</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/SVLogin" method="post">
FIRST NAME<input type="text" name="firstName"><br/><br/>
LAST NAME<input type="text" name="lastName"><br/><br/>
<input type="submit" value="Submit">
</form>
</body>
</html>