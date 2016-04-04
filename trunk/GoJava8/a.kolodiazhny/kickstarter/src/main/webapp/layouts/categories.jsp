<%@ include file="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <div class="container">
            <%@ include file="navigation.jsp" %>
            <div class="page-header">
                <h2>${title}</h1>
            </div>
            <div class="list-group">
            <c:forEach var="category" items="${categories}">
                <a href="?view=category&id=${category.id}" class="list-group-item">${category.id} - ${category.name}</a>
            </c:forEach>
            </div>
        </div>
<%@ include file="footer.jsp" %>