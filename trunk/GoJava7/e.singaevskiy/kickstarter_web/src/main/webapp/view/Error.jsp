<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${not empty sessionScope.errors && sessionScope.errors.size()>0}">
	<div class="boxContent" align="left" style="color: red;">
		<ul>
			<c:forEach var="error" items="${sessionScope.errors}">
				<li><c:out value="${error.value}"/></li>
			</c:forEach>
		</ul>
	</div>
	<c:remove var="errors" scope="session" />
</c:if>


