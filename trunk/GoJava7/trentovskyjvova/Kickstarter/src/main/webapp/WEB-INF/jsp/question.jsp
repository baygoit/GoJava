<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />

<h3>Question:</h3>

<c:if test="${errors}">
	<p style="color:red">errors</p>
</c:if>

<form action="question?projectId=${projectId}" method="post">
	<p>
		<input type="text" name="questionText" required placeholder="question text">
	</p>
	<p>
		<input type="submit" value="Ask">
	</p>
</form>

<jsp:include page="footer.jsp" />