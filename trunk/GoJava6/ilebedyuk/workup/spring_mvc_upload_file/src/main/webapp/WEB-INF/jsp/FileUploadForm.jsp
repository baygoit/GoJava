<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>

<body>
	<h2>Spring MVC file upload example</h2>

	<form:form method="POST" commandName="fileUploadForm"
		enctype="multipart/form-data">

		<form:errors path="*" cssClass="errorblock" element="div" />

		Please select a file to upload : <input type="file" name="file" />
		<input type="submit" value="upload" />
		<span><form:errors path="file" cssClass="error" />
		</span>

	</form:form>

</body>
</html>