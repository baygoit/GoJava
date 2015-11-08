<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="main">
    <div class="cl">&nbsp;</div>
    <div id="content">
        <div class="box">
            <div class="box-head">
                <h2 class="left">Categories</h2>

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
                        <th>Category name</th>
                    </tr>
                    <c:forEach items="${categories}" var="category">
                        <tr>
                            <td>
                                <h3>
                                    <a href="category?id=${category.id}"><c:out value="${category.name}"/></a>
                                </h3>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="pagging">
                    <div class="left">Showing ${categories.size()} of ${categories.size()}</div>
                </div>
            </div>
        </div>
    </div>
    <div class="cl">&nbsp;</div>
</div>
