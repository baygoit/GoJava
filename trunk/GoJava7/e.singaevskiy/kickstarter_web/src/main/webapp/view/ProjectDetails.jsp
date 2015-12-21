<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="components/Top.jsp"><jsp:param name="title"
		value="${project.name}" /></jsp:include>

<jsp:include page="components/Menu.jsp" />

<div class="row">
	<div class="col-md-7">
		<ul class="nav nav-tabs">
			<li class="active"><a data-toggle="tab" href="#info">Explore</a></li>
			<li><a data-toggle="tab" href="#ask">Ask</a></li>
			<li><a data-toggle="tab" href="#donate">Donate</a></li>
		</ul>

		<div class="tab-content">
			<div id="info" class="tab-pane fade in active">
				<h3>${project.name}</h3>

				<p>
					<i> started ${project.getEndDate()} by <b>${project.author}</b></i>
				</p>
				<p>${project.getDescription()}</p>

				<h2>$${project.getBalanceSum()}</h2>
				<p>
					<b>pledged of $${project.getGoalSum()} goal</b>
				</p>

				<h2>${project.daysLeft()}</h2>
				<p>
					<b>days to go</b>
				</p>

			</div>
			<div id="ask" class="tab-pane fade">
				<h3>Frequently asked questions</h3>
				<p>
					<c:if test="${project.getQuestions().size()!=0}">
						<table>
							<c:forEach var="question" items="${project.getQuestions()}">
								<tr>
									<td>${question.getQuestion()}</td>
									<td>${question.getAnswer()}</td>
								</tr>
							</c:forEach>
						</table>
					</c:if>
				</p>

				<a class="btn btn-primary" href="message?id=${project.id}"
					role="button">Ask</a>
			</div>
			<div id="donate" class="tab-pane fade">
				<h3>Choose your reward</h3>

				<form method="get" class="form-horizontal" action="./payment">
					<input type="hidden" name="projectId" value="${project.getId()}" />

					<div class="form-group col-sm-7">
						<label class="radio"> <input type="radio" name="rewardId"
							value="0" checked="checked" />I just want to help the project
						</label>
						<c:forEach var="reward" items="${rewards}">
							<label class="radio"> <input type="radio" name="rewardId"
								value="${reward.id}" /> $${reward.getPledgeSum()} -
								${reward.getDescription()}
							</label>
						</c:forEach>
					</div>
					<div class="form-group col-sm-7">
						<button type="submit" class="btn btn-primary">Donate</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="col-md-5">
		<c:if test="${not empty project.getVideoUrl()}">
			<c:set var="mark" value="=" />
			<c:set var="videoUrl" value="${project.getVideoUrl()}" />
			<c:set var="i" value="${fn:indexOf(videoUrl, mark)}" />
			<c:set var="j" value="${fn:length(videoUrl)}" />

			<div class="embed-responsive embed-responsive-4by3">
				<iframe class="embed-responsive-item"
					src="http://www.youtube.com/embed/${fn:substring(videoUrl, i+1, j)}"></iframe>
			</div>

		</c:if>
	</div>

</div>

<jsp:include page="components/Bottom" />