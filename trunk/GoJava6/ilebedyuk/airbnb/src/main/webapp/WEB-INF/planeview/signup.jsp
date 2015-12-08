<%--
    Document   : header
    Created on : May 20, 2010, 12:20:12 AM
    Author     : tgiunipero
--%>

<%@ taglib prefix="c"
       uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
       <link rel="stylesheet" type="text/css" href="/css/register.css">
       <link rel="stylesheet" type="text/css" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
       <script src="js/script.js"></script>
       <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
       <title>AirBnb</title>
    </head>

<body>
  <div class="container">
      <div class="col-sm-12">

          <ul class="tabs">
            <li><a href="/airbnb/login" id="1">LOGIN</a></li>
            <li><a href="/airbnb/signup" id="2">SIGN UP</a></li>
          </ul>
          <div id="error">
            <span><c:out value="${error}"/></span>
            <span><c:out value="${uncorrectdata}"/></span>
          </div>
      </div>

      <div class="col-sm-12">
        <div class="form" id="login">

          <div class="col-sm-12 container">
          <div class="input">
          <form action="/airbnb/signup" method="POST">
               <input class="main-form" type="text" name="name" placeholder=" NAME" required/>
           </div>
           <div class="input">
                <input class="main-form" type="text" name="surname" placeholder=" SURNAME" required/>
           </div>
             <div class="input">
                 <input class="main-form" type="email" name="email" placeholder=" EMAIL ADDRESS" required/>
             </div>
            <div class="input">
            <input class="main-form" type="password" name="password" placeholder=" PASSWORD" required/>
             </div>
            <div class="input">
            <input class="main-form btn" type="submit"  value = "SIGN UP"/>
            </form>
             </div>
          </div>
        </div>
      </div>
    </div>
  </div>

<script>
  window.onload = function(){
      var form = document.getElementById('login');
       form.style.height = 350+"px"
  }
 </script>


</body>
</html>