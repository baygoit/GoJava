
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form"%>

<springform:form class="form-horizontal" method="post" action="submitmessage/${param.id}" commandName="question">
	<input type="hidden" name="projectId" value="${param.id}"/>
	<input type="hidden" name="operation" value="message"/>
	<div class="form-group">
		<label class="col-sm-3 control-label">Username</label>
		<div class="col-sm-6">
			<springform:input path="user" type="text" class="form-control" name="user"
				placeholder="Your name here"/>
			<springform:errors path="user"/>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label">Message</label>
		<div class="col-sm-6">
			<springform:textarea path="question" class="form-control" rows="5"
				placeholder="Your question here" name="message"></springform:textarea>
			<springform:errors path="question"/>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-3 col-sm-6">
			<button type="submit" class="btn btn-primary">Send</button>
		</div>
	</div>
</springform:form>
