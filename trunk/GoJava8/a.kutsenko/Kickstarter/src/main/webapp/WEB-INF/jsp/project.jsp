<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>  
<c:set var="title" value="${project.name}" scope="request"/>
<jsp:include page="header.jsp"/>
	<hr/>
		
		<table>
			<tr>
				<td>Name Category</td>
				<td>${project.category.name}</td>
			</tr>
			<tr>
				<td>Project description</td>
				<td>${project.description}</td>
			</tr>
			<tr>
				<td>Required budget</td>
				<td>${project.requiredSum}</td>
			</tr>
			<tr>
				<td>Gathered budget</td>
				<td>${project.gatheredBudget}</td>
			</tr>
			<tr>
				<td>Days to go</td>
				<td>${project.remainingDays}</td>
			</tr>
		  	<tr>
				<td>project.history </td>
				<td>${project.history}</td>
			</tr>
			<tr>
				<td>project.video </td>
				<td><a href="${project.videoUrl}">${project.videoUrl}</a></td>
			</tr>
		</table>
		<br/>
		<a href="<c:url value="/investment/${project.id}" />">project investLink</a>
		<br/><br/>
		<hr/>
		<a href="/kickstarter/category/${project.category.id}">Back to category</a><br>
		<a href='/kickstarter'>Back to main page</a>
<jsp:include page="footer.jsp"/>