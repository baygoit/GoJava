<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SingleProject</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/WebKickstarter">Kickstarter</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/WebKickstarter">Home</a></li>
      <li><a href="logout">Logout</a></li>
      <li><a href="/WebKickstarter/project/list?categoryId=${project.getCategory().getId()}">ProjectSelection</a></li>
    </ul>
  </div>
</nav>


<div class="container">
		<div class="page-header">
			<h2> You are watching now: ${project.title}</h2>
		</div>
	</div>
	<div id="projects">
		<ul>
			<li><b>Project description:</b><br> </li>
			<li><c:out value="${project.getDiscription()}" /> </li>
			<li> Required Sum: <c:out value="${project.getRequiredSum()}" /></li> 
			<li>  Gained Sum: <c:out value="${project.getGainedSum()}" /> </li>
			<li>Days Left till end : <c:out value="${project.getDaysLeft()}" /> </li>
			<li> Link to Video : <c:out value="${project.getVideoLink()}" /></li> 
		   <li>  History of Project : <c:out value="${project.getProjectHistory()}" /></li>
		</ul>
	</div>

	
	<div id="questions">
	<b>Asked Questions</b>
		<ul>
			<c:forEach items="${questions}" var="question">
					<li><c:out value="${question.getQuestion()}" /></li>
				</c:forEach>
		</ul>
	</div>

	<b>You can add your question here :</b>
	<br>
	<form action="question"> <!-- Changed HERE! -->
		<input type="hidden" name="projectId" value="${project.getId()}" /> 
		<!--  <input name="question" /> -->
		<input id="subm" type="submit" class="btn btn-danger btn-lg" value="Ask question" />
	</form>
	<br>

	<form action="payment/provide">
		<input type="hidden" name="projectId" value="${project.getId()}" /> <input
			type="radio" value="1" name="paymentType" />Donate 50$ <input
			type="radio" value="2" name="paymentType" />Donate 100$ <input
			type="radio" value="3" name="paymentType" />Donate 150$ <input
			type="radio" value="4" name="paymentType" />Donate random amount $ <input
			id="subm" type="submit" class="btn btn-danger btn-lg" value="Pay" />
	</form>
</body>
</html>
