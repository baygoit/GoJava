<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:import url='jsp_page_parts/header.jsp' />

<c:import url='jsp_page_parts/search_apartment.jsp' />

<section class="listings">
    <div class="wrapper">
        <ul class="properties_list">
            <li>
                <a href="#">
                    <img src="img/user.jpg" alt="" title="" class="property_img"/>
                </a>
                <span class="price">${user.name}</span>
                <div class="property_details">
                    <h1>
                        <a>E-mail: ${user.email}<br>This user is a: ${user.type}</a>
                    </h1>
                    <h2>ID: ${user.userID}<span class="property_size"> Password: ${user.password}</span></h2>
                    <c:if test="${user.email != 'admin'}">
                        <form action="deleteUser">
                            <input type="submit" value="Press to delete user">
                        </form>
                    </c:if>
                    <c:if test="${user.booleanUserType}">
                        <c:set var="userID" scope="session" value="${user.userID}"/>
                        <form action="GetUserApartments">
                            <input type="submit" value="Get user's apartments">
                        </form>
                    </c:if>
                    </h2>
                </div>
            </li>
        </ul>
        <div class="more_listing">
            <a href="#" class="more_listing_btn">View More Listings</a>
        </div>
    </div>
</section> 	<!--  end listing section  -->

<c:import url='jsp_page_parts/footer.jsp' />