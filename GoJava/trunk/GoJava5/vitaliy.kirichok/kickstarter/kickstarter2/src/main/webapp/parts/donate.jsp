<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="main">
    <div class="cl">&nbsp;</div>
    <div id="content">
        <div class="box">
            <div class="box-head">
                <h2>Donate for project "<c:out value="${project.name}"/>"</h2>
            </div>
            <form action="donate" method="post">
                <div class="form">
                    <input type="hidden" name="projectId" value="${project.id}">

                    <p>
                        <span class="req">max 150 symbols</span>
                        <label>User name <span>(Required Field)</span></label>
                        <input type="text" class="field size1" name="userName">
                    </p>

                    <p>
                        <span class="req">16 digits</span>
                        <label>Card number <span>(Required Field)</span></label>
                        <input type="text" class="field size1" name="cardNumber">
                    </p>
                    <c:choose>
                        <c:when test="${empty reward}">
                            <p>
                                <span class="req">max 10 symbols</span>
                                <label>Pledge value <span>(Required Field)</span></label>
                                <input type="text" class="field size1" name="pledge">
                            </p>
                        </c:when>
                        <c:otherwise>
                            <input type="hidden" name="rewardId" value="${reward.id}">
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="buttons">
                    <input type="submit" class="button" value="Donate">
                </div>
            </form>
        </div>
    </div>
    <div class="cl">&nbsp;</div>
</div>