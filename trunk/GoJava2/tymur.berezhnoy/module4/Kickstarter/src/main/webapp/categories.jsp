<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<link rel="stylesheet"
		href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
		<link rel="stylesheet"
		href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
		<title>Kickstarter categories</title>
	</head>
	<body>
		<table class="table table-bordered table-hover table-striped">
			<tbody>
				<h4><c:out value="\"${quote.content}\"${quote.copyrightSymbol}${quote.author}"/></h4><p>
				<h1>Select category:</h1>
					<c:forEach items="${categories}" var="category">
					<tr>
					<td>
					<strong>
					<a href="/Kickstarter/projects?categoryId=${category.id}&categoryName=${category.name}">
					<c:out value="${category.name}"/></a>
					</strong>		
					</td>
					</tr>
					</c:forEach>
			</tbody>
		</table>
	</body>
</html>