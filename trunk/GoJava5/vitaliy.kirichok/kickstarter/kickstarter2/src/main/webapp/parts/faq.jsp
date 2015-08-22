<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <div>
        <form name="addQuestion" action="project">
            <input type="hidden" name="id" value="${project.id}">
            <input type="text" name="question">
            <input type="submit" name="action" value="addQuestion">
        </form>
    </div>
    <div>
        <table border="1">
            <tbody>
            <c:forEach items="${faqs}" var="faq">
                <tr>
                    <td>
                        <c:out value="${faq.question}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <c:out value="${faq.answer}"/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>