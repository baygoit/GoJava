<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Kickstarter project</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/includes/header.jsp" />

	<table align="center" border="2">
		<tr>
			<td>Name</td>
			<td><c:out value="${project.name}" /></td>
		</tr>
		<tr>
			<td>Description</td>
			<td><c:out value="${project.description}" /></td>
		</tr>
		<tr>
			<td>Goal</td>
			<td><c:out value="${project.goal}" /></td>
		</tr>
		<tr>
			<td>Pledged</td>
			<td><c:out value="${project.pledged}" /></td>
		</tr>
		<tr>
			<td>Days left</td>
			<td><c:out value="${project.daysLeft}" /></td>
		</tr>
		<tr>
			<td>Project history</td>
			<td><c:out value="${project.history}" /></td>
		</tr>
		<tr>
			<td>Links to video</td>
			<td><a href="${project.linksToVideo}"><c:out value="${project.linksToVideo}"/></a></td>
		</tr>
		<tr>
			<td>Question and answers</td>
			<td><c:out value="${project.questionAnswers}" /></td>
		</tr>
	</table>
	
	<div id="dialog" title="Invest in this project">
		<form action="payment">
			<h2 class="form">Please, fill in your data</h2>
			<input type="hidden" value="${project.id}" name="id"> <input
				type="text" class="form-control" placeholder="Name" required>
			<input type="text" class="form-control" placeholder="Card Number"
				required> <input type="number" name="inputAmount"
				class="form-control" placeholder="Amount" required>
			<div class="checkbox"></div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">OK</button>
		</form>
	</div>
<div align="center" class="buttons">
	<button class="btn btn-lg btn-success" id="opener">Invest in
		this project</button>
</div>

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
