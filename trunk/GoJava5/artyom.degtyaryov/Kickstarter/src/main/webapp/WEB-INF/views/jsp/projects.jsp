<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Kickstarter</title>
    <spring:url value="/resources/core/css/projects.css" var="coreCss"/>
    <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <link href="${coreCss}" rel="stylesheet"/>
    <link href="https://d297h9he240fqh.cloudfront.net/favicon.ico" rel="icon" type="image/x-icon">
</head>

<body>

<div class="jumbotron">
    <div class="container">
        <h2 class="page-header">${category.name}</h2>
    </div>
</div>

<div class="container">


    <c:forEach var="project" items="${projects}">
        <div class="row">
            <!--div class="col-md-7">
                <a href="#">
                    <img class="img-responsive" src="http://placehold.it/700x300" alt="">
                </a>
            </div-->
            <div class="col-md-12">
                <h3>${project.name}</h3>

                <p>${project.description}</p>

                <p><b>cost:</b> ${project.cost}
                    <b> balance:</b>${project.balance}
                    <b> deadline:</b>${project.deadLine}</p>
                <a class="btn btn-primary" href="project?projectId=${project.id}">View Project <span class="glyphicon glyphicon-chevron-right"></span></a>

            </div>
        </div>

        <hr>

    </c:forEach>

    <footer>
        <p>&copy; tyomsky</p>
    </footer>

</div>

<spring:url value="/resources/core/js/jquery.js" var="jqueryJs"/>
<spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs"/>

<script src="${jqueryJs}"></script>
<script src="${bootstrapJs}"></script>

</body>

</html>

