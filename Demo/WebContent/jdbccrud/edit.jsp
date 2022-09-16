<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit</title>
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
	
<form action="update.jsp" align="center" >
	<br/><br/>
 	<input type="hidden" name="id" value="<%=resultset.getString("id") %>">
 
FirstName <input  type="text" name="firstname" value="<%=resultset.getString("firstname") %>"  /><br/><br/>
LastName  <input  type="text" name="lastname" value="<%=resultset.getString("lastname")%>"  /><br/><br/>

Address  <textarea  name="address"><%=resultset.getString("address")%></textarea><br/><br/>

Hobbies  <select name="hobbies"> 
	
		<option <%if (resultset.getString("hobbies").contains("Dancing")) {
					out.print("selected=\"selected\"");
				}%> value="Dancing">Dancing</option>
				
				
		<option <%if (resultset.getString("hobbies").contains("Singing")) {
					out.print("selected=\"selected\"");
				}%> value="Singing">Singing</option>
				
		<option <%if (resultset.getString("hobbies").contains("Drawing")) {
					out.print("selected=\"selected\"");
				}%> value="Drawing">Drawing</option>
		
		<option <%if (resultset.getString("hobbies").contains("Reading")) {
					out.print("selected=\"selected\"");
				}%> value="Reading">Reading</option>
		
		
		<option <%if (resultset.getString("hobbies").contains("Badminton")) {
					out.print("selected=\"selected\"");
				}%> value="Badminton">Badminton</option>
		  </select><br/><br/> 
		  
	Gender <input type="radio" name="Gender" value="female"
			<%if (resultset.getString("gender").equalsIgnoreCase("female")) {
				out.print("checked");
				}%>
			>Female&nbsp;&nbsp;

		<input type="radio" name="Gender" value="male"
			<%if (resultset.getString("gender").equalsIgnoreCase("male")) {
				out.print("checked");
				}%>
			>male <br /> <br /> 
			
			
	Course <input type="checkbox" name="course" value="Java"
			<%if (resultset.getString("course").contains("Java")) {
					out.print("checked=\"checked\"");
				}%>>Java&nbsp;&nbsp;
		<input type="checkbox" name="course" value="Python"
			<%if (resultset.getString("course").contains("Python")) {
					out.print("checked=\"checked\"");

				}%>>Python&nbsp;&nbsp;
		<input type="checkbox" name="course" value="C++"
			<%if (resultset.getString("course").contains("C++")) {
					out.print("checked=\"checked\"");

				}%>>C++&nbsp;&nbsp;

		<input type="checkbox" name="course" value=".Net"
			<%if (resultset.getString("course").contains(".Net")) {
					out.print("checked=\"checked\"");

				}%>>.Net&nbsp;&nbsp;
		<input type="checkbox" name="course" value="Php"
			<%if (resultset.getString("course").contains("Php")) {
					out.print("checked=\"checked\"");

				}%>/>Php&nbsp;&nbsp;
		<br /> <br /> <input type="submit" value="update" >
	</form>
	<%
		}
		

		c.close();
		s.close();
	%>
</body>
</html>