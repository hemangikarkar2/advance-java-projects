<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="4.jsp">
	FirstName <input type ="text" name ="fn" /><br/>
	LastName<input type ="text" name="ln" /><br/>
	Address<textarea name="address" ></textarea>
	
	hobbies
	<select name="hobbies"><option>cricket</option>
	<option>hockey</option>
	<option>kho-kho</option></select>
	
	<br/>
	Gender<input type="radio" name="gender" value="male">male
	<input type="radio" name="gender" value="females">female<br/>
	course
	<input type="checkbox" name="course" value="java">java
	<input type="checkbox" name="course" value="python">python
	<input type="checkbox" name="course" value="c++">c++
	<input type="checkbox" name="course" value="os">os
	<br/>
	
	
	
	
	<input type="submit" name="submit"/>
	</form>
</body>
</html>