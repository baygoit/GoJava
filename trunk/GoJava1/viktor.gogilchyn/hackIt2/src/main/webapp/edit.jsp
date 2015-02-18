<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Add an actor</title>
<link rel="stylesheet" type="text/css" href="view.css" media="all"/>
<script type="text/javascript" src="view.js"></script>

</head>
<body id="main_body" >
    <div id="form_container" class="centered">
        <h1><a>Add an actor</a></h1>
        <form id="addform" class="appnitro"  method="post" action="actors/edit">
                    <div class="form_description">
            <h2>Add an actor</h2>
            <p>You can set hero name and add some skills to him</p>
        </div>                      
            <ul >
                    <li id="li_1" >
        <label class="description" for="element_1">Name </label>
        <div>
            <input id="element_1" name="name" class="element text medium" type="text" maxlength="255" value=""/> 
        </div><p class="guidelines" id="guide_1"><small>Name can contain only alphanumeric charachters. 
It's recommended to use one word, started with capitol, ex. "Joe"</small></p> 
        </li>       <li id="li_2" >
        <label class="description" for="element_2">Skills </label>
        <div>
            <input id="element_2" name="skills" class="element text large" type="text" maxlength="255" value=""/> 
        </div><p class="guidelines" id="guide_2"><small>Enter desired skills, delimitered by semicolon. 
Skill can contain only of ine word, all symbols should be lowercase</small></p> 
        </li>
                    <li class="buttons">
                <input type="hidden" name="create" value="yes" />
                <input id="saveForm" class="button_text" type="submit" name="submit" value="Submit" />
        </li>
            </ul>
        </form> 
    </div>
    </body>
</html>