<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>All profiles</title>
</head>
<body>

<table>
  <c:forEach items="${profileList}" var="profile">
    <tr>
      <td><c:out value="${profile}" /></td>
    </tr>
  </c:forEach>
</table>

    <h2>Please enter the id of the profile you want to detail</h2>
    <form action="SomeController1" method="POST">
        <label>profile's id: <input type="text" name="profileId" /></label><br />
        <input type="submit" value="Submit" />
    </form>

<table>
  <c:forEach items="${quizList}" var="quiz">
    <tr>
      <td><c:out value="${quiz}" /></td>
    </tr>
  </c:forEach>
</table>

</body>
</html>