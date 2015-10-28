<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>KickstarterX/oneProject</title>
</head>
<body>

<h1>Project full description:</h1>
		<h2>
				<c:out value="${oneProject}" />
				<c:out value="${oneProject.history}" />
				<c:out value="${oneProject.videoLink}" />
				<c:out value="${oneProject.questions}" />
		</h2>
</body>
</html>