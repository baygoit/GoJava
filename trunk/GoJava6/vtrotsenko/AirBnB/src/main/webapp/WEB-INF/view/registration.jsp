<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Registration</title>
        <link rel="stylesheet" type="text/css" href="/css/style.css">
    </head>
    <body>
        <div class="login">
            	<h1>Registration</h1>
                <form action="/registration" method="post">
                	<input type="text" name="name" placeholder="Name" required="required" />
                	<input type="text" name="lastname" placeholder="Lastname" required="required" />
                    <input type="password" name="password" placeholder="Password" required="required" />
                	<input type="text" name="email" placeholder="Email" required="required" />
                    <button type="submit" class="btn btn-primary btn-block btn-large">Sign me up.</button>
                </form>
        </div>
    </body>
</html>