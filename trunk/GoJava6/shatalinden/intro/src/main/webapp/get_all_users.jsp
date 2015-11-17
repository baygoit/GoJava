<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:import url='jsp_page_parts/header.jsp' />

<c:import url='jsp_page_parts/search_apartment.jsp' />

<section class="listings">
    <div class="wrapper">
        <ul class="properties_list">
            <c:forEach var='iterUser' items='${usersList}'>
                <li>
                    <a href="#">
                        <img src="../img/user.jpg" alt="" title="" class="property_img"/>
                    </a>
                    <span class="price">${iterUser.name}</span>
                    <div class="property_details">
                        <h1>
                            <a>E-mail: ${iterUser.email}<br>This user is a: ${iterUser.type}</a>
                        </h1>
                        <h2>ID: ${iterUser.userID}<span class="property_size"> Password: ${iterUser.password}</span></h2>
                    </div>
                </li>
            </c:forEach>
        </ul>
        <div class="more_listing">
            <a href="#" class="more_listing_btn">View More Listings</a>
        </div>
    </div>
</section>

<c:import url='jsp_page_parts/footer.jsp' />