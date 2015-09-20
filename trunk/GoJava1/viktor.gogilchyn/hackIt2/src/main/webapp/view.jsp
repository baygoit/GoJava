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
 <div class="container">
  <div class="users_container">
   <form name="add_form" id="add_form" action="actors" method="post">
    <input type="hidden" name="create" value="yes" /> <label for="name">Name:</label><br />
    <input type="text" name="name" maxlength="25" /><br /> <label
     for="skills">Skills</label><br />
    <textarea rows="4" cols="50" name="skills"></textarea>
    <br /> <label for="attributes">Attributes</label><br />
    <textarea rows="4" cols="50" name="attributes"></textarea>
    <input type="submit" class="add_button" value="Add" />
   </form>
  </div>

  <c:forEach items="${requestScope.gamers}" var="gamerItem">
   <hr></hr>
   <div class="single_user_container">
    <span class="user_name"> <c:out
      value="${gamerItem.getName()}" />
    </span> <div class="detailed_user">
     <form method="get" action="actors" class="inline-form">
      <input type="hidden" name="view_id" value="${gamerItem.getId()}" />
      <input type="submit" class="details_button" value="Details" />
     </form>
    </div> <div class="edit_user">
     <form method="post" action="actors" class="inline-form">
      <input type="hidden" name="edit" value="yes" /> <input
       type="hidden" name="edit_id" value="${gamerItem.getId()}" /> <input
       type="submit" class="edit_button" value="Edit" />
     </form>
    </div> <div class="delete_user">
     <form method="post" action="actors" class="inline-form">
      <input type="hidden" name="delete" value="yes" /> <input
       type="hidden" name="delete_id" value="${gamerItem.getId()}" /> <input
       type="submit" class="delete_button" value="Delete" />
     </form>
    </div>
   </div>
  </c:forEach>
 </div>

 <div id="error" class="error_container"
  onclick="this.style.display = 'none';"></div>
 <script type="text/javascript">
function showError(text) {
   var errorBox = document.getElementById("error");
   errorBox.innerHTML = text;
   errorBox.style.display = "block";
}

function validate() {
        var returnValue = true;
        var errorMessage = "";
        var itemToValidate = document.getElementById('name_input').value;
        var errorBox = document.getElementById("error");
        if (itemToValidate.length < 3 || itemToValidate.length > 12) {
            returnValue = false;
            errorMessage = "Name can't be less then 3 and more then 12 symbols";
        }
        if( /[^a-zA-Z0-9]/.test(itemToValidate) ) {
        	returnValue = false;
            errorMessage = "Name should contain only alphanumeric symbols. No cyrillic allowed";
         }        
        if (itemToValidate.split(" ").length > 1)  {
            returnValue = false;
            errorMessage = "Name can't contain spaces";
        }
        if (!returnValue) {
            errorBox.innerHTML = errorMessage;
            errorBox.style.display = "block";
        }
        return returnValue;
    }
</script>
 <c:if test="${requestScope.error != null}">
  <script type="text/javascript">
          showError("${requestScope.error}")
</script>
 </c:if>

</body>
</html>