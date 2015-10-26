<%--
    Document   : category
    Created on : Jun 9, 2010, 3:59:32 PM
    Author     : tgiunipero
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<sql:query var="categories" dataSource="jdbc/affablebean">
    SELECT * FROM category
</sql:query>

<sql:query var="selectedCategory" dataSource="jdbc/affablebean">
    SELECT name FROM category WHERE id = ?
    <sql:param value="${pageContext.request.queryString}"/>
</sql:query>

<sql:query var="categoryProducts" dataSource="jdbc/affablebean">
    SELECT * FROM product WHERE category_id = ?
    <sql:param value="${pageContext.request.queryString}"/>
</sql:query>

<p id="test">test ${list}</p>

<div id="categoryLeftColumn">

    <c:forEach var="category" items="${categories.rows}">

        <c:choose>
            <c:when test="${category.id.toString() == pageContext.request.queryString}">
                <div class="categoryButton" id="selectedCategory">
                                <span class="categoryText">
                                        ${category.name}
                                </span>
                </div>
            </c:when>
            <c:otherwise>
                <a href="category?${category.id}" class="categoryButton">
                                <span class="categoryText">
                                        ${category.name}
                                </span>
                </a>
            </c:otherwise>
        </c:choose>

    </c:forEach>

</div>

<div id="categoryRightColumn">

    <p id="categoryTitle">${selectedCategory.rows[0].name}</p>

    <table id="productTable">

        <c:forEach var="product" items="${categoryProducts.rows}" varStatus="iter">

            <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
                <td>
                    <img src="${initParam.productImagePath}${product.name}.png"
                         alt="image of ${product.name}">
                </td>
                <td>
                        ${product.name}
                    <br>
                    <span class="smallText">${product.description}</span>
                </td>
                <td>
                    &euro; ${product.price} / unit
                </td>
                <td>
                    <form action="addToCart" method="post">
                        <input type="hidden"
                               name="productId"
                               value="${product.id}">
                        <input type="submit"
                               value="add to cart">
                    </form>
                </td>
            </tr>

        </c:forEach>


    </table>
</div>