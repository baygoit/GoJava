<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Kickstarter project</title>
</head>
	<body>

		<p>project name: <c:out value="${project.projectName}"/></p>
		<p>short description: <c:out value="${project.shortDescription}"/></p>
		<p>full description: <c:out value="${project.fullDescription}"/></p>
		<p>foto: <c:out value="${project.foto}"/></p>
		<p>link: <c:out value="${project.link}"/></p>
		<p>how much needed = <c:out value="${project.howMuchNeeded}"/></p>
		<p>how much collected = <c:out value="${project.howMuchCollected}"/></p>
		<p>how much remaining = <c:out value="${project.howMuchRemaining}"/></p>
		<p>faq = <c:out value="${project.faq}"/></p>
		<p>days to go = <c:out value="${project.daysLeft}"/></p>

		<p>If you want return to <a href="/kickstarter/projects?category=${project.categoryID}">projects</a></p>
		
		<p>If you want to <a href="/kickstarter/donate">invest in the project</a></p>
		
		<p>Have a question? If the info above doesn't help, you can <a href="/kickstarter/question">ask the project creator directly</a>
	
	</body>
</html>
