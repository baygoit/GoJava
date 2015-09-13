<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <h2><i>${project.name}</i></h2>
    </div>
</div>

<div class="container">

    <div class="row">
        <div class="col-md-7">
            <div class="embed-responsive embed-responsive-4by3">
                <iframe class="embed-responsive-item" src="${project.videoLink}"></iframe>
            </div>
        </div>
        <div class="col-md-5">
            <h3>${project.name}</h3>

            <p>${project.description}</p>

            <p><b>cost:</b> ${project.cost}
                <b> balance:</b>${project.balance}
                <b> deadline:</b>${project.deadLine}</p>

            <p><b> History: </b> ${project.history} </p>

            <p><b> QA: </b>

                <c:forEach var="questionAndAnswer" items="${questionsAndAnswers}">

            <p><b> ${questionAndAnswer.question}</b> <i>${questionAndAnswer.answer}</i></p>
            </c:forEach>
            <br/>

            <form id="question_form" class="chat_form" action="project/question" method="POST">
                <input type="hidden" name="projectId" value="${project.id}">

                <div class="form-group">
                    <label for="question">Ask a question:</label>
                    <textarea class="form-control" rows="5" id="question" name="question"></textarea>
                </div>
                <input class="btn btn-primary btn-success" type="submit" value="SEND">
            </form>

        </div>

    </div>

    <hr>

    <!--Payment-->
    <h4>
        You can help this project in next ways:
    </h4>

    <form action="payment/add/" method="POST">
        <div class="row">
            <div class="col-md-4">
                <div class="panel panel-danger">
                    <div class="panel-heading">
                        <h4 class="text-center">
                            MAECENAS</h4>
                    </div>
                    <div class="panel-body text-center">
                        <p class="lead">
                            <strong>$100</strong></p>
                    </div>
                    <div class="panel-footer">
                        <button class="btn btn-lg btn-block btn-danger" name="amount" value="100" type="submit">DONATE
                        </button>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <h4 class="text-center">
                            FELLOW</h4>
                    </div>
                    <div class="panel-body text-center">
                        <p class="lead">
                            <strong>$10</strong></p>
                    </div>
                    <div class="panel-footer">
                        <button class="btn btn-lg btn-block btn-info" name="amount" value="10" type="submit">DONATE
                        </button>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <h4 class="text-center">
                            MISER</h4>
                    </div>
                    <div class="panel-body text-center">
                        <p class="lead">
                            <strong>$1</strong></p>
                    </div>
                    <div class="panel-footer">
                        <button class="btn btn-lg btn-block btn-success" name="amount" value="1" type="submit">DONATE
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </form>
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