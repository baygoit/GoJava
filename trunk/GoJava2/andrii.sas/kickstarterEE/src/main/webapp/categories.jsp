<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <title>Kickstarter</title>
    </head>
    <body>
    	<s:iterator value="categories" status="category">
			<s:url action='projects' var="urlTag">
    			<s:param name="id">${id}</s:param>
    		</s:url>
            <s:a href="%{urlTag}"><s:property value="name"/></s:a>
    	</s:iterator>
    	<s:a href="createDummy">Create Dummy</s:a>

    </body>
</html>