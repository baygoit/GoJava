<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp">
	<jsp:param value="Selected project" name="title" />
</jsp:include>

	<div class="container">
		<div class="row">
			<div class="box">
				<div class="col-lg-12">
					<ol class="breadcrumb">
						<li><a href="/kickstarter/category?id=${project.category.id}">${project.category.name}</a></li>
						<li class="active">${project.name}</li>
					</ol>
				</div>
				
				<div class="col-lg-12">
					<hr>
						<h2 class="intro-text text-center"><strong>${project.name}</strong></h2>
					<hr>
				</div>
					
					<div class="col-lg-5">
						<iframe width="450" height="325" src="${project.linkOnVideo}"></iframe>	
					</div>
					<div class="col-lg-7">
						<p><strong>Short description:</strong> ${project.shortDescription}</p>
						<p><strong>Required amount:</strong> ${project.requiredSum} $</p>	
						<p><strong>Collected amount:</strong> ${project.collectedSum} $</p>
						<p><strong>Days left:</strong> ${project.daysLeft} $</p>
					</div>
					<div class="col-lg-12">
						<p><strong>Full description:</strong> ${project.fullDescription}</p>
					</div>
				</div>
				
			<div class="box">
				<div class="col-lg-12" style="margin-top:30px">
				
					<ul class="nav nav-tabs">
						<li class="active"><a href="#payment" data-toggle="tab">Payment</a></li>
						<li><a href="#faq" data-toggle="tab">FAQ</a></li>
						<li><a href="#questions" data-toggle="tab">Questions</a></li>
					</ul>
					
					<div class="tab-content" style="margin-top:15px">	  		  
						<div class="tab-pane active" id="payment">			    
							<form method="post" class="form-horizontal" action="./payment">
								<div class="form-group col-sm-7">
									<input required type="text" class="form-control" id="inputName" name="userName" placeholder="Name">
								</div>
								<div class="form-group col-sm-7">
									<input required type="text" class="form-control" id="inputCardNumber" name="creditCardNumber" pattern="[0-9]{13,16}" placeholder="Card number">
								</div>			  
								<div class="form-group col-sm-7">
									<dl class="dl-horizontal">
										<c:forEach items="${rewards}" var="reward">
											<dt>If you donate ${reward.pledge} USD :</dt><dd> ${reward.description}</dd>
										</c:forEach>
									</dl>
									<label for="pledge" class="inputLabel">Please enter pledge amount : </label>
									<input name="pledge" type="text" />		    						
									<input id ="projectId" type="hidden" name="projectId" value="${project.id}" />				
								</div>			  
								<div class="form-group col-sm-7">
									<button type="submit" class="btn btn-default">Make payment</button>
								</div>			  
						</form>
					</div>
		
					<div class="tab-pane" id="faq">
						<dl class="dl-horizontal">
							<c:forEach items="${questions}" var="question">
								<p> - ${question.question}</p>
							</c:forEach>
						</dl>
					</div>
	
					<div class="tab-pane" id="questions">
						<a class="btn btn-default" data-toggle="collapse" href="#collapseExample">Leave question</a>
							<div style="margin-top:15px" class="collapse" id="collapseExample">
								<form method="post" class="form-horizontal" action="./ask">
									<div class="form-group col-sm-7">
										<input required type="text" class="form-control" id="inputQuestion" name="question" pattern="{10}" placeholder="Enter your question">
										<input id ="projectId" type="hidden" name="projectId" value="${project.id}" />	
									</div>
									<div class="form-group col-sm-7">
										<button type="submit" class="btn btn-default">Ask</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<!-- Script to Activate internal Project functions -->
			<script type="text/javascript">
				$('.nav-tabs a').click(function (e) {
				  e.preventDefault()
				  $(this).tab('show')
				})
			</script>
		
	    </div>
 	</div>

<jsp:include page="footer.jsp" />