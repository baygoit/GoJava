<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Kickstarter projects</title>
</head>
	<body>

<h2>List of Projects of category # <c:out value="${category}"/></h2>	
	<table>
		<tr>
			<td>DELETE</td><td>SHOW PROJECT FULL</td>
		</tr>
		<c:forEach items="${projects}" var="project">
			<tr>
			<td><a href="<c:url value='/delete-${project.idProject}-project-${project.idCategory}' />">${project.name}</a></td>
			<td><a href="project?project=${project.idProject}"><c:out value="${project.name}"/></a></td>
			</tr>
		</c:forEach>
	</table>

	<p>If you want return to <a href="categories">categories</a></p>
	</body>
</html>
