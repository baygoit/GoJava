<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp">
	<jsp:param value="Selected project" name="title" />
</jsp:include>

	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">
			<ol class="breadcrumb">
				<li><a href="/kickstarter/category?id=${project.getCategory().getId()}">${project.getCategory().getName()}</a></li>
				<li class="active">${project.getName()}</li>
			</ol>
		</div>
		<div class="col-md-1"></div>
	</div>
		
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-4">		
			<iframe width="400" height="300" frameBorder="0" src="${project.getLinkOnVideo()}" ></iframe>				
		</div>	
		<div class="col-md-6">
			<div style="font-size:24px">${project.getName()}</div>
				<p class="lead">${project.getShortDescription()}</p>
				<p>${project.getFullDescription()}</p>
				<dl class="dl-horizontal">
			 		<dt>Costs need</dt>
					<dd>${project.getRequiredSum()}</dd>
					<dt>Costs collected</dt>
					<dd>${project.getCollectedSum()}</dd>
					<dt>Days left</dt>
					<dd>${project.getDaysLeft()}</dd>
				</dl>
		</div>
		<div class="col-md-1"></div>
	</div>
		
	<div class="row">
		<div class="col-md-1"></div>
			<div class="col-md-10" style="margin-top:30px">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#payment" data-toggle="tab">Payment</a></li>
				    <li><a href="#faq" data-toggle="tab">FAQ</a></li>
				    <li><a href="#questions" data-toggle="tab">Questions</a></li>
				</ul>
			 
				<div class="tab-content" style="margin-top:15px">	  		  
					<div class="tab-pane active" id="payment">			    
						<form method="post" class="form-horizontal" action="./payment">
							<div class="form-group col-sm-7">
								<input required type="text" class="form-control" id="inputName" name="first-name" placeholder="Name">
							</div>
							<div class="form-group col-sm-7">
								<input required type="text" class="form-control" id="inputCardNumber" name="creditCardNumber" pattern="[0-9]{13,16}" placeholder="Card number">
							</div>			  
							<div class="form-group col-sm-7">
								<dl class="dl-horizontal">
									<c:forEach items="${rewards}" var="reward">
										<dt>If you donate ${reward.getPledge()} USD :</dt><dd> ${reward.getDescription()}</dd>
									</c:forEach>
								</dl>
								<label for="donatingSum" class="inputLabel">Please enter pledge amount : </label>
								<input name="donatingSum" type="text" />		    						
								<input id ="projectId" type="hidden" name="projectId" value="${project.id}" />				
							</div>			  
							<div class="form-group col-sm-7">
								<button type="submit" class="btn btn-primary">Make payment</button>
							</div>			  
						</form>
					</div>
		
					<div class="tab-pane" id="faq">
						<dl class="dl-horizontal">
							<c:forEach items="${questions}" var="question">
								<dt> - </dt><dd>${question.question}</dd>
							</c:forEach>
						</dl>
					</div>
	
					<div class="tab-pane" id="questions">
						<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample">Leave question</a>
							<div style="margin-top:15px" class="collapse" id="collapseExample">
								<form method="post" class="form-horizontal" action="./ask">
									<div class="form-group col-sm-7">
										<input required type="text" class="form-control" id="inputQuestion" name="question" pattern="{10}" placeholder="Enter your question">
										<input id ="projectId" type="hidden" name="projectId" value="${project.id}" />	
									</div>
									<div class="form-group col-sm-7">
										<button type="submit" class="btn btn-primary">Ask!</button>
									</div>
								</form>
							</div>
					</div>
			</div>

			<script type="text/javascript">
				$('.nav-tabs a').click(function (e) {
				  e.preventDefault()
				  $(this).tab('show')
				})
			</script>
			
			
		</div>
	</div>

<jsp:include page="footer.jsp" />