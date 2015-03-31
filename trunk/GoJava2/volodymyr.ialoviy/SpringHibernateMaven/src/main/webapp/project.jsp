<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<title>Kickstarter project</title>
</head>
	<body>
	<h1>Project from ${project.category.name}</h1>
	<table border="2" bordercolor="black" cellpadding="2">
		<tr>
			<td>NAME</td>
			<td>VALUE</td>
		</tr>
		<tr>
			<td>project name:</td>
			<td>${project.name}</td>
		</tr>
		<tr>
			<td>short description:</td>
			<td>${project.shortDescription}</td>
		</tr>
		<tr>
			<td>full description:</td>
			<td>${project.fullDescription}</td>
		</tr>
		<tr>
			<td>foto:</td>
			<td>${project.foto}</td>
		</tr>
		<tr>
			<td>link:</td>
			<td>${project.link}</td>
		</tr>
		<tr>
			<td>how much needed:</td>
			<td>${project.howMuchNeeded}</td>
		</tr>
		<tr>
			<td>how much collected:</td>
			<td>${project.howMuchCollected}</td>
		</tr>
		<tr>
			<td>how much remaining;</td>
			<td>${project.howMuchRemaining}</td>
		</tr>
		<tr>
			<td>days to go:</td>
			<td>${project.dateClose}</td>
		</tr>
	</table>
	<p>If you want return to <a href="${ctx}/projects/${project.idCategory}">projects</a></p>
	<p>If you want to <a href="${ctx}/donate/${project.id}">invest in the project</a></p>
	<p>Have a question? If the info above doesn't help, you can <a href="${ctx}/question/${project.id}">ask the project creator directly</a>
	</body>
</html>
