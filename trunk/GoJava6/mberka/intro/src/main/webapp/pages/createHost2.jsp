<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Create Host</title>
<link rel="stylesheet" href="mainstyle.css" type="text/css">
</head>

<body>
<form method="get" action="CreateHostController">
If you want to become a Host User, please,<br>
(i)enter Apartment City, (ii)choose Apartment Type and (iii)choose Dates of Availability: <br>
<p>
    (i)Apartment City:<br>
    <input name="aptCity">
    <br>
    <br>
    (ii)Choose Apartment Type:<br>
    <select name="aptType">
    <option>Shared Room</option>
    <option>Private Room</option>
    <option>Flat</option>
    <option>House</option>
    </select><br>
</p>
<p>
    (iii)Choose Dates of Availability:<br>
    Choose <b>Start Day</b> of Availability:<br>
    Choose Year:<br>
        <select name="startYear">
                 <option>2015</option>
                 <option>2016</option>
                 <option>2017</option>
                 <option>2018</option>
                 <option>2019</option>
                 <option>2020</option>
            </select><br>
        Choose Month:<br>
            <select name="startMonth">
                    <c:forTokens items="January,February,March,April,May,June,July,August,September,October,November,December" delims="," var="month">
                        <option><c:out value="${month}"/></option>
                    </c:forTokens>
                    <br/>
            </select><br>
        Choose Day:<br>
            <select name="startDay">
                <c:forEach var="day" begin="1" end="31">
                    <option><c:out value="${day}"/></option>
                </c:forEach>
                <br/>
            </select><br>
</p>
<p>
    Choose <b>End Day</b> of Availability:<br>
    Choose Year:<br>
    <select name="endYear">
             <option>2015</option>
             <option>2016</option>
             <option>2017</option>
             <option>2018</option>
             <option>2019</option>
             <option>2020</option>
        </select><br>
    Choose Month:<br>
        <select name="endMonth">
                <c:forTokens items="January,February,March,April,May,June,July,August,September,October,November,December" delims="," var="month">
                    <option><c:out value="${month}"/></option>
                </c:forTokens>
                <br/>
        </select><br>
    Choose Day:<br>
        <select name="endDay">
            <c:forEach var="day" begin="1" end="31">
                <option value="${day}">${day}</option>
            </c:forEach>
            <br/>
        </select><br>
</p>
    <input type="submit" value="Become a Host User!">
</form>
</body>
</html>