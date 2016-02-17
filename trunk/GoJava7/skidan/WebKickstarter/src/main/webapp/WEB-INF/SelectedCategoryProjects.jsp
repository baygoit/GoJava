<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>SelectedCategoryProjects.jsp</title>
</head>
<body id="b">
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/WebKickstarter">Kickstarter</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/WebKickstarter">Home</a></li>
      <li><a href="logout">Logout</a></li>
    </ul>
  </div>
</nav>


 <div class="container">
   <c:forEach items="${projectList}" var="project">
		<div class="page-header">
			<h3><a href=/WebKickstarter/project?projectId=${project.getId()}><c:out
                value="${project.getTitle()}"/></a></h3>
		</div>
		<ul>
	  <li>Project description:<c:out value="${project.getDiscription()}"/></li>
      <li>Required Sum:<c:out value="${project.getRequiredSum()}"/></li>
      <li>Gained Sum:<c:out value="${project.getGainedSum()}"/></li>
      <li>Days Left till end :<c:out value="${project.getDaysLeft()}"/></li>
		</ul>
	 </c:forEach>
</div>

</body>
</html>