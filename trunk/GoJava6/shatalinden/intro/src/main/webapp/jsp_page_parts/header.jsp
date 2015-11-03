<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">

  <head>
    <title>airbnb</title>
    <meta charset="utf-8">
    <meta name="author" content="pixelhint.com">
    <meta name="description" content="La casa free real state fully responsive html5/css3 home page website template"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0" />

    <link rel="stylesheet" type="text/css" href="../css/reset.css">
    <link rel="stylesheet" type="text/css" href="../css/responsive.css">

    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/main.js"></script>
  </head>

  <body>
      <section class="hero">

        <header>
          <div class="wrapper">
            <a href="index.jsp"><img src="../img/logo.png" class="logo" alt="" titl=""/></a>
            <a href="#" class="hamburger"></a>
            <nav>
              <ul>
                <li><a href='${userPage}'><c:out value='${greeting}' default='' /></a></li>
                <li><a href="GetAllUsersServlet">Get all users</a></li>
                  <c:if test="${userActionServlet == null}">
                      <c:set var="userActionServlet" value="registration_page"/>
                      <c:set var="logServlet" value="login_page"/>
                  </c:if>
                <li><a href='${userActionServlet}'><c:out value='${userAction}' default='Registration' /></a></li>
              </ul>
              <a href='${logServlet}' class="login_btn"><c:out value='${log}' default='Login' /></a>
            </nav>
          </div>
        </header><!--  end header section  -->

        <section class="caption">
          <h2 class="caption">airbnb</h2>
          <h3 class="properties">Appartements - Houses - Rooms</h3>
        </section>

      </section><!--  end hero section  -->