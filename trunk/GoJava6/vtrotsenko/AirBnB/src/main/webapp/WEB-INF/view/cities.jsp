<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 11.12.15
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cities</title>
    <link rel="stylesheet" href="/css/listStyle.css">
</head>
<body>
<!--Pattern HTML-->
<div id="pattern" class="pattern">
    <ul class="list img-list">

        <c:forEach var="city" items="${cities}">
            <li>
                <a href="/city?id=${city.id}" class="inner">
                    <div class="li-img">
                        <img src="http://bradfrost.github.com/this-is-responsive/patterns/images/fpo_square.png" alt="Image Alt Text" />
                    </div>
                    <div class="li-text">
                        <h4 class="li-head">${city.cityName}</h4>
                        <p class="li-summary">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis sit amet tellus velit, ut semper neque.</p>
                        <p class="li-action">Read More</p>
                    </div>
                </a>
            </li>
        </c:forEach>

    </ul>
</div>
<!--End Pattern HTML-->


<div class="container">
    <section class="pattern-description">
        <h1>List with Thumbnails and Summary Text</h1>
        <p>A list of items that contain a thumbnail image and a large block of text. Small screens hide the summary content but gets exposed once screen space becomes available. </p>
        <h2>Considerations</h2>
        <ul>
            <li>Normally it's not a good idea to hide content for small screens, so make sure the content being hidden (article excerpt, further product info, etc) is supplementary and not essential for the user to make an informed decision. </li>
            <li>Make sure that hidden content is still accessible somewhere (it would most likely live on the linked page).</li>
            <li>Read: <a href="http://www.stubbornella.org/content/2010/06/25/the-media-object-saves-hundreds-of-lines-of-code/" rel="external">The media object saves hundreds of lines of code</a></li>
        </ul>
    </section>
</div>
</body>
</html>
