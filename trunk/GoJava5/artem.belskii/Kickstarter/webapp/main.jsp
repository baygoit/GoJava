<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kickstarter</title>
</head>
<body>
<h1><c:out value="${test}" /></h1>
<h1>Daily quote: <c:out value="${quote}" /></h1>

<c:forEach var="category" items="${categoryList}" varStatus="loop">
    <li>
    <a href="projects?categoryId=<c:out value="${loop.index + 1}"/>">
    <c:out value="${category}"/></a></li> 
</c:forEach>
<h1>test point: <c:out value="${hello}"/></h1>
</body>
</html>