<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



	<table border="1px solid black">
		<tr>
			
			
			<th>Id</th>
			<th>CountryName</th>
			<th>StateName</th>
			<th>Action</th>
			

		</tr>
		
		<c:forEach items="${stateList}" var="i" varStatus="j">
		<tr>
		
			<td>${j.count}</td>
			<td>${i.countryVO.countryName}</td>
			<td>${i.stateName}</td>		
			
			<td colspan="2">
				
				<a href="deleteState.html?sid=${i.stateId}">Delete</a>
				<a href="editState.html?sid=${i.stateId}">Edit</a>
				
			</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>
