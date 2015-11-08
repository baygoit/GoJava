<%@ include file="../layout/taglib.jsp" %>

<script type="text/javascript" src="<c:url value="/resources/js/modal-remove.js" />"></script>

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
					<a href="<spring:url value="/users/remove/${user.id}.html" />" class="btn btn-danger triggerRemove">
						remove
					</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 align="center" class="modal-title" id="myModalLabel">Remove project</h4>
			</div>
			<div class="modal-body">
				Do you really want to remove the User?
				It'll also remove all user's projects!
			</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
			<a href="" class="btn btn-danger removeBtn">Remove</a>
		</div>
		</div>
	</div>
</div>