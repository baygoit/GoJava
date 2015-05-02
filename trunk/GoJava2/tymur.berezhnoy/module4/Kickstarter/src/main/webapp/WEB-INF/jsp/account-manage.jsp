<%@ include file="../layout/taglib.jsp" %>

<script src="<c:url value="/resources/js/modal-remove.js" />"></script>

<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
  New project
</button>

<form:form commandName="project" cssClass="form-horizontal">
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 align="center" class="modal-title" id="myModalLabel">Creating new project</h4>
      </div>
	<div class="modal-body">
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Project name: </label>	
				<div class="col-sm-10">
					<form:input path="name" cssClass="form-control" />
				</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Description: </label>	
				<div class="col-sm-10">
					<form:input path="description" cssClass="form-control" />
				</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Story: </label>	
				<div class="col-sm-10">
					<form:input path="story" cssClass="form-control" />
				</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Link: </label>	
				<div class="col-sm-10">
					<form:input path="link" cssClass="form-control" />
				</div>
		</div>
		<form:form commandName="projectStatus">
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">Required amount: </label>	
					<div class="col-sm-10">
						<form:input path="requiredAmount" cssClass="form-control" />
					</div>
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">Days left: </label>	
					<div class="col-sm-10">
						<form:input path="daysLeft" cssClass="form-control" />
					</div>
			</div>
		</form:form>
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Category:</label>
				<div class="col-sm-10">
					<form:select path="category.id">  
					<form:option value="" label="Select category"/>                             
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

<strong>My projects:</strong>
<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Name</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${user.projects}" var="project">
			<tr>
				<td>
					<strong> 
						<a href="<spring:url value="/project/${project.id}.html" />">
							${project.name}
						</a>
					</strong>
				</td>
				<td>
					<a href='<spring:url value="/project/remove/${project.id}.html" />' class="btn btn-danger triggerRemove"> Remove project</a>
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
				Do you really want to remove the project?
			</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
			<a href="" class="btn btn-danger removeBtn">Remove</a>
		</div>
		</div>
	</div>
</div>