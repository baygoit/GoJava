<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link type="text/css" rel="stylesheet" href="design.css">
	<title>Project Office Management System</title>
	
	  <style>
  		 h4, h5 {
			   margin-left: 20px; 
			}
	  </style>
  
</head>
<body>

  
	<h3>Учет денег:</h3>
	<h4><a href="<s:url action='BankAccountList'/>">Банковские счета</a></h4>
	<h4><a href="CashMovement.jsp">Записи о движении денег</a></h4>
	<h3>Учет затрат:</h3>
	<h4><a href="CostItems.jsp">Статьи затрат</a></h4>	
	<h4><a href="Projects.jsp">Проекты</a></h4>	
	<h4><a href="ProjectStages.jsp">Этапы проектов</a></h4>
	<h4><a href="ProjectFinResultEntries.jsp">Записи о затратах проектов</a></h4>
	<h5><a href="ExchangeRates.jsp">Курсы валют</a></h5>
	<h3>Документы:</h3>
	<h4><a href="PaymentDocumentList.jsp">Платежные документы</a></h4>
	<h4>Планы поступления денег</h4>
	<h4>Финансовые планы проектов</h4>
	<h3>Отчеты:</h3>
	<h4>План-факт ДС</h4>
	<h4>План-факт затрат</h4>
	 
</body>
</html>