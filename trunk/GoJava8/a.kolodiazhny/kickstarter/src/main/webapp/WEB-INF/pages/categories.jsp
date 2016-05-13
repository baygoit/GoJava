<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/pages/header.jsp" />
        <div class="container">
            <jsp:include page="/WEB-INF/pages/navigation.jsp" />
            <div class="page-header">
                <h2>${title}</h1>
            </div>
            <div class="list-group categories">
            <c:forEach var="category" items="${categories}">
                <a href="?view=category&id=${category.id}" class="list-group-item">
                    ${category.id} - ${category.name}
                </a>
            </c:forEach>
            </div>
        </div>
<jsp:include page="/WEB-INF/pages/footer.jsp" />