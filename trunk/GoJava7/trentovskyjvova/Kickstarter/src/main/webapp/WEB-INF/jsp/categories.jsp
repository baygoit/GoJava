<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />

<c:out value="<i>${quote.getText()}</i> (c) ${quote.getAuthor()}<br>"
	escapeXml="false" />
<h3>Categories:</h3>
<br>

<c:forEach var="category" items="${categories}">
	<a href="projects?id=<c:out value='${category.getId()}' />"><c:out
			value='${category.getName()}' /></a>
	<br />
</c:forEach>

<jsp:include page="footer.jsp" />