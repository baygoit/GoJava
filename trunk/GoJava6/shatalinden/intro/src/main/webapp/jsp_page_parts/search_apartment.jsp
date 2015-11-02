<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<section class="search">
  <div class="wrapper">
    <form action="#" method="post">
      <input type="text" id="search" name="search" placeholder="Book your room right now!"  autocomplete="off"/>
      <input type="submit" id="submit_search" name="submit_search"/>
    </form>
    <a href="#" class="advanced_search_icon" id="advanced_search_btn"></a>
  </div>

  <div class="advanced_search">
    <div class="wrapper">
      <span class="arrow"></span>
      <form action="GetAppartmentsByCity" method="post">
        <div class="search_fields">
          <input type="text" class="float" id="min_price" name="city" placeholder="Enter City to Get Apartments"  autocomplete="off">
        </div>
        <input type="submit" id="submit_search" name="submit_search"/>
        <div class="search_fields">
          <input type="text" class="float" id="min_price" name="check_in_date" placeholder="Check In Date"  autocomplete="off">

          <hr class="field_sep float"/>

          <input type="text" class="float" id="max_price" name="check_out_date" placeholder="Check Out Date"  autocomplete="off">
        </div>
        <div class="search_fields">
          <input type="text" class="float" id="min_price" name="min_price" placeholder="Min. Price"  autocomplete="off">

          <hr class="field_sep float"/>

          <input type="text" class="float" id="max_price" name="max_price" placeholder="Max. price"  autocomplete="off">
        </div>
      </form>
    </div>
  </div> <!-- end advanced search section  -->
</section><!--  end search section  -->