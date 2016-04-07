<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="Categories" scope="request"/>
<%@include file='header.jsp'%>
<label class="quote_text">"${quote.text}" </label><label class="quote_author">${quote.author}</label>
<br/><br/>
Project categories:
<hr/>
<ul>
<c:forEach var="category" items="${categories}">
	<li><a href="?page=category&id=${category.id}">${category.name}</a></li>
</c:forEach>
</ul>
<%@include file='footer.jsp'%>
