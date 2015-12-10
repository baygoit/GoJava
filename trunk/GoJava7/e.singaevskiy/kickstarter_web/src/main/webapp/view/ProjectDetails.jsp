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
					<jsp:include page="Button.jsp" >
						<jsp:param name="link" value="message?id=${project.id}" />
						<jsp:param name="color" value="green" />
						<jsp:param name="title" value="Send a message" />
						<jsp:param name="tag" value="m" />
					</jsp:include>
					
					<jsp:include page="Button.jsp" >
						<jsp:param name="link" value="pay?id=${project.id}" />
						<jsp:param name="color" value="blue" />
						<jsp:param name="title" value="Donate" />
						<jsp:param name="tag" value="$" />
					</jsp:include>
					
					<jsp:include page="Button.jsp" >
						<jsp:param name="link" value="back" />
					</jsp:include>
				
				</div>
			</div>
		</div>
	</div>
</body>
</html>