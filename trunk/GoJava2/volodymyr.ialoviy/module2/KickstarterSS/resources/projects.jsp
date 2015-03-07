<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Kickstarter</title>
</head>
	<body>

		<c:forEach items="${projects}" var="project">
		   <a href="/sample/project?project${project.projectID}"><c:out value="${project.projectName}"/></a><p>
		</c:forEach>
	
	</body>
</html>
