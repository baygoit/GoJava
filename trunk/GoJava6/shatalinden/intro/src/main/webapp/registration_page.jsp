<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:import url='jsp_page_parts/header.jsp' />

<section class="search">
    <div class="wrapper">
        <form action="#" method="post">
            <input type="text" id="search" name="search" placeholder="Press to Create a New User                »»»»»»                »»»»»                »»»»                »»»                »»                »"  autocomplete="off"/>
            <input type="submit" id="submit_search" name="submit_search"/>
        </form>
        <a href="#" class="advanced_search_icon" id="advanced_search_btn"></a>
    </div>

    <div class="advanced_search">
        <div class="wrapper">
            <span class="arrow"></span>
            <form action="Registration" method="post">
                <input type="submit" id="submit_search" name="submit_search"/>
                <div class="search_fields">
                    <input type="text" class="float" id="min_price" name="min_price" placeholder="Name"  autocomplete="off">

                    <hr class="field_sep float"/>

                    <input type="text" class="float" id="max_price" name="max_price" placeholder="Surname"  autocomplete="off">
                </div>
                <div class="search_fields">
                    <input type="text" class="float" id="min_price" name="check_in_date" placeholder="Email"  autocomplete="off">

                    <hr class="field_sep float"/>

                    <input type="text" class="float" id="max_price" name="check_out_date" placeholder="Password"  autocomplete="off">
                </div>
            </form>
        </div>
    </div> <!-- end advanced search section  -->
</section><!--  end search section  -->

<c:import url='jsp_page_parts/footer.jsp' />
