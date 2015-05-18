<%@ include file="../layout/taglib.jsp"%>

<link href="<c:url value="/resources/css/signUp-logIn.css" />" rel="stylesheet">

<div class="container">
	<div id="loginbox" style="margin-top: 50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Log In</div>
			</div>
			<div style="padding-top: 30px" class="panel-body">
				<div style="display: none" id="login-alert" class="alert alert-danger col-sm-12"></div>
				<form id="loginform" class="form-horizontal" role="form" action='<spring:url value="/j_spring_security_check" />' method="POST" >
					<div style="margin-bottom: 25px" class="input-group">
						<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
							<input type="text" class="form-control" name="j_username" placeholder="User name" required autofocus>
					</div>
					<div style="margin-bottom: 25px" class="input-group">
						<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
							<input type="password" class="form-control" name="j_password" placeholder="Password" required>
					</div>
					<div style="margin-top: 10px" class="form-group">
						<div class="col-sm-12 controls">
							<button class="btn btn-info" type="submit">Login</button>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-12 control">
							<div style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">Don't have an account!
								<a href='<spring:url value="/register.html" />'>Sign Up Here</a>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>