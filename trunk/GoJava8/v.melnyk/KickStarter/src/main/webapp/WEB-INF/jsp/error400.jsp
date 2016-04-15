<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="Bad request" scope="request"/>
<%@include file='header.jsp'%>
		<h1>Error: 400</h1>
		<h2>Bad request</h2>
		<hr/>
		<br/>
		Wrong request parameters.
<%@include file='footer.jsp'%>
