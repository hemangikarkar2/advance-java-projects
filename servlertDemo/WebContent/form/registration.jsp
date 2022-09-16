<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registation</title>
</head>
<body>

<form align="center" action="<%=request.getContextPath()%>/save" method="post">
<table align="center" border="2" cellspacing="2" cellpadding="10">
<tr><td>Firstname<input type="text" name="fn"/></td></tr>
<tr><td>Lastname<input type="text" name="ln"/></td></tr>
<tr><td>Username<input type="text" name="un"/></td></tr>
<tr><td>Password<input type="password" name="pwd"/></td></tr>

<tr><td><input type="submit" name="submit"/></td></tr>
</table>
</form>
</body>
</html>