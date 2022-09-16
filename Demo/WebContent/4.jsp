<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String s1 = request.getParameter("fn");
out.println("First Name  :- "+s1 +"</br>"); 
String s2= request.getParameter("ln");
out.println("Last Name   :- "+s2+"</br>");
String s3=request.getParameter("address");
out.println("Address     :- "+s3+"</br>");
String s4=request.getParameter("hobbies");
out.println("Hobbies     :- "+s4+"</br>");
String s5=request.getParameter("gender");
out.println("Gender      :- "+s5+"</br>");
out.println("Courses      :- ");
String course[]=request.getParameterValues("course");
if(course!=null){
	for(int i=0; i<course.length; i++){
		out.println(course[i]);
	
	}
	
}
else{
	out.println("No values Selected");
}

//response.sendRedirect("welcome.jsp");
response.sendRedirect(".jsp");
%>
</body>
</html>