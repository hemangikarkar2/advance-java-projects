<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit</title>
</head>
<body>
	<%!static String course;%>
	<%
		String uid = request.getParameter("uid");
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/demodb", "root", "root");
		Statement s = c.createStatement();
		String sql = "Select * from registration where id ='" + uid + "'";
		ResultSet resultset = null;
		resultset = s.executeQuery(sql);

		int id;
		String firstname, lastname, address, hobbies, gender;

		while (resultset.next()) {
			id = resultset.getInt("id");
			firstname = resultset.getString("firstname");
			lastname = resultset.getString("lastname");
			address = resultset.getString("address");
			hobbies = resultset.getString("hobbies");
			gender = resultset.getString("gender");
			course = resultset.getString("course");
	%>

	<form action="update.jsp" align="center" method="post">
		<br /> <br /> <input type="hidden" name="id"
			value="<%=resultset.getString("id")%>"> FirstName <input
			type="text" name="firstname" value="<%=firstname%>" /><br /> <br />
		LastName <input type="text" name="lastname" value="<%=lastname%>" /><br />
		<br /> Address
		<textarea name="address"><%=resultset.getString("address")%></textarea>
		<br /> <br /> Hobbies <select id="hobbies" name="hobbies">

			<option value="<%=hobbies%>"><%=hobbies%></option>
			<option value="0">--Please Select--</option>

			<option value="Dancing">Dancing</option>
			<option value="Singing">Singing</option>
			<option value="Drawing">Drawing</option>
			<option value="Reading">Reading</option>
			<option value="Badminton">Badminton</option>
		</select><br /> <br /> Gender
		<%
			if (gender.equalsIgnoreCase("female")) {
		%>
		<input type="radio" name="gender" value="female" checked="checked">Female
		&nbsp;&nbsp; <input type="radio" name="gender" value="male">Male
		<%
 	} else {
 %>
		<input type="radio" name="gender" value="female">Female <input
			type="radio" name="gender" value="male" checked="checked">Male
		&nbsp;&nbsp;

		<%
			}
		%>

		<br /> <br /> Course
		<%
		
	
		%>
		<input type="checkbox" name="course" value="java"
			<%if (isContain("java")) {
					out.print("checked=\"checked\"");
				}%>>Java&nbsp;&nbsp;
		<input type="checkbox" name="course" value="python"
			<%if (isContain("python")) {
					out.print("checked=\"checked\"");
				}%>>Python
		&nbsp;&nbsp; <input type="checkbox" name="course" value="c++"
			<%if (isContain("c++")) {
					out.print("checked=\"checked\"");
				}%>>C++
		&nbsp;&nbsp; <input type="checkbox" name="course" value=".net"
			<%if (isContain(".net")) {
					out.print("checked=\"checked\"");
				}%>>.Net
		&nbsp;&nbsp; <input type="checkbox" name="course" value="php"
			<%if (isContain("php")) {
					out.print("checked=\"checked\"");
				}%> />Php
		&nbsp;&nbsp; <br /> <br /> <input type="submit" value="update">
	</form>
	<%
		}

		c.close();
		s.close();
	%>

	<%!public boolean isContain(String courseT) {
		String[] course1 = course.split(" ");

		for (int i = 0; i < course1.length; i++) {
			if (course1[i].equalsIgnoreCase(courseT)) {
				return true;

			}

		}
		return false;
	}%>


</body>
</html>