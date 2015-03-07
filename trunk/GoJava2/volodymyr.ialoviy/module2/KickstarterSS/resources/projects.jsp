<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Kickstarter projects</title>
</head>
	<body>

		<c:forEach items="${projects}" var="project">
		   <p><a href="/sample/project?project=${project.projectID}"><c:out value="${project.projectName}"/></a></p>
		</c:forEach>
		
		<p>If you want return to <a href="/sample/categories">categories</a></p>
	
	</body>
</html>
