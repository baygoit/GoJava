<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<title>Search page</title>
</head>
 <body>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table width="100%" border="1">
        <caption><h1>List cities<h1></caption>
        <tr>
        <c:forEach var="name" items="${city}">
            <th class="headtab1">
            <a href="/search?cityid=${name.getId()}">${name.getName()}</a>
            </th>
        </c:forEach>
        </tr>


</table>
<br>

<table width="100%" border="0">
        <caption><h1>List apartment<h1></caption>
        <tr>
        <c:forEach var="name" items="${apartment}">
            <th class="headtab2">
            <a href="/search?cityid=${name.getId()}">${name.getName()}</a>
            </th>
        </c:forEach>
        </tr>


</table>
<br>

</body>
</html>