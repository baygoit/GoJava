<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
function validate() {
	
	//Считаем значения из полей name и email в переменные x и y
	   var x=document.forms[0]["login"].value;
	   var y=document.forms[0]["password"].value;
	   //Если поле login пустое выведем сообщение и предотвратим отправку формы
	   if (x.length==0){
	      document.getElementById("loginf").innerHTML="*данное поле обязательно для заполнения";
	      return false;
	   }
	   //Если поле password пустое выведем сообщение и предотвратим отправку формы
	   if (y.length==0){
	      document.getElementById("passwordf").innerHTML="*данное поле обязательно для заполнения";
	      return false;
	   }
	
}
</script>
<title>index page</title>
</head>
<body>

	<form method="post" action="indexPage" onsubmit="return validate()">

		<table>
			<tr>
				<td><label for="loginId">Login: </label></td>
				<td><input type="text" name="login" id="loginId" size="25" value="user1"/><span style="color:red" id="loginf"></span></td>
			</tr>

			<tr>
				<td><label for="passwordId">Password: </label></td>
				<td><input type="password" name="password" id="passwordId" size="25" value="1"/><span style="color:red" id="passwordf"></span></td>
			</tr>

		</table>
		<input type="submit" value="enter">
	</form>

	<br />
	<div style="color: red">
		<c:out value="${requestScope.userNotFound}" />
	</div>


<!-- setertA -->
<form action="SomeController2" method="POST">
        <label>profile's id: <input type="text" name="profileId" /></label><br />
        <input type="submit" value="Submit" />
    </form>
    
    <%
String errorDiscription = (String)request.getAttribute("errorDiscription");

%>	

error: <%=errorDiscription%>


</body>
</html>


