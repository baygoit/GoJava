<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />
        <div class="container">
            <jsp:include page="navigation.jsp" />
            <div class="page-header">
                <h1>KickStarter <small>"${quote.text} " - ${quote.author}</small></h1>
            </div>
            <div class="jumbotron">
                <h2>Categories</h2>
                <div class="row">
                    <div class="col-md-6">
                        <p>We have a best project to invest in for everybody. Right here and right now.</p>
                        <div class="row">
                             <div class="col-md-4">
                                <img src="<c:url value="/img/Categories1-160x120.jpg" />"/>
                             </div>
                             <div class="col-md-8">
                                <a class="btn btn-primary btn-lg" href="<c:url value="/categories" />" role="button">Learn more</a>
                             </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <iframe width="425" height="260" src="https://www.youtube.com/embed/6CpOEcl1nec" frameborder="0" allowfullscreen></iframe>
                    </div>
                 </div>
            </div>
        </div>
<jsp:include page="footer.jsp" />