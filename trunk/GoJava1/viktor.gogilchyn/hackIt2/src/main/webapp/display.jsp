<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<title>Actor list</title>
</head>
<body>
<form name = "deleteform" action="actors" method="post">
    <ul class = "gamers_list">
    <c:forEach items="${requestScope.gamers}" var="gamerItem">
        <li class = "gamers_list_names_list">
            <input name="${gamerItem.getName()}" type="checkbox" unchecked>
            <c:out value="${gamerItem.getName()}"/>
        </li>
        <c:forEach items="${gamerItem.getSkills()}" var="skillItem">
            <li class = gamers_list_skill_list><c:out value="${skillItem.key}"/></li>
        </c:forEach>
    </c:forEach>
    </ul>
    <input type="hidden" name = "delete" value="yes">
    <input type="submit" value="Delete selected">
</form>    
</body>
</html>