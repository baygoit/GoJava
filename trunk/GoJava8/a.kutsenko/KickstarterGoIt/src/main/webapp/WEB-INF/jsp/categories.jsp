<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="title" scope="request">
	<spring:message code="categories.title" />:
</c:set>

<jsp:include page = "header.jsp" />
<label class="quote_text">"${quote.text}"</label>
<label class="quote_author">${quote.author}</label>
<br/><br/>
<hr/>
		<p><spring:message code="categories.categories" /></p>
		<ul>
		<c:forEach var="category" items="${categories}">
			<li><a href="<c:url value="/category/${category.id}" />">${category.name}</a></li>
		</c:forEach>
		</ul>
<jsp:include page="footer.jsp"/>