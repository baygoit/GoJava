<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
<h1>Hello Page</h1>


    <form action="say-hello" method="POST">
        Please enter your Name:  <input type="text" name="name" size="20px"> <br>
        Please enter your Surname:  <input type="text" name="surname" size="20px"> <br><br>
        <input type="submit" value="submit">
    </form>

</body>
</html>