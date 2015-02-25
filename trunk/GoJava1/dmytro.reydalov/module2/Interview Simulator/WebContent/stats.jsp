<%@page import="java.util.List"%>
<%@page import="ua.com.goit.gojava2.solo307.interview.Mark"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Statistics page</title>
	</head>
	<body>
	<%List<Mark> marks = (List<Mark>)request.getAttribute("stat");
	int correct = 0;
	int halfCorrect = 0;
	int incorrect = 0;
	for(Mark mark: marks){
		if(mark.isCorrect())correct++;
		else if(mark.isHalfcorrect())halfCorrect++;
		else if(mark.isIncorrect())incorrect++;
	}%>
	<p> Правильных ответов: <%= correct %></p>
	<p> Частично правильных ответов: <%= halfCorrect %></p>
	<p> Неправильных ответов: <%= incorrect %></p>
	<p> Неправильно отвечено </p>
		<%
			for(Mark mark: marks){
			for(String stat: mark.getIncorrectAnswers()){
		%>
	  		<p><%= stat%> </p>
	  		<%} %>
	  	<%} %>
		<a href="index.jsp">Вернуться на главную</a> <br>
	</body>
</html>