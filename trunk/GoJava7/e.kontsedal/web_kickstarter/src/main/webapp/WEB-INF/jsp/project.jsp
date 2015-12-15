<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />
		<div class="row">
			<div class="col-md-12">
				<ol class="breadcrumb">
				  <li><a href="./">Kickstarter</a></li>
				  <li><a href="./category?id=${project.getIdParentCategory()}">movie</a></li>
				  <li class="active">${project.getProjectName()}</li>
				</ol>
			</div>
			<div class="col-md-6">		
				<iframe width="560" height="315" src="${project.getVideoUrl()}" frameborder="0" allowfullscreen></iframe>				
			</div>	
			<div class="col-md-6">
				<div style="font-size:24px">${project.getProjectName()}</div>
				<p class="lead">${project.getProjectShortDescription()}</p>
				<p>${project.getProjectDescription()}</p>
				<dl class="dl-horizontal">
				  <dt>Costs need</dt>
				  <dd>${project.getProjectCostNeed()}</dd>
				  <dt>Costs collected</dt>
				  <dd>${payment}</dd>
				  <dt>Days left</dt>
				  <dd>${project.getProjectDaysLeft()}</dd>
				</dl>
			</div>
			<div class="col-md-12" style="margin-top:30px">
			  <ul class="nav nav-tabs" role="tablist">
			    <li role="presentation" class="active"><a href="#payment" aria-controls="payment" role="tab" data-toggle="tab">Payment</a></li>
			    <li role="presentation"><a href="#faq" aria-controls="faq" role="tab" data-toggle="tab">FAQ</a></li>
			    <li role="presentation"><a href="#questions" aria-controls="questions" role="tab" data-toggle="tab">Questions</a></li>
			  </ul>
			  <div class="tab-content" style="margin-top:15px">
			    <div role="tabpanel" class="tab-pane active" id="payment">
				    <form method="post" class="form-horizontal">
					  <div class="form-group col-sm-7">
					      <input required type="text" class="form-control" id="inputName" name="inputName" placeholder="Name">
					  </div>
 					  <div class="form-group col-sm-7">
					      <input required type="text" class="form-control" id="inputCardNumber" name="inputCardNumber" pattern="[0-9]{13,16}" placeholder="Card number">
					  </div>
					  <div class="form-group col-sm-7">
					    	<label class="radio-inline">
							  <input type="radio" checked="checked" name="inlineRadioOptions" id="inlineRadio1" value="1"> 1</input>$
							</label>
							<label class="radio-inline">
							  <input type="radio" name="inlineRadioOptions" id="inlineRadio2" value="10"> 10</input>$
							</label>
							<label class="radio-inline">
							  <input type="radio" name="inlineRadioOptions" id="inlineRadio3" value="40"> 40</input>$
							</label>
							<label class="radio-inline">
							  <input type="radio" name="inlineRadioOptions" id="inlineRadio4" value="0"> <input type="text" name="amount" pattern="[0-9]{1,11}"></input>$
							</label>  
					  </div>
					  <div class="form-group col-sm-7">
					      <button type="submit" class="btn btn-default">Make payment</button>
					  </div>
					</form>
				</div>
			    <div role="tabpanel" class="tab-pane" id="faq">faq faq</div>
			    <div role="tabpanel" class="tab-pane" id="questions">questions questions</div>
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