<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>


<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>title</th>
			<th>description</th>
			<th>goal</th>
			<th>pledged</th>
			<th>days left</th>
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
				<td>
					<c:out value="${project.description}" />
			
				</td>
				<td>
					<c:out value="${project.goal}" />
			
				</td>
				<td>
					<c:out value="${project.pledged}" />
			
				</td>
				<td>
					<c:out value="${project.daysLeft}" />
			
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<div align="center" class="buttons">
<button type="button" class="btn btn-lg btn-info" VALUE="Back" onClick="history.go(-1);return true;">Back</button>
</div>