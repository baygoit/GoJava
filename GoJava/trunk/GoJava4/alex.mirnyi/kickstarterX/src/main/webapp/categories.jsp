<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>KickstarterX</title>
</head>
<body>
<h1><c:out value="${quote}" /></h1>
<h1>Please choose category:</h1>
	<c:forEach var="category" items="${categories}">
		<h2>
			<a href="/kickstarterX/projects/?category=${category.id}">
				<c:out value="${category}" />
			</a>
		</h2>
	</c:forEach>

</body>
</html>