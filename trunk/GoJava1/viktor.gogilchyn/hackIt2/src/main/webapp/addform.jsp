<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<script
 src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<title>Add hero</title>
<script type="text/javascript">
function validateName()
{
    var returnValue = true;
    var itemToValidate = document.forms["addactor"]["name"].value;
    if (itemToValidate.length < 5 || itemToValidate.length > 25) {
        returnValue = false;
    }
    if (itemToValidate.split(" ").length > 1)  {
        returnValue = false;
    }
    if( /[^a-zA-Z0-9]/.test( itemToValidate ) ) {
       returnValue = false;
    }
    return returnValue;
}
</script>
</head>
<body>
<body>
 <div class="container">
  <div class="center-block col-md-6">
   <form class="form-signin" action="actors" method="post">
    <div class="control-group">
     <label class="control-label" for="name"><b>Name</b></label>
     <div class="controls">
      <input id="name" name="name" type="text" value="Joe"
       class="input-large">
      <p class="help-block">Name can contain only alphanumeric
       charachters.</p>
     </div>
    </div>
    <div class="control-group">
     <label class="control-label" for="skills">Skills</label>
     <div class="controls">
      <input id="skills" name="skills" type="text"
       value="scan;develop" class="input-large">
      <p class="help-block">Enter desired skills, delimitered by
       semicolon.</p>
     </div>
    </div>
    <div class="control-group">
     <label class="control-label" for="submit"></label>
     <div class="controls">
      <input type="hidden" name="create" value="yes"/>
      <input type="submit" id="submit" name="submit"
       class="btn btn-sm btn-primary btn-block" value="Send" />
     </div>
    </div>
   </form>
  </div>
 </div>
</body>
</html>