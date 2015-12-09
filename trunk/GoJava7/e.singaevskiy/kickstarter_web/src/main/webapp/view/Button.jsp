<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="link" value="${param.link}"/>
<c:if test="${link == 'back'}"><c:set var="link" value="javascript:history.back()"/></c:if>

<c:if test="${link == 'submit'} ">
	<c:set var="link" value="javascript:{}"/>
	<c:set var="onclick" value="document.getElementById('submitForm').submit(); return false;"/>
</c:if>

<c:set var="title" value="${param.title}"/>
<c:if test="${empty title}"><c:set var="title" value="Back"/></c:if>

<c:set var="tag" value="${param.tag}"/>
<c:if test="${empty tag}"><c:set var="tag" value="<"/></c:if>

<c:set var="color" value="${param.color}"/>
<c:if test="${empty color}"><c:set var="color" value=""/></c:if>

<a href="${link}" style="text-decoration: none"	title="${title}" onclick="${onclick}">
	<c:if test="${not empty link}">
		<div class="btn-round ${color}">
			<span>${tag}</span>
		</div>
	</c:if>						
</a>