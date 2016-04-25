<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Kickstart</title>
</head>
<body>
<center>
<h1>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</h1>
<h1>${type}</h1>
<h1>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</h1>
  
		<c:forEach items="${projects}" var="project">
<a href="selected?${project.getId()}">${project.showShortInformation()}</a>
                     <br>
		</c:forEach>
	
<h1>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`</h1>
<a href="categories">previous</a>
</center>
</body>
</html>