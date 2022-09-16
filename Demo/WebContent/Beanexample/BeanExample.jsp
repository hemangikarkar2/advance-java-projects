<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="testjsp.*" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>beanexample 1 :(17/02/2020)</title>
</head>
<body>


 <jsp:useBean class="testjsp.BeanExample" id="b1" ></jsp:useBean>

 <jsp:setProperty property="fn" name="b1" value="hemangi" ></jsp:setProperty>
 
<jsp:getProperty property="fn" name="b1"/>
 
 <jsp:setProperty property="ln" name="b1" value="karkar"/>
<jsp:getProperty property="ln" name="b1"></jsp:getProperty>
</body>
</html>