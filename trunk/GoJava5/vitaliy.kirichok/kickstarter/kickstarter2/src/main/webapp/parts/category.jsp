<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="main">
    <div class="cl">&nbsp;</div>
    <div id="content">
        <div class="box">
            <div class="box-head">
                <h2 class="left"><c:out value="${category.name}"/></h2>

                <div class="right">
                    <label>search articles</label>
                    <input type="text" class="field small-field">
                    <input type="submit" class="button" value="search">
                </div>
            </div>
            <div class="table">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <th>Project name</th>
                        <th>Description</th>
                        <th>Goal</th>
                        <th>Balance</th>
                        <th>Time left</th>
                    </tr>
                    <c:forEach items="${projects}" var="project">
                        <tr>
                            <td>
                                <h3>
                                    <a href="project?id=${project.id}"><c:out value="${project.name}"/></a>
                                </h3>
                            </td>
                            <td>
                                <c:out value="${project.shortDescription}"/>
                            </td>
                            <td>
                                <c:out value="${project.goal}"/>
                            </td>
                            <td>
                                <c:out value="${project.balance}"/>
                            </td>
                            <td>
                                <c:out value="${project.timeLeft}"/>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="pagging">
                    <div class="left">Showing ${category.projects.size()} of ${category.projects.size()}</div>
                </div>
            </div>
        </div>
    </div>
    <div class="cl">&nbsp;</div>
</div>