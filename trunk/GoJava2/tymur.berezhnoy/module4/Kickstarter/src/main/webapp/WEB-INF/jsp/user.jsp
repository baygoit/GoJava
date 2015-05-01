<%@ include file="../layout/taglib.jsp" %>
<strong>
	<p>
		The projects of user: <c:out value="${user.name}"></c:out>
	</p>
</strong>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Projects</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${user.projects}" var="userProject">
			<tr>	
				<td>
					<a href="<spring:url value="/project/${userProject.id}.html" />">
						${userProject.name}
					</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>