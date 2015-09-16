<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <style type="text/css">
        A{
            text-decoration: none;
        }
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Kickstarter</title>
</head>
<body>


<h1 style="text-decoration: #20b2aa"> "Success doesn't come to you... you go to it." </h1>

<div align="left" style="margin-top: 50px;">

    <table frame="box" style="list-style-position: inherit" width="100%" border="1">
        <tr>
            <td width="20"><c:out value= "ID"/></td>
            <td><c:out value="NAME"/></td>
        </tr>
        <c:forEach var="category" items="${requestScope.listOfCategories}">
            <tr>
                <td><c:out value="${category.id}"/></td>
                <%--<td><a href="/category?categoryId=${category.id}&categoryName=${category.name}"> <c:out value="${category.name} "/> </a> </td>--%>
                <td><a href="/category?categoryId=${category.id}"> <c:out value="${category.name} "/> </a> </td>
            </tr>
        </c:forEach>




        <%--<form action="Kickstarter_new" method="get">--%>
        <%--Please enter your Username: <input type="text" name="username" size="20px"> <br>--%>
        <%--Please enter your Password: <input type="text" name="password" size="20px"> <br><br>--%>
        <%--<input type="submit" value="submit">--%>
        <%--</form>--%>
    </table>
</div>

<%--<div>--%>
    <%--<c:forEach var="category" items="${requestScope.listOfCategories}">--%>
        <%--<select name="category">--%>
            <%--<option value="${category.id}"> <c:out value="${category.name} "/> </option>--%>
            <%--&lt;%&ndash;<tr>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<td><c:out value="${category.id}"/></td>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<td><a href=<%"/servlet.ApplicationServlet?categoryId=" %>>  </a> </td>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
        <%--</select>--%>
    <%--</c:forEach>--%>


<%--</div>--%>

<%--<div>--%>
    <%--<c:forEach var="category" items="${requestScope.listOfCategories}">--%>
    <%--<ul>--%>
        <%--<li><c:out value="${category.name}"/></li>--%>
            <%--&lt;%&ndash;<tr>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<td><c:out value="${category.id}"/></td>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<td><a href=<%"/servlet.ApplicationServlet?categoryId=" %>>  </a> </td>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
    <%--</ul>--%>
    <%--</c:forEach>--%>
<%--</div>--%>

<%--<div>--%>
    <%--<c:forEach var="category" items="${requestScope.listOfCategories}">--%>
        <%--<menu>--%>
            <%--<li><c:out value="${category.name}"/></li>--%>
        <%--</menu>--%>
    <%--</c:forEach>--%>
<%--</div>--%>

</body>
</html>