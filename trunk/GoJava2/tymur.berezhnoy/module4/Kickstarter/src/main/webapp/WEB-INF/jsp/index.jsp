<%@ include file="../layout/taglib.jsp" %>
<h4>
	<c:out value='\"${quote.content}\" ${quote.copyrightSymbol}${quote.author}' />
</h4>
<table class="table table-bordered table-hover table-striped">
	<tbody>
		<h1>Select category:</h1>
		<c:forEach items="${categories}" var="category">
			<tr>
				<td>
				<strong>
					<a href="<spring:url value="/projects/${category.id}.html" />">
						<c:out value="${category.name}" />
					</a>
				</strong></td>
			</tr>
		</c:forEach>
	</tbody>
</table>