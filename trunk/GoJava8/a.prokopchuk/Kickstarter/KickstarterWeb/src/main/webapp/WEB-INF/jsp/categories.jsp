<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp" />

<h2>${quote.quoteText} (${quote.author})</h2>

	<ul>
		<c:forEach var="category" items="${categories}">
			<li><a href="projects?categoryId=${category.id}">${category.name}</a></li>
		</c:forEach>
	</ul>
	
<jsp:include page="footer.jsp" />