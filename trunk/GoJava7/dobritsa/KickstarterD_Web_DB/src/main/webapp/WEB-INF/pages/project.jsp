<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp">
	<jsp:param name="title" value="Project" />
</jsp:include>

<c:if test="${pageContext.request.userPrincipal.name == null}">
	<h3><a href="login">Login</a></h3>
</c:if>

<c:if test="${pageContext.request.userPrincipal.name != null}">
	<h3>Welcome : ${pageContext.request.userPrincipal.name} |
		<a href="<c:url value="/j_spring_security_logout" />" > Logout</a></h3>
</c:if>

<h3><a href="index">Kickstarter</a>
/
<a href="category?categoryId=${category.categoryId}">${category.name}</a></h3>


<h1>${project.name}</h1>
<h3>${project.description} </h3>
<cite>
	<br>Goal: ${project.goal}
	<br>Pledged: ${project.pledged} 
	<br>Days to go: ${project.daysToGo}
</cite>
<h3>About this project</h3>${project.history}
<br><br><cite>Demo video: ${project.link}</cite>

<h3><a href="reward?projectId=${project.projectId}">See rewards</a></h3>

<form action="question" method="post">
	<br>Ask your question:
	<br><textarea name="question" rows="5" cols="60"></textarea>
	<br> <input type="hidden" name="projectId" value="${project.projectId}" />
	<input type="submit" value="Submit" />
	<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
</form>

<c:if test="${empty questions}"><h3>There are no questions</h3></c:if>

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

<jsp:include page="footer.jsp" />