<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<title>Kickstarter project</title>
</head>
	<body>
		<p>project name: ${project.name}</p>
		<p>short description: ${project.shortDescription}</p>
		<p>full description: ${project.fullDescription}</p>
		<p>foto: ${project.foto}</p>
		<p>link: ${project.link}</p>
		<p>how much needed = ${project.howMuchNeeded}</p>
		<p>how much collected = ${project.howMuchCollected}</p>
		<p>how much remaining = ${project.howMuchRemaining}</p>
		<p>days to go = ${project.dateClose}</p>

		<p>If you want return to <a href="${ctx}/projects/${project.idCategory}">projects</a></p>
		<p>If you want to <a href="${ctx}/donate/${project.id}">invest in the project</a></p>
		<p>Have a question? If the info above doesn't help, you can <a href="${ctx}/question/${project.id}">ask the project creator directly</a>
	
	</body>
</html>
