<%--
    Document   : confirmation
    Created on : Sep 9, 2009, 12:20:30 AM
    Author     : tgiunipero
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<table border="1">
    <!-- column data -->
    <c:out value="${city}"/>
    <c:forEach var="apartament" items="${apartaments}">
        <tr>
            <c:forEach var="apartamentDetails" items="${apartament.idAparnament} ${apartament.city} ${apartament.apartmentType} ${apartament.ownerId}">
                <td class="search">
                    <a href="/airbnb/user?id=${apartament.ownerId}">
                        <c:out value="${apartamentDetails}"/>
                    </a>
                </td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>


