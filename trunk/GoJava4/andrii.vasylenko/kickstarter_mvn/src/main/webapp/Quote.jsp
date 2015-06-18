<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kickstarter: Quote</title>
</head>
<body>
	<h1>Quote</h1>
	<h2>
		<c:out value="${quote.quote}" />
	</h2>
	<a href="/kickstarter/categories"> GO TO KICKSTARTER -> </a>
</body>
</html>