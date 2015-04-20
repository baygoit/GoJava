<%@ include file="../layout/taglib.jsp"%>
<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Required amount</th>
			<th>Total</th>
			<th>Days left</th>
			<th>Backers</th>
			<th>Story</th>
			<th>Link</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>
				<strong>
					<c:out value="${project.name}" />
				</strong>
			</td>
			<td><c:out value="${project.description}" /></td>
			<td><c:out value="${project.requiredAmount}" /></td>
			<td><c:out value="${project.total}" /></td>
			<td><c:out value="${project.daysLeft}" /></td>
			<td><c:out value="${project.backers}" /></td>
			<td><c:out value="${project.story}" /></td>
			<td><c:out value="${project.link}" /></td>
		</tr>
	</tbody>
</table>