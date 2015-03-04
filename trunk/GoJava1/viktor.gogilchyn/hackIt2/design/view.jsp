<%@ page language="java" contentType="text/html; charset=utf-8"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="css/view.css" media="all" />
</head>
<body>
  <div class="users_container">
    <c:forEach items="${requestScope.gamers}" var="gamerItem">
      <div class="single_user_container">
          <span class="user_name">
            <c:out value="${gamerItem.getName()}"/>
          </span>
          <span class="detailed_user">
           <form method="get" action="actors" class="inline-form">
            <input type="hidden" name="id" value="${gamerItem.getId()}"/> 
            <input type="submit" class="details_button" value="Details" />
           </form>
          </span>
          <span class="edit_user">
           <form method="post" action="actors" class="inline-form">
            <input type="hidden" name="edit" value="yes" /> 
            <input type="hidden" name="id" value="${gamerItem.getId()}"/> 
            <input type="submit" class="edit_button" value="Edit" />
           </form>
          </span>
          <span class="delete_user">
           <form method="post" action="actors" class="inline-form">
            <input type="hidden" name="delete" value="yes" /> 
            <input type="hidden" name="id" value="${gamerItem.getId()}"/> 
            <input type="submit" class="delete_button" value="Delete" />
           </form>
          </span>
      </div>
  </c:forEach>
  </div>

</body>
</html>