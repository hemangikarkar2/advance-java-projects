<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
</head>
<body>

<form action ="registrationjdbc1.jsp" align="center" >
<br/><br/>
FirstName <input  type="text" name="FirstN ame"  /><br/><br/>
LastName  <input  type="text" name="LastName"  /><br/><br/>

Address  <textarea  name="Address"  ></textarea><br/><br/>

Hobbies  <select name="Hobbies" > 
		<option>Dancing</option>
		<option>Singing</option>
		<option>Drawing</option>
		<option>Reading</option>
		<option>Badminton</option>
		  </select><br/><br/>
	
Gender  <input  type="radio" name="Gender" value="Female" >Female&nbsp;&nbsp;
        <input  type="radio" name="Gender" value="male" >male
      <br/><br/>

Course  <input  type="checkbox" name="Course" value="Java" >Java&nbsp;&nbsp;
	    <input  type="checkbox" name="Course" value="Python" >Python&nbsp;&nbsp;
	    <input  type="checkbox" name="Course" value="C++" >C++&nbsp;&nbsp;
	    <input  type="checkbox" name="Course" value=".Net" >.Net&nbsp;&nbsp;
	    <input  type="checkbox" name="Course" value="Php" >Php&nbsp;&nbsp;
	  <br/><br/>

<input type="submit" name="SUBMIT"/>

</form>
</body>
</html>