<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link rel="stylesheet" type="text/css" href="view.css" media="all"/>
<script type="text/javascript">
function validate()
    {
        var returnValue = true;
        var errorMessage = "";
        var itemToValidate = document.getElementById('name_input').value;
        var errorBox = document.getElementById("error");
        if (itemToValidate.length < 5 || itemToValidate.length > 25) {
            returnValue = false;
            errorMessage = "Name can't be less then 3 and more then 25 symbols";
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
</head>
    <body>
        <div class="container"> 
            <div class="user_container">
                <form id="addform" class="form" method="post" action="actors">
                    <p><span>Name:</span><input id="name_input" name="name" class="text medium" type="text" maxlength="25" value=""/> </p>
                    <p><span>Skills:</span><input name="skills" class="text medium" type="text" maxlength="255" value=""/> </p>
                    <input type="hidden" name="create" value="yes"/>   
                    <p><button type="submit" class="add_button" onclick="return validate();">Add</button></p>
                </form>
            </div>
            <c:forEach items="${requestScope.gamers}" var="gamerItem">
            <hr></hr>
            <div class="user_container">
                <div class="user_name">
                    <h3><c:out value="${gamerItem.getName()}"/></h3>
                </div>
                <div class="user_skills">
                    <ul>
                           <c:forEach items="${gamerItem.getSkills()}" var="skillItem">
                        <li>
                            <c:out value="${skillItem.key}"/>
                        </li>
                            </c:forEach>
                    </ul>
                    
                </div>
                <div class="user_buttons">
                    <form method="post" action="actors" class="inline-form">    
                      <input type="hidden" name="delete" value="yes"/>   
                      <input type="hidden" name="${gamerItem.getName()}" value="on"/>  
                      <input type="submit" class="delete_button" value="Delete"/>
                    </form>
                    <form method="post" action="actors" class="inline-form">    
                      <input type="hidden" name="edit" value="yes"/>
                      <input type="hidden" name="${gamerItem.getName()}" value="on"/>  
                      <input type="submit" class="edit_button" onclick="return false;" value="Edit"/>
                    </form>
                </div>
            </div>
            </c:forEach>
        </div>

        <div id = "error" class="error_container" onclick="this.style.display = 'none';">
        </div>
    </body>
</html>