<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>

	<%
		Integer id = (Integer) session.getAttribute("id");
		out.println("Welcome   !!");
	%>

	<br />
	<br />
	<br />

	<form action="changePwd1.jsp">
		<input type="submit" value="changepassword" />&nbsp;&nbsp;
	</form>

	<a href="login.jsp">
		<button type="submit">logout</button>
	</a>



</body>
</html>