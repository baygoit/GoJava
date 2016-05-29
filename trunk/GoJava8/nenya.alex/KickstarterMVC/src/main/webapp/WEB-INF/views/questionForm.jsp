<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<title>Question</title>
</head>
<body>
    <p>
        <a href="<c:url value="/project/${project.id}"/>" > <spring:message code="category.back" /> </a>
    </p>
    
    <p><b><spring:message code="question.ask" /> "${project.name}"</b></p>
    <form:form action="add" method="post" modelAttribute="questionBind">
    
        <form:input type="text" path="name" placeholder="Enter your question"/>
        <form:errors path="name"/>
         
        <form:input type="hidden" path="project.id" value="${project.id}" />
         
        <input type="submit" value="Submit" />
    </form:form>
   
</body>
</html>