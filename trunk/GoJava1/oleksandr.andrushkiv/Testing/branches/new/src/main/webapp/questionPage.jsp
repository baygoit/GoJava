<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
function validate() {
/* 
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
 */
}
</script>
<title>Questions page</title>
</head>
<body>

	<form method="post" action="SimpleQuestionController" >

		<table>
		
			<tr>
				<td><label for="loginId">Question </label></td>
				<td><label for="loginId">Standart answer </label></td>
				<td><label for="loginId"> </label></td>
			
			</tr>
			
			<tr>
				<td><input type="text" name="question" id="loginId" size="40" /><span style="color:red" id="loginf"></span></td>
				<td><input type="text" name="standartAnswer" id="loginId" size="40" /><span style="color:red" id="loginf"></span></td>
				<td><input type="submit" name="create" value="enter"></td>
			</tr>
			
	</table>

			
<table>
	<c:forEach items="${questionList}" var="question">
    <tr>
    <form method="post" action="SimpleQuestionController" >
      <td><c:out value="${question}" /></td> <input type="hidden" name="question_id" value="${question.id}"> 
      <td><input type="submit" name="delete" value="delete"></td>
      <td><input type="submit" name="updateOne" value="update"></td> 
     </form>
    </tr>
  </c:forEach>
</table>
</form>

</body>
</html>


