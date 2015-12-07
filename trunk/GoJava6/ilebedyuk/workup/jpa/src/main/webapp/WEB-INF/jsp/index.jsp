<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
<title>Hello World</title>
</head>
<body>

<table border="1">
                   <!-- column data -->
                   <c:forEach var="user" items="${users}">
                       <tr>
                           <c:forEach var="userDetails" items="${user.getName()} ">
                               <td>
                                       <c:out value="${userDetails}"/>
                               </td>
                           </c:forEach>
                       </tr>
                   </c:forEach>
               </table>



</body>
</html>