<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />

<p>
	<i>${quote.getText()}</i> (c) ${quote.getAuthor()}
</p>

<h3>Categories:</h3>

<c:forEach var="category" items="${categories}">
	<div class="category">
		<!-- <p> -->
			<a href="projects.html?id=${category.getId()}">${category.getName()}</a>
		<!-- </p> -->
	</div>
</c:forEach>

<jsp:include page="footer.jsp" />