<jsp:include page="header.jsp" />
        <div class="container">
            <jsp:include page="navigation.jsp" />
            <div class="page-header">
                <h1>KickStarter <small>"${quote.text} -"${quote.author}</small></h1>
            </div>
            <div class="jumbotron">
                <h2>Categories</h2>
                 <p>We have a best project to invest in for everybody. Right here and right now.</p>
                 <p><a class="btn btn-primary btn-lg" href="?view=categories" role="button">Learn more</a></p>
            </div>
        </div>
<jsp:include page="footer.jsp" />