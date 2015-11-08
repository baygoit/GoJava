<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="main">
    <div class="cl">&nbsp;</div>
    <div id="content">
        <div class="box-head">
            <h2><c:out value="${project.name}"/></h2>
        </div>
        <div class="table">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                    <th>Description</th>
                    <td><c:out value="${project.shortDescription}"/></td>
                </tr>
                <tr>
                    <th>Goal</th>
                    <td><c:out value="${project.goal}"/></td>
                </tr>
                <tr>
                    <th>Balance</th>
                    <td><c:out value="${project.balance}"/></td>
                </tr>
                <tr>
                    <th>Time left</th>
                    <td><c:out value="${project.timeLeft}"/></td>
                </tr>
                <tr>
                    <th>Demonstration link</th>
                    <td><c:out value="${project.demoLink}"/></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <%@include file="rewards.jsp" %>
    <div class="cl">&nbsp;</div>
</div>