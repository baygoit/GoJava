<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="view.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="view.js"></script>
<title>Add hero</title>
</head>
<body>
<body id="main_body">
 <div id="form_container">
  <h1>Add an actor</h1>
  <form id="addactor" class="appnitro" method="post" action="actors">
   <div class="form_description">
    <h2>Add an actor</h2>
    <p>You can set hero name and add some skills to him</p>
   </div>
   <ul>
    <li id="li_1"><label class="description" for="name">Name
    </label>
     <div>
      <input id="name" name="name" class="element text medium"
       type="text" maxlength="255" value="" />
     </div>
     <p class="guidelines" id="guide_1">
      <small>Name can contain only alphanumeric charachters.
       It's recommended to use one word, started with capital, ex. "Joe"</small>
     </p></li>
    <li id="li_2"><label class="description" for="element_2">Skills
    </label>
     <div>
      <input id="skills" name="skills" class="element text large"
       type="text" maxlength="255" value="" />
     </div>
     <p class="guidelines" id="guide_2">
      <small>Enter desired skills, delimitered by comma. Skill
       can contain only of one word, all symbols should be in lower case</small>
     </p></li>
    <li class="buttons"><input type="hidden" name="form_id"
     value="970427" /> <input id="saveForm" class="button_text"
     type="submit" name="submit" value="Send" /></li>
   </ul>
  </form>
 </div>

</body>

<a href="#">Create</a>
<a href="actors">Read</a>
</html>