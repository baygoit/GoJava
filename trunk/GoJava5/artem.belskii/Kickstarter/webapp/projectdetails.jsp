<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details for project</title>
</head>
<body>
    <li>Project name: <c:out value="${project.name}"/></li>
    <li>Project details: <c:out value="${project.details}"/></li>
    <li>Project goal: <c:out value="${project.goal}"/></li>
    <li>Project balance: <c:out value="${project.balance}"/></li>
    <li>Project startDate: <c:out value="${project.startDate}"/></li>
    <li>Project endDate: <c:out value="${project.endDate}"/></li>
    <li>Project videoUrl: <c:out value="${project.videoUrl}"/></li> 
    <li>Project details: <c:out value="${project.details}"/></li>
    <li>Project name: <c:out value="${project.name}"/></li>
    <li>Project details: <c:out value="${project.details}"/></li>
    <li></li>
    <li>FAQ for project:</li>

    
</body>
</html>