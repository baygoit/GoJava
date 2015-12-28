<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="title" value="Kickstarter" />
<jsp:include page="components/Top.jsp"><jsp:param
		name="title" value="${title}" /></jsp:include>

<jsp:include page="components/Menu.jsp" />

<div class="col-sm-4">
<div class="panel panel-default ">
	<!-- Default panel contents -->
	<div class="panel-heading">
		<b>Top donated categories</b>
	</div>
	<div class="panel-body">
		<table class="table">
			<thead>
				<tr>
					<th class="col-sm-1">id</th>
					<th>name</th>
					<th class="col-sm-2">donated</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="map" items="${topCategories}">
					<tr>
						<td>${map['id']}</td>
						<td>${map['name']}</td>
						<td>$${map['sum']}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
</div>
<jsp:include page="components/Bottom"></jsp:include>