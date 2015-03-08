<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>



<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Categories</title>

</head>
<body>
	<jsp:include page="/WEB-INF/views/includes/header.jsp" />
	projectId
<c:out value="${projectId}" />


	<div id="dialog" title="Invest in this project">
		<form action="payment">
			<h2 class="form">Please do it</h2>

			<input type="text" id="inputName" class="form-control"
				placeholder="Name" required> <input type="text"
				id="inputCardNumber" class="form-control" placeholder="Card Number"
				required> <input type="number" id="inputAmount"
				class="form-control" placeholder="Amount" required>
			<div class="checkbox"></div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">OK</button>
		</form>
	</div>

	<button class="btn btn-lg btn-success" id="opener">Invest in
		this project</button>
		
	<form action="payment">
	
		<input name="username" /> 
		<input name="userid" />
		<button class="btn btn-lg btn-primary btn-block" type="submit">OK</button>
		
	</form>

</body>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
	$(function() {
		$("#dialog").dialog({
			autoOpen : false,
			show : {
				effect : "blind",
				duration : 1000
			},
			hide : {
				effect : "explode",
				duration : 1000
			}
		});

		$("#opener").click(function() {
			$("#dialog").dialog("open");
		});
	});
</script>
</html>