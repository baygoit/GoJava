<%@ include file="../layout/taglib.jsp"%>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-validation-form.js" />"> </script>
<form:form commandName="user" cssClass="form-horizontal registrationForm">
	
	<c:if test="${param.success eq true}">
		<div class="alert alert-success">Registration successful!</div>
	</c:if>

	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">User name:</label>	
			<div class="col-sm-10">
      			<form:input path="name" cssClass="form-control" />
      			<form:errors path="name" />
    		</div>
	</div>
	<div class="form-group">
		<label for="email" class="col-sm-2 control-label">User email:</label>	
			<div class="col-sm-10">
      			<form:input path="email" cssClass="form-control" />
      			<form:errors path="email" />
    		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">User password:</label>	
			<div class="col-sm-10">
      			<form:password path="password" cssClass="form-control" />
      			<form:errors path="password" />
    		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">User password again:</label>	
			<div class="col-sm-10">
				<input type="password" name="password_again" id="password_again" class="form-control" />
    		</div>
	</div>
	<div class="form-group">	
		<div class="col-sm-10">
      		<input type="submit" value="Register" class="btn btn-lg btn-primary" />
    	</div>
	</div>
</form:form>