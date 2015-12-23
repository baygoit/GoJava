<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="/css/loginRegistrstion.css">
</head>
<body>
<div class="login">
    <h1>Login</h1>
    <form action="/login" method="post">
        <input type="text" name="email" placeholder="Username" required="required" />
        <input type="password" name="password" placeholder="Password" required="required" />
        <button type="submit" class="btn btn-primary btn-block btn-large">Let me in.</button>
    </form>
</div>
</body>
</html>