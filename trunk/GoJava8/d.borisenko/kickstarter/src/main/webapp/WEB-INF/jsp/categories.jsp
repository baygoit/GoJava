<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="Categories" scope="request"/>
<jsp:include page="header.jsp"/>
		<label class="quote_text">"${quote.text}" </label><label class="quote_author">${quote.author}</label>
		<br/>
		<br/>
		<p>Project categories:</p>
		<hr/>
		<ul>
		<c:forEach var="category" items="${categories}">
			<li><a href="?page=category&id=${category.id}">${category.name}</a></li>
		</c:forEach>
		</ul>
<jsp:include page="footer.jsp"/>
