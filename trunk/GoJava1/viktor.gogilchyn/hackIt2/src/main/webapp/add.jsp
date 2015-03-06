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
    <form name="add_form" id="add_form" action="actors" method="post">
      <input type="hidden" name="create" value="yes" /> 
      <label for="name">Name:</label><br/>
      <input type="text" name="name" maxlength="25"/><br/>
      <label for="skills">Skills (one per line)</label><br/>
      <textarea rows="4" cols="50" name="skills"></textarea>
      <br/>
      <label for="attributes">Attributes (one per line)</label><br/>
      <textarea rows="4" cols="50" name="attributes"></textarea>    
    </form>
  </div>

</body>
</html>