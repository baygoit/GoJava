<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>KickstarterX/projects</title>
</head>
<body>

<h1>Select project:</h1>
<c:forEach var="project" items="${projects}">
		<h2>
			<a href="/kickstarterX/oneProject/?project=${project.projectId}">
				<c:out value="${project}" />
			</a>
		</h2>
	</c:forEach>
</body>
</html>