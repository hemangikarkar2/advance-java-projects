<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.sql.* "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<form action="insert.jsp" align="center">
		<br />
		<br />
		<table align="center" border="2" cellspacing="2" cellpadding="10">
			<input type="hidden" name="id" />
			<tr>
				<td>FirstName <input type="text" name="firstname" /><br />
				<br /></td>
			</tr>
			<tr>
				<td>LastName <input type="text" name="lastname" /><br />
				<br /></td>
			</tr>
			<tr>
				<td>UserName<input type="text" name="username" /><br />
				<br /></td>
			</tr>
			<tr>
				<td>Password <input type="password" name="password" /><br />
				<br /></td>
			</tr>


			<tr>
				<td><input type="submit" value="Register" /></td>
			</tr>
		</table>
	</form>

</body>
</html>