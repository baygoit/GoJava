<%--
    Document   : confirmation
    Created on : Sep 9, 2009, 12:20:30 AM
    Author     : tgiunipero
--%>
<%@ taglib prefix="c"
       uri="http://java.sun.com/jsp/jstl/core" %>


       <div id="categoryLeftColumn">
            <a href="/airbnb/admin?show=reservation_dates" class="categoryButton">
               <span class="categoryText">Show all reservation dates</span>
            </a>

           <a href="/airbnb/admin?show=apartaments" class="categoryButton">
               <span class="categoryText">Show all apartaments</span>
           </a>

           <a href="/airbnb/admin?show=users" class="categoryButton">
               <span class="categoryText">Show all users</span>
           </a>

            </div>
             <div id="categoryRightColumn">
             <table border="1">
                   <!-- column data -->
                   <c:forEach var="user" items="${users}">
                       <tr>
                           <c:forEach var="userDetails" items="${user.getName()} ${user.getSurname()} ${user.getEmail()}">
                               <td class="searchAdmin">
                                       <c:out value="${userDetails}"/>
                               </td>
                           </c:forEach>
                       </tr>
                   </c:forEach>
               </table>



                <table border="1">
                  <!-- column data -->
                  <c:forEach var="apartament" items="${apartaments}">
                      <tr>
                          <c:forEach var="apartamentDetails" items="${apartament.idAparnament} ${apartament.city} ${apartament.apartmentType} ${apartament.ownerId}">
                              <td class="searchAdmin">
                                      <c:out value="${apartamentDetails}"/>
                              </td>
                          </c:forEach>
                      </tr>
                  </c:forEach>
              </table>

              <table border="1">
                <!-- column data -->
                <c:forEach var="reservation" items="${reservation_dates}">
                    <tr>
                        <c:forEach var="reservationDetails" items="${reservation.getReservationDateId()} ${reservation.getDateBegin()} ${reservation.getDateEnd()}">
                            <td class="searchAdmin">
                                    <c:out value="${reservationDetails}"/>
                            </td>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </table>
            </div>