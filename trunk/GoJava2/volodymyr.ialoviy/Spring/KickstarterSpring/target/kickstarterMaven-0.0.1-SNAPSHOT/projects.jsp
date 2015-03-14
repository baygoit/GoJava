<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Kickstarter projects</title>
</head>
	<body>

		<c:forEach items="${projects}" var="project">
		   <p><a href="project?project=${project.idProject}"><c:out value="${project.nameProject}"/></a></p>
		</c:forEach>
		
		<p>If you want return to <a href="categories">categories</a></p>
	
	</body>
</html>
