<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/admin.css">
</head>

<body>

<div class="container">

<div class="row">
    <div class="col-xs-6 col-md-4">
        <ul>
        <c:forEach var="category" items="${categories}">
            <li>
            <c:choose>
                <c:when test="${category.name == selectedCategory.name}">
                    <div class="categoryButton" id="selectedCategory">
                    <span class="categoryText">
                            ${category.name}
                    </span>
                    </div>
                </c:when>
                <c:otherwise>
                    <a href="<c:url value='admin?${category.id}'/>" class="categoryButton">
                    <span class="categoryText">
                            ${category.name}
                    </span>
                    </a>
                </c:otherwise>
            </c:choose>
            </li>
        </c:forEach>
        </ul>
    </div>

    <div  class="col-xs-12 col-md-8">

        <p id="categoryTitle"><fmt:message key="${selectedCategory.name}" /></p>


            <c:forEach var="product" items="${categoryProducts}" varStatus="iter">

                            ${product.name}
                        <br>
                        <span class="smallText">${product.description}</span>


                        <form action="<c:url value='admin?updatePrice'/>" method="post">
                            <input type="hidden"
                                   name="productId"
                                   value="${product.id}">
                            <input type="text" name="productPrice" value="${product.price}">
                            <input type="submit"
                                   name="submit"
                                   value="update price">
                        </form>

            </c:forEach>

    </div>

</div>

<div class="row">
    <a href="/logout">Log out</a>
</div>
    </div>
</body>
</html>
