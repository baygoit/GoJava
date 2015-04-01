<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
<%@ taglib prefix="s" uri="/struts-tags" %>		

		<s:hidden name="paginator.firstResult" value="%{paginator.firstResult}" />
		<s:hidden name="paginator.total" value="%{paginator.total}" />
		<div> Показаны записи с <s:property value = "paginator.firstResult"/>
				по <s:property value = "paginator.lastResult"/> 
				(из <s:property value = "paginator.total"/>). 
			<button class = "defaultButton" type="submit" name="paginator.previousPage" value = "true">
				&lt&lt&lt
			</button>
			<button class = "defaultButton" type="submit" name="paginator.nextPage" value = "true">
				&gt&gt&gt
			</button>
				Отображать по  <s:textfield  name="paginator.maxResults" 
	   								value = "%{paginator.maxResults}"
	   								maxlength = "2" size="2" onchange = "submit"
	    					/>
		 	
		</div>
	