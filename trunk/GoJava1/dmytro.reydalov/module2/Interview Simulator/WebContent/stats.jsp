<%@page import="ua.com.goit.gojava2.solo307.interview.StatisticsDTO"%>
<%@page import="java.util.List"%>
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
		StatisticsDTO dto = (StatisticsDTO) request.getAttribute("dto");
		List<String> stats = dto.getPrintVersion();
		for (String stat : stats) {
	%>
	<p>
		<%=stat%>
	</p>
	<%
		}
	%>
	<a href="menu.jsp">Вернуться на главную</a>
	<br>
</body>
</html>