<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kickstarter</title>
</head>
<body>
<h2>Projects by Category ${category.name}</h2>
<br>
<ol>
    <c:forEach var="project" items="${projects}">
        <li>
            <b><a href="project?projectId=${project.id}"><c:out value="${project.name}"/></a></b><br>
            <b>Description: </b><c:out value="${project.description}"/><br>
            <b>Cost: </b><c:out value="${project.cost}$"/><br>
            <b>Balance: </b><c:out value="${project.balance}$"/><br>
            <b>DeadLine: </b><c:out value="${project.deadLine}"/><br>
            <br>
        </li>
    </c:forEach>
</ol>
</body>
</html>
