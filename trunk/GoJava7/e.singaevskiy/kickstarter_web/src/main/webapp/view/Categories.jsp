<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="title" value="Kickstarter" />
<jsp:include page="components/Top.jsp"><jsp:param name="title"
		value="${title}" /></jsp:include>

<jsp:include page="components/Menu.jsp"/>

<jsp:include page="components/Bottom"></jsp:include>