<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>


<table class="table table-bordered table-hover table-striped">

	<tbody>
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
			<td><a href="${project.linksToVideo}"><c:out
						value="${project.linksToVideo}" /></a></td>
		</tr>
		<tr>
			<td>Question and answers</td>
			<td><c:out value="${project.questionAnswers}" /></td>
		</tr>

	</tbody>
</table>

<div align="center" class="buttons">
	<button type="button" class="btn btn-primary btn-lg"
		data-toggle="modal" data-target="#myModal">Invest in this
		project</button>
	<button type="button" class="btn btn-lg btn-info" VALUE="Back"
		onClick="history.go(-1);return true;">Back</button>
</div>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Modal title</h4>
			</div>
			<div class="modal-body">
				<form action="payment.html">
					<h2 class="form">Please, fill in your data</h2>
					<input type="hidden" value="${project.id}" name="id"> <input
						type="text" class="form-control" placeholder="Name" required>
					<input type="text" class="form-control" placeholder="Card Number"
						required> <input type="text" class="form-control"
						placeholder="cvv2 code" required><input type="number"
						name="inputAmount" class="form-control" placeholder="Amount"
						required>
					<div class="checkbox"></div>
					<button class="btn btn-lg btn-primary btn-block" type="submit">OK</button>
				</form>
			</div>

		</div>
	</div>
</div>
