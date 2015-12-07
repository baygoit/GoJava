<%--
    Document   : index
    Created on : Jun 9, 2010, 3:59:32 PM
    Author     : tgiunipero
--%>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


        <div id="indexRightColumn">
            <div id="textTitle">
                <h1>WELCOME HOME</h1>
                <br> Rent unique places to stay from local hosts in 90+ cities
            </div>

        <c:forEach var="cities" items="${cities}">
                <div class="categoryBox">
                    <a href="/airbnb/room?city=${cities}">
                        <span class="categoryLabelText"><c:out value="${cities}"/></span>
                        <img src="${initParam.cityImagePath}${cities}.jpg" alt="${cities}" id = "city">
                    </a>
                </div>
        </c:forEach>
        </div>

