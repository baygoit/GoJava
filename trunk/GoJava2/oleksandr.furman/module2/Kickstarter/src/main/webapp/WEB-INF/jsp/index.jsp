<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<table class="table table-bordered table-hover table-striped">
	<tbody>
		<c:forEach items="${categories}" var="category">
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