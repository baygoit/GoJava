<%@ include file="../layout/taglib.jsp"%>
<link href="<c:url value="/resources/css/signUp-logIn.css" />" rel="stylesheet">
<script type="text/javascript">
$(document).ready(function() {
	$(".registrationForm").validate(
		{
			rules: {
				name: {
					required : true,
					minlength : 3,
					maxlength : 25,
					remote : {
						url: "<spring:url value='/register/available.html' />",
						type: "get",
						data: {
							userName: function() {
								return $("#name").val();
							}	
						}
					}
				},
				email: {
					required : true,
					email : true
				},
				password: {
					required : true,
					minlength : 5,
					maxlength : 30
				},
				password_again: {
					required : true,
					minlength : 5,
					maxlength : 30,
					equalTo: "#password"
				}
			},
			highlight: function(element) {
				$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
			},
			unhighlight: function(element) {
				$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
			},
			messages: {
				name: {
					remote: "Such username already exists!"
				}
			}
		}
	);
});
</script>
<div class="container">
	<div id="signupbox" style="margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Sign Up</div>
			</div>
			<div class="panel-body" >	
				<form:form commandName="user" cssClass="form-horizontal registrationForm" role="form">
					<c:if test="${success eq true}">
						<div class="alert alert-success">Registration successful! You'll be redirect to the home page in 3 seconds.</div>
						<meta http-equiv="refresh" content="3;http://kick-s.herokuapp.com/" />
					</c:if>

					<div class="form-group">
						<label for="name" class="col-md-3 control-label">User name:</label>	
							<div class="col-md-9">
	      						<form:input path="name" cssClass="form-control"  placeholder="Choose a name" />
	      						<form:errors path="name" />
	    					</div>
					</div>
					<div class="form-group">
						<label for="email" class="col-md-3 control-label">Email:</label>	
							<div class="col-md-9">
				      			<form:input path="email" cssClass="form-control" placeholder="Choose an email" />
				      			<form:errors path="email" />
				    		</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-md-3 control-label">Password:</label>	
							<div class="col-md-9">
				      			<form:password path="password" cssClass="form-control" placeholder="Choose a password" />
				      			<form:errors path="password" />
				    		</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-md-3 control-label">Password again:</label>	
							<div class="col-md-9">
								<input type="password" name="password_again" id="password_again" class="form-control" placeholder="Confirm the password" />
				    		</div>
					</div>
					<div class="form-group">	
						<div class="col-md-offset-3 col-md-9">
				      		<button id="btn-signup" type="submit" class="btn btn-info"><i class="icon-hand-right"></i>Sign Up</button>
							<span style="margin-left:8px;"></span>  
				    	</div>
					</div>
				</form:form>
		</div>
		</div>
	</div>
</div>