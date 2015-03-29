<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kickstarter</title>

<style>
tr:first-child {
	font-weight: bold;
	background-color: #C6C9C4;
}
</style>

</head>


<body>
	<h2>List of Categories</h2>
	<table>
		<tr>
			<td>DELETE</td>
			<td>SHOW PROJECTS IN CATEGORY</td>
			<td>ADD NEW PROJECT</td>
		</tr>
		<c:forEach items="${categories}" var="category">
			<tr>
				<td><a href="${ctx}/categories/${category.idCategory}?delete">${category.name}(x)</a></td>
				<td><a href="${ctx}/categories/${category.idCategory}">${category.name}</a></td>
				<td><a href="${ctx}/projects?add">add new project</a></td>
			</tr>
		</c:forEach>
	</table>

	<br />
	<a href="<c:url value='/newcategory' />">add new category</a>
	<br />
	<br />

	<table>
		<tr>
			<td>DELETE</td>
			<td>SHOW PROJECT</td>
		</tr>
		<c:forEach items="${categories}" var="category">
			<c:forEach items="${category.projects}" var="project">
				<tr>

					<td><a href="${ctx}/projects/${project.idProject}?delete">${project.name}(x)</a>
					</td>
					<td><a href="${ctx}/projects/${project.idProject}">${project.name}</a>
					</td>


				</tr>
			</c:forEach>
		</c:forEach>
	</table>






</body>
</html>