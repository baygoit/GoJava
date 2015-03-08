<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Kickstarter</title>
    </head>
    <body>
        <c:forEach items="${projects}" var="project">
           <a href="/Kickstarter/project?id=${project.id}"><c:out value="${project.name}"></c:out></a><br>
           <c:out value="${project.description}"></c:out><br>
           <c:out value="${project.moneyNeed}"></c:out><br>
           <c:out value="${project.moneyHas}"></c:out><br>
           <c:out value="${project.daysLeft}"></c:out><br>
           <c:out value="----------------------------------------------"></c:out><br>
        </c:forEach>
        <br>
        <a href="/Kickstarter/categories">Return</a>
    </body>
</html>