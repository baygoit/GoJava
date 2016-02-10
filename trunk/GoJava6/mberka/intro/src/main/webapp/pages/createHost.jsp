<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Create Host</title>
<link rel="stylesheet" href="mainstyle.css" type="text/css">

<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
    <style>
        .datepicker{
        }
    </style>
    <script>
        $(function() {
        $( ".datepicker" ).datepicker();
        });
     </script>

</head>

<body>
<form method="get" action="CreateHostController">
If you want to become a Host User, please,<br>
(i)enter Apartment City, (ii)choose Apartment Type and (iii)choose Dates of Availability: <br>
<p>
    (i)Apartment City:<br>
    <input name="aptCity">
</p>
<p>
    (ii)Choose Apartment Type:<br>
    <select name="aptType">
    <option>Shared Room</option>
    <option>Private Room</option>
    <option>Flat</option>
    <option>House</option>
    </select><br>
</p>
<p>
    (iii)Choose Dates of Apartment Availability:<br>
    Choose <b>Start Day</b> of Availability:<br>
        <input type="text" class="datepicker" name="startDate" />
        <br>
    Choose <b>End Day</b> of Apartment Availability:<br>
        <input type="text" class="datepicker" name="endDate"/>
</p>
    <input type="submit" value="Become a Host User!">
</form>
</body>
</html>