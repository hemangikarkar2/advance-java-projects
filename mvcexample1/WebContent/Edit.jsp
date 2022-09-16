<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="regcon" method="post">
<c:forEach var="i" items="${sessionScope.ls}">
<table>
<tr><input type="hidden" name="id" value="${i.id}"/>
<td><input type="text" name="fn" value="${i.fn}"/></td>
<td><input type="text" name="ln" value="${i.ln}	"/></td>

</tr>

</table>
</c:forEach>

<input type="submit" name="flag" value="update" >
</form>
</body>
</html>