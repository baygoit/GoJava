<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fieldset style="width: 600px; font-family: Arial; font-size: 14px">
			<legend style="text-align: center">TOP 10 CATEGORIES</legend>
				<div>
					<ol>
						
						<c:forEach var="map" items="${top10Categories}">
						
   							<li> ${map[0]} : overall amount of pledges = ${map[1]} </li>
   							
						</c:forEach>
					
					</ol>
				</div>
		</fieldset>