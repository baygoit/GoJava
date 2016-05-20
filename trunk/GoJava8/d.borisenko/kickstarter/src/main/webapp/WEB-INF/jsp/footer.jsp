<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	</div>	
	<div class="div_main_footer">
   		<spring:message code="common.version" />: @PROJECT_VERSION@<br/>
   		<spring:message code="common.build" />: @PROJECT_BUILD_DATE@ (@PROJECT_BUILD_TIMEZONE@)<br/>
   		(&#596;) Copyleft <spring:message code="common.for" /> GoIT
	</div>
</body>
</html>
    