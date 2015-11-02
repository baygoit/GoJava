<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section class="listings">
    <div class="wrapper">
        <ul class="properties_list">
            <c:forEach var='apartment' items='${apartmentsList}' varStatus='iterator' >
                <c:set var='picture' value='img/property_1.jpg' />
                <li>
                    <a href="#">
                        <img src=${picture} alt="" title="" class="property_img"/>
                    </a>
                    <span class="price">${apartment.price}$</span>
                    <div class="property_details">
                        <h1>
                            <a href="#">${apartment.shortDescription}</a>
                        </h1>
                        <h2>Type: ${apartment.type} <span class="property_size"> City: ${apartment.city}</span></h2>
                    </div>
                </li>
            </c:forEach>
        </ul>
        <div class="more_listing">
            <a href="#" class="more_listing_btn">View More Listings</a>
        </div>
    </div>
</section>	<!--  end listing section  -->