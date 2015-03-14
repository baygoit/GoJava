<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Kickstarter project</title>
</head>
	<body>

		<p>project name: <c:out value="${project.nameProject}"/></p>
		<p>short description: <c:out value="${project.shortDescriptionProject}"/></p>
		<p>full description: <c:out value="${project.fullDescriptionProject}"/></p>
		<p>foto: <c:out value="${project.fotoProject}"/></p>
		<p>link: <c:out value="${project.linkProject}"/></p>
		<p>how much needed = <c:out value="${project.howMuchNeededProject}"/></p>
		<p>how much collected = <c:out value="${project.howMuchCollectedProject}"/></p>
		<p>how much remaining = <c:out value="${project.howMuchRemainingProject}"/></p>
		<p>faq = <c:out value="${project.faqProject}"/></p>
		<p>days to go = <c:out value="${project.daysLeftProject}"/></p>

		<p>If you want return to <a href="projects?category=${project.idCategory}">projects</a></p>
		
		<p>If you want to <a href="donate">invest in the project</a></p>
		
		<p>Have a question? If the info above doesn't help, you can <a href="question">ask the project creator directly</a>
	
	</body>
</html>
