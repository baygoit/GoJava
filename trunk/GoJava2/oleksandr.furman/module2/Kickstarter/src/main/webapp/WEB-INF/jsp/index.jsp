<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<h1>Select category:</h1>

<table class="table table-bordered table-hover table-striped">
	<tbody>
		<c:forEach items="${listCategories}" var="category">
			<tr>
				<td>
					<strong>
					<a href="<spring:url value="/projects/${category.id}.html" />">
						${category.name}
					</a>
					</strong>
					
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
	