<%@ include file="../layout/taglib.jsp" %>
<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>User name</th>
			<th>Operation</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${users}" var="user">
			<tr>	
				<td>
					<a href="<spring:url value="/user/${user.name}.html" />">
						${user.name}
					</a>
				</td>
				<td>
					<a href="<spring:url value="/users/remove/${user.id}.html" />" class="btn btn-danger">
						remove
					</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>