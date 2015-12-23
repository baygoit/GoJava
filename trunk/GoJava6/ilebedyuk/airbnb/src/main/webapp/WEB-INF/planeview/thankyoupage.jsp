<%--
    Document   : header
    Created on : May 20, 2010, 12:20:12 AM
    Author     : tgiunipero
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" type="text/css" href="/css/register.css">
        <link rel="stylesheet" type="text/css" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <title>AirBnb</title>
    </head>

<body>
  <div class="container">
        <div class="form" id="login">
          <div id="error">
              Thank you for registration, <c:out value="${name}"/>!
             <div>For come back to main page left <div id="countdown">10</div></div>
           </div>


<script>
  window.onload = function(){
      var form = document.getElementById('login');
       form.style.height = 150+"px"
  }
 </script>

 <script type="text/javascript">
   var seconds;
   var temp;

   function countdown() {
     seconds = document.getElementById('countdown').innerHTML;
     seconds = parseInt(seconds, 10);

     if (seconds == 1) {
       window.location = "/airbnb/";
       return;
     }

     seconds--;
     temp = document.getElementById('countdown');
     temp.innerHTML = seconds;
     timeoutMyOswego = setTimeout(countdown, 1000);
   }

   countdown();
 </script>


</body>
</html>