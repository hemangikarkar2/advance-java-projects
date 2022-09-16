<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
</head>
<body>
<table border="2" align="center" height="70px" width="1000px" >
		<tr align="center" height="50px"  bgcolor="yellow">
			
			<td>FirstName</td>
			<td>LastName</td>
			<td>Address</td>
			<td>Hobbies</td>
			<td>Gender</td>
			<td>Course</td>
			<td>Action</td>
		</tr>


		<%
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/demodb", "root", "root");
			Statement s = c.createStatement();
			String sql = "Select * from registration";
			ResultSet resultset = null;
			resultset = s.executeQuery(sql);
			while (resultset.next()) {
		%>

		<tr>
			<!-- <td><%=resultset.getString("id")%></td> -->
			<td><%=resultset.getString("firstname")%></td>
			<td><%=resultset.getString("lastname")%></td>
			<td><%=resultset.getString("address")%></td>
			<td><%=resultset.getString("hobbies")%></td>
			<td><%=resultset.getString("gender")%></td>
			<td><%=resultset.getString("course")%></td>
			<td align="center" ><a href="delete.jsp?did=<%=resultset.getString("id")%>"> <button type="button" >Delete</button></a>&nbsp;&nbsp;&nbsp;
								<a href="edit.jsp?uid=<%=resultset.getString("id")%>"> <button type="button">Edit   </button></a>
			</td> 
		</tr>
		<%
		
			}
			s.close();
			c.close();
		%>
	</table>
</body>
</html>