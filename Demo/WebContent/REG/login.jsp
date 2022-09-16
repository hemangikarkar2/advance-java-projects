<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.* "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<form action ="save.jsp" align="center" >
<br/><br/>
<table align="center" border="1" cellspacing="2" cellpadding="10">

<tr><td >UserName<input  type="text" name="username"  /></td><br/><br/></tr>

<tr><td>Password  <input  type="password" name="password"  /></td><br/><br/></tr>

<tr><td><input type="submit" value="Login"/>&nbsp;&nbsp;&nbsp;<a href="registration.jsp"><button type="button" >Register</button></a></td></tr>

<tr><td><a href="search.jsp">search</a></td></tr>
</table>
</form>
</body>
</html>
