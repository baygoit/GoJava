<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table width="100%" border="1">
        <caption><h1>List cities<h1></caption>
        <tr>
        <c:forEach var="item" items="${city}">
            <th class="headtab1">
            <a href="/search?cityid=${item.getId()}">${item.getName()}</a>
            <p><img src=${item.getImage()}  alt="0_0"></p>
            </th>
        </c:forEach>
        </tr>
</table>
<br>

<table width="100%" border="0">
        <caption><h1>List apartment<h1></caption>
        <tr>
        <c:forEach var="item" items="${apartment}">
            <th class="headtab2">
            <a href="/search?userid=${item.getId()}">${item.getCity()} ${item.getAddress()}</a>
            </th>
        </c:forEach>
        </tr>
</table>
<br>
</body>
</html>