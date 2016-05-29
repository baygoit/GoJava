<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="Content-Style-Type" content="text/css" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css" />" />
	</head>
	<body class="quote_body">
		<div></div>
		<label class="quote_text">"${quote.text}" </label><br/>
		<label class="quote_author">${quote.author}</label>
	</body>
</html>