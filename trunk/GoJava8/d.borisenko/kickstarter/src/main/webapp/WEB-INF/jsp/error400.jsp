<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="Bad request" scope="request"/>
<jsp:include page="header.jsp"/>
		<h1>Error: 400</h1>
		<h2>Bad request</h2>
		<hr/>
		<br/>
		${requestScope['javax.servlet.error.message']}
<jsp:include page="footer.jsp"/>
