<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:import url='jsp_page_parts/header.jsp' />

<section class="search">
    <div class="wrapper">
        <form action="#" method="post">
            <input type="text" id="search" name="search" placeholder="Press to Login                »»»»»»»                »»»»»»                »»»»»                »»»»                »»»                »»                »"  autocomplete="off"/>
            <input type="submit" id="submit_search" name="submit_search"/>
        </form>
        <a href="#" class="advanced_search_icon" id="advanced_search_btn"></a>
    </div>

    <div class="advanced_search">
        <div class="wrapper">
            <span class="arrow"></span>
            <form action="login" method="post">
                <input type="submit" id="submit_search" name="submit_search"/>
                <div class="search_fields">
                    <input type="text" class="float" id="min_price" name="email" placeholder="Email"  autocomplete="off">

                    <hr class="field_sep float"/>

                    <input type="text" class="float" id="max_price" name="password" placeholder="Password"  autocomplete="off">
                </div>
            </form>
        </div>
    </div> <!-- end advanced search section  -->
</section><!--  end search section  -->

<c:import url='jsp_page_parts/footer.jsp' />