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
String Firstname = request.getParameter("firstname");
String Lastname  = request.getParameter("lastname");
String ADdress  = request.getParameter("address");
String HObbies  = request.getParameter("hobbies");
String GEnder = request.getParameter("gender");
String course11 ="";
String COurse[]  = request.getParameterValues("course");

Class.forName("com.mysql.jdbc.Driver");
Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/demodb","root","root");
Statement s= c.createStatement();
String sql = "Update  registration set id=?,firstname=?,lastname=?,address=?,hobbies=?,gender=?,course=? where id='"+uid+"'";
PreparedStatement ps = null;
//ps.setString(1, uid);
ps.setString(2,Firstname );
ps.setString(3,Lastname );
ps.setString(4, ADdress);
ps.setString(5, HObbies);
ps.setString(6, GEnder);
ps.setString(7, course11);
//ps.setString(5, HObbies);
int i = ps.executeUpdate();
if(i>0)
{
	out.println("record Updated Successfully");
}
else
{
	out.println("there is a problem in updating record");

}

c.close();
s.close();

%>
</body>
</html>