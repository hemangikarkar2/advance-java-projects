<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="regcon" method="post">
<input type="hidden" name="flag" value="insert"/>

Firstname<input type="text" name="fn"/><br/>
lastname<input type="text" name="ln"/><br/>

<input type="submit" value="submit"/>
</form>
<a href="regcon?flag=search">search</a>
</body>
</html>