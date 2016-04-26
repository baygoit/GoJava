<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp">
	<jsp:param value="${project.name}" name="title" />
</jsp:include>

<div class="categories">
	<div class="container">
        <div class="row">
            <div class="box">
                <div class="col-lg-12 text-center">
                	<ul class="breadcrumb">
                		<li><a href="/">Home</a></li>
						<li><a href="categories">Categories</a></li>
						<li><a href="projects?categoryId=${project.category.id}">Projects</a></li>
					</ul>
					<h2>${project.name}</h2>
					<div class="info_block">
						<p><span>Required budget:</span> ${project.requiredBudget}</p>
						<p><span>Gathered budget:</span> ${project.gatheredBudget}</p>
						<p><span>Final date:</span> ${project.finalDate}</p>
						<p><span>Days left:</span> ${project.daysLeft}</p>
						<p><span>Description:</span> ${project.description}</p>
					</div>
					
					<ul id="myTab" class="nav nav-tabs nav-justified">
						<li class="active"><a href="#question_block">Question/Answer</a></li>
						<li><a href="#history_block">History</a></li>
  						<li><a href="#payment_block">Payment</a></li>
  						<li><a href="#reward_block">Reward</a></li>
  						<li><a href="#video_block">Video</a></li>
					</ul>
					
					<div id="myTabContent" class="tab-content">
						<div id="question_block" class="question_block tab-pane fade active in">
							<h3>Question and answers:</h3>
							<div class="questions test-${questions.size()}">
								<c:forEach var="question" items="${project.questions}">
									<div class="question question-${question.id}"><span>${question.question}</span> </div>
										<c:forEach var="answer" items="${question.answers}">
											<div class="answer answer-${answer.id}"><span>${answer.answer}</span> </div>
										</c:forEach>
								</c:forEach>
							</div>
							<form name="add_question" class="form-horizontal" action="" method="POST" accept-charset="utf-8">
								<div class="row">
									<div class="form-group col-sm-8">
										<input required type="text" class="form-control" id="inputQuestion"
											name="question" maxlength="400" placeholder="Enter your question...">
										<input type="hidden" name="projectId" value="${project.id}" />
										<input type="hidden" name="requested_action" value="ADD_QUESTION"/>
									</div>
									<div class="question_submit form-group col-sm-2">
										<button type="submit" class="btn btn-default">Ask</button>
									</div>
								</div>
							</form>
						</div>
						<div id="history_block" class="history_block tab-pane fade">
							${project.history}
						</div>
						<div id="payment_block" class="payment_block tab-pane fade">
							<h3>Payments:</h3>
							<div class="payments">
								<c:forEach var="payment" items="${project.payments}">
									<div class="payment row">
										<span class="cardholder_name col-sm-3">${payment.cardholderName}</span>
										<span class="amount col-sm-2">${payment.amount}</span>
									</div>
								</c:forEach>
							</div>
							<form name="add_payment" class="form-horizontal" action="" method="POST" accept-charset="utf-8">
								<input type="hidden" name="requested_action" value="ADD_PAYMENT"/>
								<input type="hidden" name="projectId" value="${project.id}" />
								<div class="row">
									<div class="form-group col-sm-3">
										<input required type="text" class="form-control"
											name="cardholder_name" pattern="[A-Za-zА-Яа-яЁё0-9\s]{2,50}" placeholder="Your name..." title="От 2 до 50 букв включительно!">
									</div>
									<div class="form-group col-sm-3">
										<input required type="text" pattern="[0-9]{13,16}" class="form-control"
											name="card_number" placeholder="Your card number..." title="Только цифры, oт 13 до 16 цифр включительно!">
									</div>
									<div class="form-group col-sm-3">
										<input required type="number" max='1000000' min='1' class="form-control"
											name="payment_amount" placeholder="Payment amount..." title="Только цифры, oт 1 до 1000000 включительно!">
									</div>
									<div class="payment_submit form-group col-sm-2">
										<button type="submit" class="btn btn-default">Invest</button>
									</div>
								</div>
							</form>
						</div>
						<div id="reward_block" class="reward_block tab-pane fade">
							<h3>Rewards:</h3>
							<div class="row">
								<c:forEach var="reward" items="${project.rewards}">
									<div class="form-group col-sm-4 text-center">
										<div class="form-group-reward">
											<div class="form-group-item"><span class="reward_name">${reward.name}</span></div>
											<div class="form-group-item"><span class="reward_amount">${reward.description}</span></div>
											<button class="btn btn-primary btn-lg btn-reward" data-toggle="modal" data-target="#myModal-${reward.id}">
										        Invest
										    </button>
									    </div>
									</div>
									<div class="modal fade reward-modal" id="myModal-${reward.id}" tabindex="-1" role="dialog"
										aria-labelledby="myModalLabel" aria-hidden="true">
										<div class="modal-dialog">
											<div class="modal-content">
												<button type="button" class="close" data-dismiss="modal"
													aria-hidden="true">&times;</button>
												<form name="add_reward" class="form-horizontal" action="" method="POST" accept-charset="utf-8">
													<input type="hidden" name="projectId" value="${project.id}" />
													<input type="hidden" name="requested_action" value="ADD_PAYMENT" />
													<input type="hidden" name="payment_amount" value="${reward.amount}">
													<div class="modal-body">
														<input required type="text" class="form-control form-group-item"
															name="cardholder_name" pattern="[A-Za-zА-Яа-яЁё0-9\s]{2,50}"  placeholder="Your name..." title="От 2 до 50 букв включительно!">
														<input required type="text" class="form-control form-group-item"
															name="card_number" pattern="[0-9]{13,16}" placeholder="Your card number..." title="Только цифры, oт 13 до 16 цифр включительно!">
													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
														<button type="submit" class="btn btn-primary">Invest</button>
													</div>
												</form>
											</div>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
						<div id="video_block" class="video_block tab-pane fade">
							<iframe width="560" height="315" src="${project.url}"></iframe>
						</div>
					</div>
				</div>
            </div>
        </div>
    </div>  
</div>

<jsp:include page="footer.jsp" />