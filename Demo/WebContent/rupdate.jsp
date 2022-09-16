<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update data</title>
</head>
<body>

	<%
			String uid = request.getParameter("uid");
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/demodb", "root", "root");
			Statement s = c.createStatement();
			String sql = "Select * from registration where id ='"+uid+"'";
			ResultSet resultset = null;
			resultset = s.executeQuery(sql);
			while (resultset.next()) {
	%>
	
<form action="updateprocess.jsp" align="center" >
	<br/><br/>
 	<input type="hidden" name="id" value="<%=resultset.getString("id") %>">
 	<input type="text" name="id" value="<%=resultset.getString("id") %>">
 
FirstName <input  type="text" name="firstname" value="<%=resultset.getString("firstname") %>"  /><br/><br/>
LastName  <input  type="text" name="lastname" value="<%=resultset.getString("lastname")%>"  /><br/><br/>

Address  <textarea  name="address"><%=resultset.getString("address")%></textarea><br/><br/>

Hobbies  <select name="hobbies"> 
		<option value="<%=resultset.getString("hobbies")%>">Dancing</option>
		<option value="<%=resultset.getString("hobbies")%>">Singing</option>
		<option value="<%=resultset.getString("hobbies")%>">Drawing</option>
		<option value="<%=resultset.getString("hobbies")%>">Reading</option>
		<option value="<%=resultset.getString("hobbies")%>">Badminton</option>
		  </select><br/><br/>
	
Gender  <input  type="radio" name="Gender" value="<%=resultset.getString("gender")%>" >Female&nbsp;&nbsp;
        <input  type="radio" name="Gender" value="<%=resultset.getString("gender")%>" >male
      <br/><br/>

Course  <input  type="checkbox" name="Course" value="<%=resultset.getString("course")%>" >Java&nbsp;&nbsp;
	    <input  type="checkbox" name="Course" value="<%=resultset.getString("course")%>" >Python&nbsp;&nbsp;
	    <input  type="checkbox" name="Course" value="<%=resultset.getString("course")%>" >C++&nbsp;&nbsp;
	    <input  type="checkbox" name="Course" value="<%=resultset.getString("course")%>" >.Net&nbsp;&nbsp;
	    <input  type="checkbox" name="Course" value="<%=resultset.getString("course")%>"/>Php&nbsp;&nbsp;
	  <br/><br/>

<input type="submit" name="UPDATE"/>
	</form>
	<%
			}
			c.close();
			s.close();
	%>
</body>
</html>