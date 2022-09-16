<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
</head>
<body>
<form align="center" action="<%=request.getContextPath() %>/verify1" method="post">
<table align="center" border="2" cellspacing="2" cellpadding="10">

<tr><td>Username<input type="text" name="un"/></td></tr>
<tr><td>Password<input type="password" name="pwd"/></td></tr>
<tr><td><input type="submit" name="submit"/></td></tr>
<tr><td><a href="<%=request.getContextPath()%>/search">search</a></td></tr>
</table>
</form>
</body>
</html>