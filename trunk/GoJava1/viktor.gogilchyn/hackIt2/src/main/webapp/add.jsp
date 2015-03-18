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
  <form name="add_form" id="add_form" action="informer" method="post">
   <input type="button" value="Add skill" onclick="addSkillEntry()"></input>
   <input type="button" value="Add attribute" onclick="addAttributeEntry()"></input>
   <input type="hidden" name="create" value="yes" /><br />
   <label for="name">Name:</label><br />
   <input type="text" name="name" maxlength="25" /><br /> 
   <div id="skills_container">
   <label for="skills">Skills:</label><br />
   <div id="skills_entry_container">
      <p>Name: <input type="text" name="skill_names"></input> Value:<input type="text" name="skill_values"></input></p>
   </div>
   </div>
   <div id="attributes_container">
   <label for="attributes">Attributes:</label><br />
   <div id="attributes_entry_container">
      <p>Name: <input type="text" name="attributes_names"></input> Value:<input type="text" name="attributes_values"></input></p>
   </div>
   </div>
   <br /> <input type="submit" />
  </form>
 </div>
<script type="text/javascript">
var sk_counter = 1;
var sk_limit = 7;
var at_counter = 1;
var at_limit = 7;
var skillHTML = document.getElementById("skills_entry_container").innerHTML;
var attributeHTML = document.getElementById("attributes_entry_container").innerHTML;

function addSkillEntry(){
    if (sk_counter == sk_limit)  {
         alert("You have reached the limit of adding " + sk_counter + " skills");
    }
    else {
         var newdiv = document.createElement('div');
         newdiv.id = "skills_entry_container";
         newdiv.innerHTML = skillHTML;
         document.getElementById("skills_container").appendChild(newdiv);
         sk_counter++;
    }
}

function addAttributeEntry(){
    if (at_counter == at_limit)  {
         alert("You have reached the limit of adding " + at_counter + " atributes");
    }
    else {
         var newdiv = document.createElement('div');
         newdiv.id = "attributes_entry_container";
         newdiv.innerHTML = skillHTML;
         document.getElementById("attributes_container").appendChild(newdiv);
         at_counter++;
    }
}
</script>
</body>
</html>