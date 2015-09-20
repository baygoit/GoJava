<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Categories menu</title>
</head>
<body bgcolor=white>
	<c:forEach items="${categories}" var="category">
		<h2>
			<a href="/kicksartermaven/projects?category=${category.id}"> 
				<c:out value="${category.name}" />
			</a>
			
		</h2>
	
	</c:forEach>


</body>
</html>