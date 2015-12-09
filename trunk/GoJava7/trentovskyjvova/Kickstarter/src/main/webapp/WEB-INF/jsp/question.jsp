<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />

<h3>Question:</h3>

<form action="question?projectId=${projectId}" method="post">
	<p>
		<input type="text" name="questionText" placeholder="question text">
	</p>
	<p>
		<input type="submit" value="Ask">
	</p>
</form>

<jsp:include page="footer.jsp" />