<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<table class="table table-bordered table-striped table-hover">
	<thead>
		<tr>
			<th>Categories</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${categories}" var="category">
			<tr>
				<td><a
					href="<spring:url value="/categories/${category.id}.html"/>">
						${category.name} </a>
                </td>

			</tr>
		</c:forEach>
	</tbody>
</table>