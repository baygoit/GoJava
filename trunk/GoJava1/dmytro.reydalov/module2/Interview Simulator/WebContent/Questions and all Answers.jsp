<%@page import="ua.com.goit.gojava2.solo307.interview.InterviewSimulatorException"%>
<%@page import="ua.com.goit.gojava2.solo307.interview.Interview"%>
<%@page import="java.io.File"%>
<%@page import="java.util.List"%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of Questions and all answers</title>
</head>
<body>
<%
Interview interview = new Interview();
File file = new File("Questions.xml.");
interview.addCategory("Questions", file.getAbsolutePath());
File file2 = new File("MeratechTest.xml.");
interview.addCategory("Questions1", file2.getAbsolutePath());
interview.composeCategory(interview.getCategories());
List<String> myList = interview.getCurrentCategory().getQuestionsAndAllAnswers();
for(String string: myList){
	out.println(string);
%><br>
<%} %>
<br><br>
<a href="index.jsp">Вернуться на главную</a> <br>
</body>
</html>