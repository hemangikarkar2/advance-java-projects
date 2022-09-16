<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reg1 - login form</title>
</head>
<body>
<table align="center" border="2" cellspacing="2" cellpadding="10">
<form action="<%=request.getContextPath() %>/regform" method="post">

<tr><td>Username<input type="text" name="un"/></td></tr>
<tr><td>Password<input type="password" name="pwd"/></td><input type="hidden" name="flag" value="login"></tr>
<tr><td><input type="submit" name="submit"/>
</td></tr>

</form>
<tr><td><a href="<%=request.getContextPath()%>/regform?flag=search">search</a></td></tr> 
</table>
</body>
</html>	