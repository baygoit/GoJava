<%@ page import="ua.com.goit.gojava2.solo307.interview.InterviewSimulatorException"%>
<%@ page import="ua.com.goit.gojava2.solo307.interview.Interview"%>
<%@page import="ua.com.goit.gojava2.solo307.interview.Category"%>
<%@ page import="java.io.File"%>
<%@ page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Questions and correct Answers</title>
	</head>
	<body bgcolor="Azure">
		<% Interview interview = new Interview();
		File file = new File("Questions.xml");
		interview.createCategory(file);
		File file2 = new File("MeratechTest.xml");
		interview.createCategory(file2);
		Category composed = interview.getComposedCategory();
		List<String> myList = composed.getQuestionsAndCorrectAnswers();
		for(String string: myList){%>
			<p>	<%= string%>
		<%} %>
		<br><br>
		<a href="menu.jsp">Вернуться на главную</a> <br>
	</body>
</html>