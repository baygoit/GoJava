<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-sm-12">
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