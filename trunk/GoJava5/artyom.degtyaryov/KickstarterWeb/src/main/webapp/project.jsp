<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kickstarter</title>
</head>
<body>
<h2>Project ${project.name}</h2>
<br>
<b>Description: </b><c:out value="${project.description}"/><br>
<b>Cost: </b><c:out value="${project.cost}$"/><br>
<b>Balance: </b><c:out value="${project.balance}$"/><br>
<b>DeadLine: </b><c:out value="${project.deadLine}"/><br>
<b>Video: </b><a href="<c:out value="${project.videoLink}"/>"><c:out value="${project.videoLink}"/></a><br>
<b>History: </b><c:out value="${project.history}"/><br>
<b>FAQ: </b><c:out value="${project.questionsAndAnswers}"/><br>
<br>
<form action="payment" method="POST">
    Please enter your Name:  <input type="text" name="name" size="20px"> <br>
    Please enter your Card:  <input type="text" name="card" size="20px"> <br>
    Please enter Sum:        <input type="number" name="sum" size="20px"> <br><br>
    <input type="hidden" name="projectId" value="${project.id}" />
    <input type="submit" value="submit">
</form>
</body>
</html>
