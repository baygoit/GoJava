<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
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