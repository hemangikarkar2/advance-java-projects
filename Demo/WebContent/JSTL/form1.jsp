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
<c:set var="fn1" value="${param.fn}"></c:set>
<c:out value="${fn1 }"></c:out>
<br/>
<c:set var="ln1" value="${param.ln} "></c:set>
<c:out value="${ln1 }"></c:out>
<br/>
<c:set var="add1" value="${param.address} "></c:set>
<c:out value="${add1 }"></c:out>
<br/>
<c:set var="gen1" value="${param.gender} "></c:set>
<c:out value="${gen1 }"></c:out>
<br/>
<c:set var="con1" value="${param.contry} "></c:set>
<c:out value="${con1 }"></c:out>
<br/>

<c:set var="hob1" value="${paramValues.hobby}"></c:set>
<c:forEach  items="${hob1}" var="a">
<c:out value="${a}"></c:out>
</c:forEach>

</body>
</html>