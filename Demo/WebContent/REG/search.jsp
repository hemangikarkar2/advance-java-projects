<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
</head>
<body>
<%
Class.forName("com.mysql.jdbc.Driver");
Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/demodb","root","root");
Statement s  = c.createStatement();
ResultSet resultset =null ;
String sql = "select * from emp_reg";
resultset = s.executeQuery(sql);
%>
<form  action="delete.jsp">
<table border="2" align="center" height="70px" width="1000px">
<tr align="center" height="50px"  bgcolor="yellow">
	<th></th>
	<td>id</td>
	<td>FirstName</td>
	<td>LastName</td>
	<td>UserName</td>
</tr>

<%
	while(resultset.next()){
		
		int id1=resultset.getInt("id");
		String firstname1 = resultset.getString("efirstname");
		String lastname1= resultset.getString("elastname");
		String username1 = resultset.getString("username");
		
%>		<tr align="center"><td><input type="checkbox" name="CheckSelect" value="<%=id1%>"></td>
								<td><%=id1%></td>
								<td><%=firstname1 %></td>
								<td><%=lastname1%></td>
								<td><%=username1%></td>
		</tr>	
<% } %>
	
 		<tr><td colspan ="6" align="center"><input type="submit" value="DELETE"></td></tr>
	
<%	c.close();
	s.close();
%>

</table>
</form>
</body>
</html>