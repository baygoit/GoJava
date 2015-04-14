<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<!-- Button trigger modal -->
<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
  New project
</button>


<form:form modelAttribute="project" cssClass="form-horizontal projectForm">
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">New project</h4>
      </div>
      <div class="modal-body">


		
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Name:</label>
			<div class="col-sm-10">
				<form:input path="name" cssClass="form-control" />
				<form:errors path="name" />
			</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Description:</label>
			<div class="col-sm-10">
				<form:input path="description" cssClass="form-control" />
				<form:errors path="description" />
			</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Goal:</label>
			<div class="col-sm-10">
				<form:input path="goal" cssClass="form-control" />
				<form:errors path="goal" />
			</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Days to start:</label>
			<div class="col-sm-10">
				<form:input path="daysLeft" cssClass="form-control" />
				<form:errors path="daysLeft" />
			</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Project history:</label>
			<div class="col-sm-10">
				<form:input path="history" cssClass="form-control" />
				<form:errors path="history" />
			</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Links to video about project:</label>
			<div class="col-sm-10">
				<form:input path="linksToVideo" cssClass="form-control" />
				<form:errors path="linksToVideo" />
			</div>
		</div>
		
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Category:</label>
			<div class="col-sm-10">
			<form:select path="category.id">  
			<form:option value="" label="--Please Select"/>                             
            <form:options items="${categories}" itemValue="id" itemLabel="name" />
            </form:select>
			</div>
		</div>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <input type="submit" class="btn btn-primary" value="Save" />
      </div>
    </div>
  </div>
</div>
</form:form>

<br /><br />

<script type="text/javascript">
$(document).ready(function() {
	$('.nav-tabs a:first').tab('show'); // Select first tab
	$(".triggerRemove").click(function(e) {
		e.preventDefault();
		$("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
		$("#modalRemove").modal();
	});
	$(".projectForm").validate(
			{
				rules: {
					name: {
						required : true,
						minlength : 1
					},
					description: {
						required : true,
						minlength : 1
					},
					goal: {
						required : true,
						minlength : 1
					},
					daysLeft: {
						required : true,
						minlength : 1
					},
					history: {
						required : true,
						minlength : 1
					},
					linksToVideo: {
						required : true,
						url: true
					}					
				},
				highlight: function(element) {
					$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
				},
				unhighlight: function(element) {
					$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
				}
			}
		);
});
</script>




<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Remove project</h4>
      </div>
      <div class="modal-body">
        Really remove?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <a href="" class="btn btn-danger removeBtn">Remove</a>
      </div>
    </div>
  </div>
</div>


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
				
				<td>
					
			<a href="<spring:url value="/project/remove/${project.id}.html" />" class="btn btn-danger triggerRemove">remove project</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
