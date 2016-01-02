<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />

<h3>Project:</h3>

<p>name: ${selectedProject.getName()}</p>
<p>funded: ${selectedProject.getFunded()}</p>
<p>daysToGo: ${selectedProject.getDaysToGo()}</p>
<p>pledged: ${selectedProject.getAmountPledge()}</p>
<p>description: ${selectedProject.getDescription()}</p>
<p>owner: ${selectedProject.getOwner()}</p>
<p>goal: ${selectedProject.getGoal()}</p>
<p>linkVideo: ${selectedProject.getLinkVideo()}</p>

<c:forEach var="question" items="${questions}">

	<p>
		Question: <i>${question.getQuestionText()}</i>
	</p>

</c:forEach>


<p>
	<a href="payments?projectId=${selectedProject.getId()}">to invest
		in the project</a>
</p>


<p>
	<a href="question?projectId=${selectedProject.getId()}">to ask a
		question</a>
</p>

<jsp:include page="footer.jsp" />