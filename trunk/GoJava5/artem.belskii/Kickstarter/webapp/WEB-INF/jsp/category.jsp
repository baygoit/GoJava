<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Projects from category</title>
</head>
<body>
<h1>Project list from <c:out value="${currentCategory}"/> category</h1>
<c:forEach var="project" items="${projectList}" varStatus="loop">
    <li>
    <a href="<c:out value="${currentCategoryId}"/>/project/<c:out value="${project.projectId}"/>">
    Project name: <c:out value="${project.name}"/>. Project details: <c:out value="${project.details}"/>
    </a></li>
</c:forEach>


<p><a href=/<c:out value="${serverRoot}" />/>Return to category list</a></p>



</body>
</html>