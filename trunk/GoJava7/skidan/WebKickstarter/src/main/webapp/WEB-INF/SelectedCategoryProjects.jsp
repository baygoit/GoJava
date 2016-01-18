<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="<c:url value="/resources/css/new.css" />" />

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>SelectedCategoryProjects.jsp</title>
   <style>
        #b {
            background-image: url("http://oboi.tululu.org/o/30/76866/prew.jpg");
        }
    </style>
</head>
<body id="b">

<h1 id="header">Projects Available in this Category </h1>

<div id=3>

<ul>
    <c:forEach items="${projectList}" var="project">
      <li> <a href=/WebKickstarter/project?projectId=${project.getId()}><c:out
                value="${project.getTitle()}"/></a></li>
      <li>Project description:<c:out value="${project.getDiscription()}"/></li>
      <li>Required Sum:<c:out value="${project.getRequiredSum()}"/></li>
      <li>Gained Sum:<c:out value="${project.getGainedSum()}"/></li>
      <li>Days Left till end :<c:out value="${project.getDaysLeft()}"/></li>
    </c:forEach>
	</ul>	

</div>
<br><br>
<a id="subm" href=/WebKickstarter>
    <input type="button" value="Return to Category Selection"/>
</a>
</body>
</html>