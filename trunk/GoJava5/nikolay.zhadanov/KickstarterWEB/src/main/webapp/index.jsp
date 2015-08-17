<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>test</title></head>
<body>
<h2>Hello World!</h2>
<h2><c:out value="${map}"/></h2>
<p>${requestScope.map}</p>
</body>
</html>
