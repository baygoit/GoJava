<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<link rel="stylesheet"
		href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
		<link rel="stylesheet"
		href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
		<title>Kickstarter projects</title>
	</head>
	<body>
		<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>name</th>
			<th>description</th>
			<th>required amount</th>
			<th>total</th>
			<th>days left</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${projects}" var="project">
			<tr>
				<td>
					<strong>
					<a href="project?id=${project.id}">
					<c:out value="${project.name}"/></a>
					</strong>
				</td>
				<td>
					<c:out value="${project.description}"/>
				</td>
				<td>
					<c:out value="${project.requiredAmount}"/>
				</td>
				<td>
					<c:out value="${project.total}"/>
				</td>
				<td>
					<c:out value="${project.days}"/>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</html>