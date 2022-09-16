<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change password</title>
</head>
<body>


	<%
	String id1 =request.getParameter("id");
	String newpassword = request.getParameter("newpassword");
	String confirmpassword = request.getParameter("confirmpassword");
	String currentPassword = request.getParameter("oldpassword");
	
	System.out.println("id:::"+id1);
	String password="";
	//System.out.println("new Password:::"+newpassword);
	//System.out.print("curretnt password :::::"+currentPassword);
	Class.forName("com.mysql.jdbc.Driver");
	Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/demodb","root","root");
	Statement s = c.createStatement();
	ResultSet resultset = s.executeQuery("select * from emp_reg where id='"+id1+"'");
	while(resultset.next())
	{
		password = resultset.getString("password");	
	}
	
//	System.out.print("password :::::"+password);
	
		//String oldpassword = resultset.getString(password);
		if((newpassword.equals(confirmpassword)) && (currentPassword.equals(password))) 
				{
		
			Statement st1=c.createStatement();
			int i = st1.executeUpdate("Update emp_reg  set password ='" + confirmpassword + "' where id='" + id1 + "'");
			out.println("Password changed successfully");
			response.sendRedirect("login.jsp");
			c.close();
			st1.close();		
		}
		else {
		out.println("Invalid Current Password");
		
				}

	c.close();
	s.close();
%>
</body>
</html>