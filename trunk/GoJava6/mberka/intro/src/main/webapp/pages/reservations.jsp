<%@ page language="java" contentType="text/html; charset=US-ASCII"
pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Make Reservation</title>
    <link rel="stylesheet" href="mainstyle.css" type="text/css">
</head>
<body>
    Hello, <c:out value="${param.userName}"></c:out>
    <c:out value="${param.userSurname}"></c:out>!
    See available apartments to reserve:
         <form method="get" action="AvailableAptsController">
         <input type="Submit" value="See available apartments">
         </form>
                <c:forEach var="apartment" items="${allApts1}">
                <c:out value="${apartment}"></c:out><br>
                </c:forEach>
</body>
</html>