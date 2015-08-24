<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Kickstarter</title>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,600' rel='stylesheet' type='text/css'>
    <link href="css/common.css" type="text/css" rel="stylesheet">
</head>
<body>
    <div class="main_content">
        <header class="header cf">
            <div class="left_block f_left">
                <a class="logo" href="#">
                    <img src="" alt="">
                </a>
            </div>
            <div class="right_block f_right">
                <div class="login_search_panel">

                </div>
                <div class="motivator">
                    <p><c:out value="${quote}"/></p>
                </div>
            </div>
        </header>
        <section class="main_block cf">
            <div class="content f_left">
                <h1>Hello! My name is <c:out value="${name}"/>.</h1>
            </div>
            <div class="right_sidebar f_right">
                <ul>
                    <c:forEach items="${categories}" var="category">
                        <li><c:out value="${category.name}"/></li>
                    </c:forEach>
                </ul>
            </div>
        </section>
    </div>
    <footer class="footer">

    </footer>
</body>
</html>
