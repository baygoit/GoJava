<%@ include file="../layout/taglib.jsp" %>
<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Required amount</th>
			<th>Total</th>
			<th>Days left</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${projects}" var="project">
			<tr>
				<td>
					<strong> 
						<a href="<spring:url value="/project/${project.id}.html" />">
							${project.name}
						</a>
					</strong>
				</td>
				<td><c:out value="${project.description}" /></td>
				<td><c:out value="${project.status.requiredAmount}" /></td>
				<td><c:out value="${project.status.total}" /></td>
				<td><c:out value="${project.status.daysLeft}" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>