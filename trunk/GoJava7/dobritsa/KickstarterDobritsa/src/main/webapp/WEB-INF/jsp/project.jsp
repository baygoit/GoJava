<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp">
	<jsp:param name="title" value="Project" />
</jsp:include>

<h1>${project.name}</h1>
<h3>${project.description} </h3>
<cite>
	<br>Goal: ${project.goal}
	<br>Pledged: ${project.pledged} 
	<br>Days to go: ${project.daysToGo}
</cite>
<h3>About this project</h3>${project.history}
<br><br><cite>Demo video: ${project.link}</cite>


<c:if test="${not empty questions}">
	<h3>Questions:</h3>
	<ul>
		<c:forEach var="question" items="${requestScope.questions}">
			<li>
				<p>
					<cite>${question.time}				
						<br>${question.question}
						<br>${question.answer}	
					</cite>						
				</p>
			</li>
		</c:forEach>
	</ul>
</c:if>

<c:if test="${empty questions}"><h3>There are no questions</h3></c:if>


<jsp:include page="footer.jsp" />