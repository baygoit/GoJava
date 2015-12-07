<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="WEB-INF/jspf/header.jspf" %>
<section id="category">
    <h1>Category ${requestScope.category.name}</h1>
    <c:forEach var="project" items="${requestScope.projects}">
        <h2> <a href="project?id=${project.id}"> ${project.title}</a></h2>
        Description: ${project.description}<br>
        Total ${project.total}$<br>
        Collected amount ${project.collectedAmount}$<br>
        Number of days to end ${project.getNumberOfDaysToEnd()}<br>
    </c:forEach>
</section>
<%@include file="WEB-INF/jspf/footer.jspf" %>
