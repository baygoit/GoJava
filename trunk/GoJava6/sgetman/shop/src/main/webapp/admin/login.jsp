<%--
  Created by IntelliJ IDEA.
  User: sergiigetman
  Date: 10/30/15
  Time: 3:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/css/login.css">

    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="/js/login.js"></script>

</head>
<body>
<form action="/login" method="post">

  <div class="group">
    <input type="text" name="user"><span class="highlight"></span><span class="bar"></span>
    <label>Username</label>
  </div>
  <div class="group">
    <input type="password" name="pass"><span class="highlight"></span><span class="bar"></span>
    <label>Password</label>
  </div>
  <button type="submit" class="button buttonBlue">Submit
    <div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
  </button>

</form>

</body>
</html>
