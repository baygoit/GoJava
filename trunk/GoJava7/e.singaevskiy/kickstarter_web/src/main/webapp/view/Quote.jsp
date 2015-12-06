<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${not empty quote}">
	"<c:out value="${quote.text}" />" - <c:out value="${quote.author}" /><br>
</c:if>
