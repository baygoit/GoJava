<%@ page language="java" isErrorPage="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Error page</title>
    <meta charset="utf-8">
</head>
<body>
    <button onclick="history.back()">Back to Previous Page</button>
    <h1>404 Page Not Found.</h1>
    <br />
    <p><b>Error code:</b> ${pageContext.errorData.statusCode}</p>
    <p><b>Request URI:</b> ${pageContext.request.scheme}://${header.host}${pageContext.errorData.requestURI}</p>
    <br />
</body>
</html>