<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />

<i>${quote.getText()}</i>
(c) ${quote.getAuthor()}
<br>

<h3>Categories:</h3>

<c:forEach var="category" items="${categories}">
	<a href="projects?id=${category.getId()}">${category.getName()}</a>
	<br />
</c:forEach>

<jsp:include page="footer.jsp" />