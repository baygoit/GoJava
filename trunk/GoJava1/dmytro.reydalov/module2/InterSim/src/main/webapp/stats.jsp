<%@page
	import="ua.com.goit.gojava.solo307.intersim.commons.StatisticsTraveler"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Statistics page</title>
</head>
<body bgcolor="Azure">
	<%
		StatisticsTraveler traveler = (StatisticsTraveler) request
				.getAttribute("traveler");
		List<String> stats = traveler.getPrintVersion();
		pageContext.setAttribute("stats", stats);
	%>

	<c:forEach items="${stats}" var="stat">
		<p>
			<c:out value="${stat}"></c:out>
		</p>
	</c:forEach>
	<a href="menu.html">Вернуться на главную</a>
	<br>
</body>
</html>

