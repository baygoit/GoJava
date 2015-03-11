<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Kickstarter questions</title>
</head>
<body>
	<c:forEach items="${faq}" var="qa"> 
            Q: <c:out value="${qa.question}" />
		</br>
            A: <c:out value="${qa.answer}" />
		</br>

	</c:forEach>
	<p>
	<form action="faq" method="post">
		<input type="text" name="question"> 
		<input type="hidden" name="projectId" value="${projectId}">
        <input type="hidden" name="categoryId" value="${categoryId}">
		<input type="submit" value="Ask Question">
		<span class="error">${error}</span>
	</form>
	<a href="project?project=${projectId}&category=${categoryId}">Go back</a></br>
</body>
</html>
