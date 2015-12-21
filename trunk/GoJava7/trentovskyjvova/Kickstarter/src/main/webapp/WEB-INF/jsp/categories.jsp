<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />

<p>
	<i>${quote.getText()}</i> (c) ${quote.getAuthor()}
</p>

<h3>Categories:</h3>

<c:forEach var="category" items="${categories}">
	<p>
		<a href="projects?id=${category.getId()}">${category.getName()}</a>
	</p>
</c:forEach>

<jsp:include page="footer.jsp" />