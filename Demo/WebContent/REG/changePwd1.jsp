<%@page import="org.apache.tomcat.dbcp.dbcp2.DriverManagerConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>change password</title>
</head>
<%Integer id=(Integer)session.getAttribute("id"); %>
<body>
	<form action="changePwd2.jsp">
		<table border="1" align="center" cellspacing="1" cellpadding="10">
		
		<input type="hidden" name="id" value="<%=id%>">
			<tr>
				<td>New Password<input type="password" name="newpassword"></td>
			</tr>
			<tr>
				<td>confirm Password<input type="password"
					name="confirmpassword"></td>
				
			</tr>
			<tr>
				<td>old Password<input type="password" name="oldpassword"><br /></td>
			</tr>
			<tr>
				<td align="center"><input type="submit" name="Save" value="Save"></td>
			</tr>
		</table>
	</form>
</body>
</html>