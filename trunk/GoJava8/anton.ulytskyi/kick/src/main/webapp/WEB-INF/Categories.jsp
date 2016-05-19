<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Kickstarter</title>
</head>
<body>
 <center> <h1>Category</h1>
<h1>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</h1>
  
		<c:forEach items="${categories}" var="type">
<a href="type/${type}">${type}</a>
                     <br>
		</c:forEach>
	
<h1>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</h1>
<a href="/">previous</a> </center> 
</body>
</html>