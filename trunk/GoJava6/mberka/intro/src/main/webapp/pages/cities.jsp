<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Available Cities</title>
    <link rel="stylesheet" href="mainstyle.css" type="text/css">
</head>

<body>
     <form method="get" action="CitiesController">
     <input type="Submit" value="Get Available Cities">
     </form>
            <c:forEach var="city" items="${allCities}">
            <c:out value="${city}"></c:out><br>
            </c:forEach>
</body>
</html>