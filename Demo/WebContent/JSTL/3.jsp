<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    <%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>jstl-16/03/2020</title>
</head>
<body>
<c:set var="str" value="hemangi"></c:set>

<c:out value="-----Length of String-----"></c:out><br/>
<c:set  var="i" value="${f:length(str)}" ></c:set>
<c:out value="${i }"></c:out>
<br/>
<br/>
<c:out value="-----String in uppercase-----"></c:out><br/>
<c:set var="i3" value="${f:toUpperCase(str)}"></c:set>
<c:out value="${i3 }"></c:out>
<br/>
<br/>
<c:out value="-----String  trim-----"></c:out><br/>
<c:set var="i41" value="Natvarbhai karkar"></c:set>
<c:set var="i4" value="${f:trim(i41) }"></c:set>
<c:set var="i51" value="${f:length(i4) }"></c:set>
<c:out value="${i51}"></c:out>
<br/>
<br/>
<c:out value="-----String split-----"></c:out><br/>
<c:set var="i2" value="${f:split(i41,' ')}"></c:set>
<c:set var="i21" value="${f:join(i2,'-')}"></c:set>
<c:out value="${i21}"></c:out>
<br/>
<br/>
<c:out value="-----String contains-----"></c:out><br/>
<c:set var="i5" value="welcome hemangi"></c:set>
<c:if test="${f:contains(i5,'welcome') }" var="i7">${i5}
<c:out value="${i7 }"></c:out>
</c:if>
<br/>
<br/>
<c:if test="${f:contains(i5,'Natvarbhai') }" var="i6"></c:if>
<c:out value="${i6 }"></c:out>
<br/>
<br/>
<c:out value="-----String replace -----"></c:out><br/>
<c:set var="i7" value="${f:replace(i5,'hemangi','karkar')}"></c:set>
<c:out value="${i7}"></c:out>
<br/><br/>
<c:out value="-----String substring  -----"></c:out><br/>
<c:set var="i8" value="${f:substring(i41,0,10) }"></c:set>
<c:out value="${i8 }"></c:out>
<br/>
<br/>
<c:out value="-----String in uppercase-----"></c:out><br/>
<c:set var="i3" value="${f:toLowerCase(str) }"></c:set>
<c:out value="${i3 }"></c:out>
<br/>
<br/>


</body>
</html>