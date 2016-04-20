<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<title>Projects</title>
</head>
<body>
	<p>
		<a href="categoryServlet"> Back </a>
	</p>

	<sql:setDataSource var="snapshot" driver="org.postgresql.Driver"
		url="jdbc:postgresql://ec2-54-83-3-38.compute-1.amazonaws.com:5432/dc7jic6f3ikj0a?user=sfdnpqghfnwasj&password=3ePn6uUN5bWh2r0J0p_0UMObWy&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory"
		user="sfdnpqghfnwasj" password="3ePn6uUN5bWh2r0J0p_0UMObWy" />



	<h4>Choose one of the items bellow</h4>
	<c:forEach var="project" items="${projects}">

		<p>
			<a
				href="projectServlet?categoryId=${categoryId}&projectId=${project.id}">${project.name}</a>
		</p>
		<p>
			<b>Project name:</b> ${project.name}
		</p>
		<p>
			<b>Description:</b> ${project.description}
		</p>
		<p>
			<b>Needed amount:</b> ${project.neededAmount}
		</p>
		<p>

			<sql:query dataSource="${snapshot}" var="result">
        SELECT SUM(amount) AS sum FROM payments GROUP BY project_id HAVING project_id = ${project.id};
        </sql:query>

			<b>Available amount:</b>
			<c:forEach var="row" items="${result.rows}">
				<c:out value="${row.sum}" />
			</c:forEach>

		</p>
		<p>
			<b>Remaining days:</b> ${project.daysRemain}
		</p>
	</c:forEach>

</body>
</html>