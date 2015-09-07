<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details for project</title>
</head>
<body>
    <li>Project name: <c:out value="${project.name}"/></li>
    <li>Project details: <c:out value="${project.details}"/></li>
    <li>Project goal: <c:out value="${project.goal}"/></li>
    <li>Project balance: <c:out value="${project.balance}"/></li>
    <li>Project startDate: <c:out value="${project.startDate}"/></li>
    <li>Project endDate: <c:out value="${project.endDate}"/></li>
    <li>Project videoUrl: <c:out value="${project.videoUrl}"/></li> 
    <li>Project details: <c:out value="${project.details}"/></li>
    <li>Project name: <c:out value="${project.name}"/></li>
    <li>Project details: <c:out value="${project.details}"/></li>
    <li></li>
    <li>FAQ for project:</li>
    <li>Project faq:</li>
    <c:if test="${fn:length(project.faq) eq 0}">
   		<p>You can ask first question:</p>
   		<form action="" method="POST">
	        Please enter your question:  <input type="text" name="question" size="20px"> <br>
        <input type="submit" value="submit">
    </form>
	</c:if>
	<c:if test="${fn:length(project.faq) gt 0}">
		<c:forEach var="question" items="${project.faq}" varStatus="loop">
				<p>Q: <c:out value="${question['value']['0']}"/></p>
				<p>A: <c:out value="${question['value']['1']}"/></p>
		</c:forEach>
   		<form action="" method="POST">
	        You can ask new question:  <input type="text" name="question" size="20px"> <br>
        <input type="submit" value="submit">
		
	</c:if>
	
	<li>Donate</li>
	<c:if test="${fn:length(paymetVariants) gt 0}">
	<form action="" method="POST">
		<c:forEach var="variant" items="${paymetVariants}" varStatus="loop">
					<c:forEach var="variant" items="${variant['value']}" varStatus="loop">
						<br>Pay "${variant['key']}" and get "${variant['value']}" <input type="radio" name="donate" value="${variant['key']}"> <br>
					</c:forEach>
		</c:forEach>
		<p>Or put custom payment amount <input type="text" name="customDonate" size="20px"> </p>
		<input type="submit" value="submit">
	</form>
		
	</c:if>
	
</body>
</html>