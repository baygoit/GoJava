<%--
Document   : confirmation
Created on : Sep 9, 2009, 12:20:30 AM
Author     : tgiunipero
--%>

<%@ taglib prefix="c"
       uri="http://java.sun.com/jsp/jstl/core" %>

<table border="1">
    <!-- column data -->
        <tr>
            <td class="search">
                <c:out value="${user.getName()} ${user.getSurname()} ${user.getEmail()}"/>
            </td>
        </tr>
</table>