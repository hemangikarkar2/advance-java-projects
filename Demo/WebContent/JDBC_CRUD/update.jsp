<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update</title>
</head>
<body>

	<%
		String uid = request.getParameter("id");
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/demodb", "root", "root");
		Statement s = c.createStatement();
		String sql = "Select * from registration where id ='" + uid + "'";
		ResultSet resultset = null;
		resultset = s.executeQuery(sql);

		PreparedStatement ps = null;
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String address = request.getParameter("address");
		String hobbies = request.getParameter("hobbies");
		String gender = request.getParameter("gender");
		String course11 = "";
		String course[] = request.getParameterValues("course");
		for (int i = 0; i < course.length; i++) {
			course11 += course[i] + " ";
		}

		System.out.println(firstname);
		System.out.println(lastname);
		System.out.println(address);
		System.out.println(hobbies);
		System.out.println(gender);
		System.out.println(course11);

		if (firstname != null && lastname != null && address != null && hobbies != null && gender != null
				&& course11 != null) {

			System.out.println("in if");

			String sql1 = "Update registration set firstname=?,lastname=?,address=?,hobbies=?,gender=?,course=? where id='"
					+ uid + "'";
			ps = c.prepareStatement(sql1);
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, address);
			ps.setString(4, hobbies);
			ps.setString(5, gender);
			ps.setString(6, course11);
			int i = ps.executeUpdate();
			if (i > 0) {
				out.println("record Updated Successfully");
				response.sendRedirect("search.jsp");

			} else {
				out.println("there is a problem in updating record");

			}
		} else {
			System.out.println("in else");
		}

		//response.sendRedirect("search.jsp");
		c.close();
		s.close();
	%>
</body>
</html>