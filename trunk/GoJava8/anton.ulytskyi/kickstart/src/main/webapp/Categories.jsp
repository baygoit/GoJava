<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Kickstart</title>
</head>
<body>
 <center> <h1>Category</h1>
<h1>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</h1>
  
		<c:forEach items="${categories}" var="type">
<a href=/kickstart-0.0.1-SNAPSHOT/type?${type}>${type}</a>
                     <br>
		</c:forEach>
	
<h1>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`</h1>
<a href=/kickstart-0.0.1-SNAPSHOT/>previous</a> </center> 
</body>
</html>