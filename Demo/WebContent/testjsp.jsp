<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="testjsp.*"  import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Testdemoclass </title>
</head>
<body>
<%
 testDemo1 td = new testDemo1();
td.sum(5,10);
out.println("Addition is : "+ td.sum(15,10));

%>
</body>
</html>