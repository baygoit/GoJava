<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/pages/header.jsp" />
        <div class="container">
            <jsp:include page="/WEB-INF/pages/navigation.jsp" />
            <div class="page-header">
                 <h1> 404 Not found </h1>
            </div>
             <ol class="breadcrumb">
                 <li><a href="<c:url value="/" />">Home</a></li>
             </ol>
        </div>
<jsp:include page="/WEB-INF/pages/footer.jsp" />