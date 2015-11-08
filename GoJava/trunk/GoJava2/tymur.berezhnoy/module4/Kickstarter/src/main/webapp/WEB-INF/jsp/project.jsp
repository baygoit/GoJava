<%@ include file="../layout/taglib.jsp"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<script type="text/javascript">
$(document).ready(function() {
	$('.nav-tabs a:first').tab('show');
	$(".triggerRemove").click(function(e) {
		e.preventDefault();
		$("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
		$("#modalRemove").modal();
	});
	$(".projectForm").validate({
		rules: {
			question: {
				required : true,
					minlength : 1
			}			
		},
		highlight: function(element) {
			$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
		},
		unhighlight: function(element) {
			$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
		}
	});
});
</script>
<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Required amount</th>
			<th>Total</th>
			<th>Days left</th>
			<th>Backers</th>
			<th>Story</th>
			<th>Link</th>
			<th>User/Team</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>
				<strong>
					<c:out value="${project.name}" />
				</strong>
			</td>
			<td><c:out value="${project.description}" /></td>
			<td><c:out value="${project.status.requiredAmount}" /></td>
			<td><c:out value="${project.status.total}" /></td>
			<td><c:out value="${project.status.daysLeft}" /></td>
			<td><c:out value="${project.status.backers}" /></td>
			<td><c:out value="${project.story}" /></td>
			<td><c:out value="${project.link}" /></td>
			<td>
				<a href="<spring:url value="/user/${project.user.name}.html" />">
					${project.user.name}
				</a>
			</td>
		</tr>
	</tbody>
</table>
<div align="center" class="buttons">
	<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">Invest</button>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 align="center" class="modal-title" id="myModalLabel">Invest to the project</h4>
      </div>
	<div class="modal-body">
		<form action='<spring:url value="/project/payment.html " />' method="POST">
			<input type="hidden" value="${project.status.id}" name="id">
			<input type="text" class="form-control" placeholder="Name" required /><br>
			<input type="number" min="1" max="${project.status.requiredAmount-project.status.total}" name="amount" class="form-control" placeholder="Amount" required>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<input type="submit" class="btn btn-primary" value="Save" />
			</div>
		</form>
	</div>
    </div>
  </div>
</div>