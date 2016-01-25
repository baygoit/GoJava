
<%@ taglib prefix="springform"
	uri="http://www.springframework.org/tags/form"%>

<springform:form class="form-horizontal" method="post"
	modelAttribute="user">

	<div class="form-group">
		<label class="col-sm-3 control-label">Email</label>
		<div class="col-sm-6">
			<springform:input path="email" type="email" class="form-control"
				name="email" placeholder="inbox@gmail.com" />
			<springform:errors path="email" />
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label">Password</label>
		<div class="col-sm-6">
			<springform:input path="password" type="password" class="form-control"
				name="password" placeholder="123456" />
			<springform:errors path="password" />
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-3 col-sm-6">
			<button type="submit" class="btn btn-primary">Login</button>
		</div>
	</div>
</springform:form>
