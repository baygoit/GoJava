<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<title>${project.name}</title>
<%@ include file="html/style.html"%>
</head>
<body>

	<div class="root">
		<div class="box">
			<div class="boxCaption basecolor">${project.name}</div>
			<div class="boxContent">

				<i> Author: ${project.author} </i> <br> <br>
				${project.getDescription()} <br>
				<br> Goal: ${project.getGoalSum()} / Balance:
				${project.getBalanceSum()} <br> Started:
				${project.getEndDate()} <br> Days left: ${project.daysLeft()} <br>

				<c:if test="${not empty project.getVideoUrl()}">
					<c:set var="mark" value="=" />
					<c:set var="videoUrl" value="${project.getVideoUrl()}" />
					<c:set var="i" value="${fn:indexOf(videoUrl, mark)}" />
					<c:set var="j" value="${fn:length(videoUrl)}" />

					<iframe width="420" height="315"
						src="http://www.youtube.com/embed/${fn:substring(videoUrl, i+1, j)}?autoplay=0"></iframe>
					<br>
				</c:if>



				<c:if test="${project.getQuestions().size()!=0}">
				<div class="subCaption basecolor">FAQ:</div>
					<table>
						<c:forEach var="question" items="${project.getQuestions()}">
							<tr>
								<td>${question.getQuestion()}</td>
								<td>${question.getAnswer()}</td>
							</tr>
						</c:forEach>
					</table>
				</c:if>

				<div class="controls basecolor">
					<a href=message?id=${project.id} style="text-decoration: none"
						title="Send a message">
						<div class="btn-round green">
							<span>m</span>
						</div>
					</a> <a href=pay?id=${project.id} style="text-decoration: none"
						title="Donate">
						<div class="btn-round blue">
							<span>$</span>
						</div>
					</a>
					<jsp:include page="html/Back.html" />
				</div>
			</div>
		</div>
	</div>
</body>
</html>