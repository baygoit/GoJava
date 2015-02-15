<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<title>Add hero</title>
</head>
<body>
<body>
 <div>
  <form id="addactor" method="post" action="actors">
   <div>
    <h2>Add an actor</h2>
    <p>You can set hero name and add some skills to him</p>
   </div>
   <ul>
    <li><label for="name">Name</label>
     <div>
      <input id="name" name="name" type="text" maxlength="255" value="" />
     </div>
     <p class="guidelines">
      <small>Name can contain only alphanumeric charachters.
       It's recommended to use one word, started with capital, ex. "Joe"</small>
     </p></li>
    <li><label class="description" for="element_2">Skills</label>
     <div>
      <input id="skills" name="skills" type="text" maxlength="255" value="" />
     </div>
     <p class="guidelines">
      <small>Enter desired skills, delimitered by comma. Skill
       can contain only of one word, all symbols should be in lower case</small>
     </p></li>
    <li> <input id="saveForm" class="button_text" type="submit" name="submit" value="Send" /></li>
   </ul>
  </form>
 </div>
</body>
<a href="#">Create</a>
<a href="actors">Read</a>
</html>