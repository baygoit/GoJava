<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="sidebar">
    <div class="box">
        <div class="box-head">
            <h2>Rewards</h2>
        </div>
        <div class="box-content">
            <a href="donate?projectId=${project.id}"><span><h2>Donate any pledge</h2></span></a>
            <br>

            <div class="cl">&nbsp;</div>
            <c:forEach items="${rewards}" var="reward">
                <div class="box">
                    <a href="donate?projectId=${project.id}&rewardId=${reward.id}">
                        <div class="box-head">
                            <h2>
                                <c:out value="${reward.amount}"/>
                            </h2>
                        </div>
                    </a>

                    <div class="box-content">
                        <c:out value="${reward.description}"/>
                    </div>
                </div>
            </c:forEach>
            <div class="cl">&nbsp;</div>
        </div>
    </div>
</div>