<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="title" value="Kickstarter" />
<jsp:include page="components/Top.jsp"><jsp:param
		name="title" value="${title}" /></jsp:include>

<jsp:include page="components/Menu.jsp" />

<div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading">
		<b>Top donated projects</b>
	</div>
	<div class="panel-body">
		<table class="table">
			<thead>
				<tr>
					<th>id</th>
					<th>name</th>
					<th>author</th>
					<th>balance</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="project" items="${topProjects}">
					<tr>
						<td>${project.id}</td>
						<td>${project.name}</td>
						<td>${project.author}</td>
						<td>${project.balanceSum}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<jsp:include page="components/Bottom"></jsp:include>