<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

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
		
	</tbody>
</table>

<div align="center" class="buttons">
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
		Invest in this project</button>
<button class="btn btn-success btn-lg" data-toggle="modal" data-target="#myModal1">
  Ask a question 
</button>
<button type="button" class="btn btn-lg btn-info" VALUE="Back" onClick="history.go(-1);return true;">Back</button>
</div>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Invest in project</h4>
      </div>
      <div class="modal-body">
        <form action="payment.html">
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
      
    </div>
  </div>
</div>

<br/>

<form:form modelAttribute="questionandanswers" cssClass="form-horizontal projectForm">

<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Ask a question to the author of the project.</h4>
      </div>
      <div class="modal-body">
		
		<div class="form-group">		
			<div class="col-sm-10">
				<form:textarea path="question" rows="5" cols="70" cssClass="form-control" />
				<form:errors path="question" />
				<form:hidden path="project.id" value="${project.id}"/>
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

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Questions</th>
			<th>Authors of a questions</th>
			<th>Answers</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${project.questionAndAnswers}" var="qa">
			<tr>
				<td>
					
					<c:out value="${qa.question}" />
					
				</td>
				<td>
					
					<c:out value="${qa.user.name}" />
					
				</td>
				<td>
					<c:out value="${qa.answer}" />
			<security:authorize access="#project.user.name == authentication.name && #qa.answer == null">
	         
	         <button class="btn btn-success" data-toggle="modal" data-target="#myModal3">
              Answer the question
             </button>

						<!-- Modal -->
						<div class="modal fade" id="myModal3" tabindex="-1" role="dialog"
							aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true">&times;</button>
										<h4 class="modal-title" id="myModalLabel">Answer the
											question</h4>
									</div>
									<div class="modal-body">

										<form action="updatequestion.html">
											<h2 class="form">Write answer to the question</h2>
											<input type="hidden" value="${qa.id}" name="id"> <input
												type="hidden" value="${project.id}" name="projectid">

											<textarea name="answer" class="form-control" cols="70"
												rows="5"></textarea>
											<div class="checkbox"></div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default"
													data-dismiss="modal">Close</button>
												<input type="submit" class="btn btn-primary" value="Save" />
											</div>
										</form>

									</div>
								</div>
							</div>
						</div>
					</security:authorize>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<security:authorize access="#project.user.name == authentication.name">
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#RewardModal">
		Create reward</button>  
	         
<form:form action="addreward.html" modelAttribute="reward" cssClass="form-horizontal projectForm">
<!-- Modal -->
<div class="modal fade" id="RewardModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">New project</h4>
      </div>
      <div class="modal-body">

        <div class="form-group">		
        <label for="name" class="col-sm-2 control-label">Reward description:</label>
			<div class="col-sm-10">
				<form:textarea path="description" rows="5" cols="70" cssClass="form-control" />
				<form:errors path="description" />
				<form:hidden path="project.id" value="${project.id}"/>
			</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Amount:</label>
			<div class="col-sm-10">
				<form:input path="amount" cssClass="form-control" />
				<form:errors path="amount" />
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

</security:authorize>

<c:forEach items="${project.rewards}" var="reward">
<c:out value="${reward.amount}" />
<c:out value="${reward.description}" />
</c:forEach>

<script type="text/javascript">
$(document).ready(function() {
	$('.nav-tabs a:first').tab('show'); // Select first tab
	$(".triggerRemove").click(function(e) {
		e.preventDefault();
		$("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
		$("#modalRemove").modal();
	});
	$(".projectForm").validate(
			{
				rules: {
					question: {
						required : true,
						minlength : 1
					}			
				},
				highlight: function(element) {
					$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
				},
				unhighlight: function(element) {
					$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
				}
			}
		);
});
</script>