<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert</title>
</head>
<body>
	<%
		String username1 = request.getParameter("username");
		String password1 = request.getParameter("password");

		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/demodb", "root", "root");
		Statement s = c.createStatement();
		ResultSet resultset = s.executeQuery(
				"SELECT * FROM emp_reg WHERE username = '" + username1 + "' AND  password='" + password1 + "';");

		if (resultset.next()) {
			int id = resultset.getInt("id");
			String username = resultset.getString("username");
			String password = resultset.getString("password");
			session.setAttribute("username", username1);
			session.setAttribute("id", id);

			response.sendRedirect("welcome.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}
		c.close();
		s.close();
	%>
</body>
</html>