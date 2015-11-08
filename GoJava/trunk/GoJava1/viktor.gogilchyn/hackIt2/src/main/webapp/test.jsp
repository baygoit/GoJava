<%@ page language="java" contentType="text/html; charset=utf-8"
 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <body>
        <h1>JSTL Examples</h1>
        <h2>List of Application Context: ${applicationScope}</h2>
        <table>
            <c:forEach var="entry" items="${applicationScope}">
            <tr>
                <td>${entry.key}</td>
                <td>
                    <c:out value="${entry.value}"/>
                </td>
            </tr>
            </c:forEach>
        </table>
       
        <h2>List of Session Context: ${sessionScope}</h2>
        <table>
            <c:forEach var="entry" items="${sessionScope}">
            <tr>
                <td>${entry.key}</td>
                <td>
                    <c:out value="${entry.value}"/>
                </td>
            </tr>
            </c:forEach>
        </table>
       
        <h2>List of Page Context: ${pageScope}</h2>
        <table>
            <c:forEach var="entry" items="${pageScope}">
            <tr>
                <td>${entry.key}</td>
                <td>
                    <c:out value="${entry.value}"/>
                </td>
            </tr>
            </c:forEach>
        </table>
       
        <h2>List of Request Context: ${requestSope}</h2>
        <table>
            <c:forEach var="entry" items="${requestSope}">
            <tr>
                <td>${entry.key}</td>
                <td>
                    <c:out value="${entry.value}"/>
                </td>
            </tr>
            </c:forEach>
        </table>
       
        <h2>List of Query Parameters: ${param}</h2>
        <table>
            <c:forEach var="entry" items="${param}">
            <tr>
                <td>${entry.key}</td>
                <td>
                    <c:out value="${entry.value}"/>
                </td>
            </tr>
            </c:forEach>
        </table>
       
        <h2>List of Header Parameters: ${header}</h2>
        <table>
            <c:forEach var="entry" items="${header}">
            <tr>
                <td>${entry.key}</td>
                <td>
                    <c:out value="${entry.value}"/>
                </td>
            </tr>
            </c:forEach>
        </table>       
       
        <h2>List of Cookies: ${cookie}</h2>
        <table>
            <c:forEach var="entry" items="${cookie}">
            <tr>
                <td>${entry.key}</td>
                <td>
                    <c:out value="${entry.value}"/>
                </td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>