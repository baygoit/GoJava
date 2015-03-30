<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<title>Kickstarter projects</title>
</head>
	<body>
		<h2>List of projects of category</h2>	
		<table>
			<tr>
				<td>DELETE</td>
				<td>SHOW PROJECT FULL</td>
			</tr>
			<c:forEach items="${projects}" var="project">
				<tr>
				<td><a href="${ctx}/projects/${project.id}/${project.idCategory}?delete">${project.name}</a></td>
				<td><a href="${ctx}/projects/${project.id}?show">${project.name}</a></td>
				</tr>
			</c:forEach>
		</table>
		<p>If you want return to <a href="${ctx}/categories">categories</a></p>
	</body>
</html>
