<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<link rel="stylesheet"
		href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
		<link rel="stylesheet"
		href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
		<title>Kickstarter project</title>
	</head>
	<body>
		<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>name</th>
			<th>description</th>
			<th>requiredAmount</th>
			<th>total</th>
			<th>days</th>
			<th>backers</th>
			<th>story</th>
			<th>link</th>
		</tr>
	</thead>
	<tbody>
			<tr>
				<td>
					<strong>
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
				<td>
					<c:out value="${project.backers}"/>
				</td>
				<td>
					<c:out value="${project.story}"/>
				</td>
				<td>
					<c:out value="${project.link}"/>
				</td>
			</tr>
	</tbody>
</table>
</html>