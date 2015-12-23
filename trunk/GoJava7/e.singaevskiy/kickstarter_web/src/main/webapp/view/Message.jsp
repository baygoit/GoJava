<jsp:include page="components/Top.jsp"><jsp:param name="title"
		value="${project.name}" /></jsp:include>

<jsp:include page="components/Menu.jsp" />

<jsp:include page="components/Error.jsp" />

<form class="form-horizontal" method="post" action="project">
	<input type="hidden" name="projectId" value="${param.id}">
	<input type="hidden" name="operation" value="message">
	<div class="form-group">
		<label class="col-sm-3 control-label">Username</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" name="user"
				placeholder="Your name here">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label">Message</label>
		<div class="col-sm-6">
			<textarea class="form-control" rows="5"
				placeholder="Your question here" name="message"></textarea>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-3 col-sm-6">
			<button type="submit" class="btn btn-primary">Send</button>
		</div>
	</div>
</form>

<jsp:include page="components/Bottom" />