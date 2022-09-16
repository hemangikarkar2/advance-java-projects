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
			int id;
			String firstname,lastname,address,hobbies,gender,course;
			while (resultset.next()) {
		%>

		<tr>
			<% 
			id=resultset.getInt("id");
			firstname=resultset.getString("firstname");
			lastname=resultset.getString("lastname");
			address=resultset.getString("address");
			hobbies=resultset.getString("hobbies");
			gender=resultset.getString("gender");
			course=resultset.getString("course");%>
			
			<td><%=firstname%></td>
			<td><%=lastname%></td>
			<td><%=address%></td>
			<td><%=hobbies%></td>
			<td><%=gender%></td>
			<td><%=course%></td>
			<td align="center" ><a href="delete.jsp?did=<%=id%>"> <button type="button" >Delete</button></a>&nbsp;&nbsp;&nbsp;
								<a href="edit.jsp?uid=<%=id%>"> <button type="button">Edit   </button></a>
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