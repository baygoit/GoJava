<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<title>Kickstarter projects</title>
<style><%@include file='/defoult.css' %></style>
</head>
<body>
<div class="center" >
<div class="center2" >

	<h1>List of projects of category</h1>
	<h3><c:out value="${message}" /></h3>
	<div class="CSSTableGenerator" >
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
	</div>
		
	<p>If you want return to <a class="button" href="${ctx}/categories">categories</a></p>

</div>
</div>
</body>
</html>
