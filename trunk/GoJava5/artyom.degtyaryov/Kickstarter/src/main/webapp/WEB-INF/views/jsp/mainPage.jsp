<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Kickstarter</title>
    <spring:url value="/resources/core/css/hello.css" var="coreCss"/>
    <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <link href="${coreCss}" rel="stylesheet"/>
    <link href="https://d297h9he240fqh.cloudfront.net/favicon.ico" rel="icon" type="image/x-icon">
</head>
<body>
<div class="jumbotron">
    <div class="container">
        <h2><i>${quote.presentation}</i></h2>
    </div>
</div>

<div class="container">

    <div class="row">
        <c:forEach var="category" items="${categories}">
            <div class="col-md-4">
                <h3>${category.name}</h3>

                <p>
                    <a class="btn btn-default" href="projects?categoryId=${category.id}" role="button">View projects</a>
                </p>
            </div>
        </c:forEach>
    </div>

    <hr>
    <footer>
        <p>&copy; tyomsky</p>
    </footer>
</div>

<spring:url value="/resources/core/css/hello.js" var="coreJs"/>
<spring:url value="/resources/core/css/bootstrap.min.js" var="bootstrapJs"/>

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

</body>
</html>