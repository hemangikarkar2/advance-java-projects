<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form-13/03/2020</title>
</head>
<body>
<form action="form1.jsp" align="center">
Firstname<input type="text" name="fn" /><br /> Lastname<input
			type="text" name="ln" /><br /> 
address<textarea name="address"></textarea>
		<br />
gender<input type="radio" name="gender" value="male">Male
		<input type="radio" name="gender" value="female">Female<br />
		
Contry<select name="contry"><option>india</option>
			<option>usa</option>
			<option>uk</option>
			<option>canada</option></select><br />
			
 hobby<input type="checkbox"
			name="hobby" value="reading">reading <input type="checkbox"
			name="hobby" value="chess">chess <input type="checkbox"
			name="hobby" value="cricket">cricket <input type="checkbox"
			name="hobby" value="music">music <br /> <input type="submit"
			name="submit" />
	</form>
</body>
</html>