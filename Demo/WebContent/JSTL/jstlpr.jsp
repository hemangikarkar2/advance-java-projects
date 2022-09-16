<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSTL core tags-11/03/2020</title>
</head>
<body>
<c:out value="-----set and print-----"></c:out><br/>
<c:set  var="a" value="hemangi"></c:set>
<c:out value="${a}" ></c:out>
<br/>
<c:out value="-----for loop-----"></c:out><br/>
<c:forEach begin="1" end="3" var="a">${a}
<c:if test="${a eq 2}">
<c:out value="${a}"></c:out>
</c:if>
</c:forEach>
<br/>
<c:out value="-----while loop-----"></c:out><br/>
<c:forEach begin="1" end="4" var="a">
<c:choose>
	<c:when test="${a eq 1 }">
	<c:out value="${a}"></c:out>
	</c:when>
	
	<c:when test="${a eq 2}">
	<c:out value="${a}"></c:out>
	</c:when>
	
	<c:when test="${a eq 3 }">
	<c:out value="${a}"></c:out>
	</c:when>
	
	
	<c:otherwise>
	<c:out value="out of bound!!"></c:out>
	</c:otherwise>
</c:choose>
<br/>
</c:forEach>
<c:out value="-----fortokens-----"></c:out><br/>
<c:forTokens items="a,b,c,d,e" delims=","  var="i">
${i}<br/>
</c:forTokens>

<c:set var="a1" value="abc" scope="session"></c:set>

<c:redirect url="1.jsp"></c:redirect>
</body>
</html>