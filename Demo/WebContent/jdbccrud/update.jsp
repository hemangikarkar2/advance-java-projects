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
		String Firstname = request.getParameter("firstname");
		String Lastname = request.getParameter("lastname");
		String ADdress = request.getParameter("address");
		String HObbies = request.getParameter("hobbies");
		String GEnder = request.getParameter("Gender");
		String course11 = "";
		String COurse[] = request.getParameterValues("course");
		for(int i=0;i<COurse.length;i++)
		{
			course11+=COurse[i]+" ";
		}
		if (Firstname != null && Lastname != null && ADdress != null && HObbies != null && GEnder != null
				&& course11 != null) {
			String sql1 = "Update registration set firstname=?,lastname=?,address=?,hobbies=?,gender=?,course=? where id='"
					+ uid + "'";
		    ps = c.prepareStatement(sql1);
			ps.setString(1, Firstname);
			ps.setString(2, Lastname);
			ps.setString(3, ADdress);
			ps.setString(4, HObbies);
			ps.setString(5, GEnder);
			ps.setString(6, course11);
			int i = ps.executeUpdate();
			if (i > 0) {
				out.println("record Updated Successfully");
				response.sendRedirect("search.jsp");
				
			} else {
				out.println("there is a problem in updating record");

			}
		}
		
	
		
		//response.sendRedirect("search.jsp");
		c.close();
		s.close();
	%>
</body>
</html>