<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>SingleProject</title>
    <style>
        #b {
            background-image: url("http://oboi.tululu.org/o/30/76866/prew.jpg");
        }
    </style>
</head>
<body id="b">

<h1 id="h1" align="center">Full Project Information</h1>

<h3>You are watching now: <c:out value="${project.getTitle()}"/><br></h3><br>
<div id="projects">
    <b>Project description:</b><br>
    <c:out value="${project.getDiscription()}"/> // FIXME
    <br> Required Sum:
    <c:out value="${project.getRequiredSum()}"/>
    <br> Gained Sum:
    <c:out value="${project.getGainedSum()}"/>
    <br> Days Left till end :
    <c:out value="${project.getDaysLeft()}"/>
    <br> Link to Video :
    <c:out value="${project.getVideoLink()}"/>
    <br> History of Project :
    <c:out value="${project.getProjectHistory()}"/>
    <br><br>
</div>
<b>Asked Questions</b>
<div id="questions">
    <c:forEach items="${questions}" var="question">
        <c:out value="${question.getQuestion()}"/><br>

    </c:forEach>
</div>

<br>
<b>You can add your question here :</b>
<br>
<form method="post" action="questions">
    <input type="hidden" name="projectId" value="${project.getId()}"/>
    <input name="question"/><input id="subm" type="submit" value="add question"/></form>
<br>

<form action="payment/providePaymentType">
    <input type="hidden" name="projectId" value="${project.getId()}"/>
    <input type="radio" value="1" name="paymentType"/>Donate 50$
    <input type="radio" value="2" name="paymentType"/>Donate 100$
    <input type="radio" value="3" name="paymentType"/>Donate 150$
    <input type="radio" value="4" name="paymentType"/>Donate random amount $
    <input id="subm" type="submit" value="payment type"/></form>
<br>


<a href=projectsOfCategory?categoryId=${project.getCategory().getId()}>
    <input type="button" value="Return to Project Selection"/>
</a>


</body>
</html>


<!-- <link rel="stylesheet" type="text/css" href="NewFile.css">
-->