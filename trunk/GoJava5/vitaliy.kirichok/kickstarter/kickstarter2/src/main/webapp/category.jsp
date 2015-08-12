<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<title>Kickstarter</title>

<body>
<h2><c:out value="${model.name}"/></h2>
<ol>
    <c:forEach items="${model.projects}" var="project">
        <li>
            <a href="project?id=${project.id}"><c:out value="${project.name}"/></a>
            <br>
            <c:out value="${project.shortDescription}"/>
            <br>
            Goal: <c:out value="${project.goal}"/>
            <br>
            Balance: <c:out value="${project.balance}"/>
            <br>
            Time left: <c:out value="${project.timeLeft}"/>
        </li>
    </c:forEach>
</ol>
</body>
</html>
