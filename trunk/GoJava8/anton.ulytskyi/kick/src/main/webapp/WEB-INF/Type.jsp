<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Kickstarter</title>
</head>
<body>
<center>
<h1>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</h1>
<h1>${type}</h1>
<h1>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</h1>
  
		<c:forEach items="${projects}" var="project">
<a href="selected/${project.getKey()}">${project.getValue()}</a>
                     <br>
		</c:forEach>
	
<h1>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`</h1>
<a href="/kickstarterWEB/categories">previous</a>
</center>
</body>
</html>