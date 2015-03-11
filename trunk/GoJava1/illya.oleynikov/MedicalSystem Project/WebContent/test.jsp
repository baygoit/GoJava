<%@ page language="java" contentType="text/html; charset=UTF-8"

            
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <script type="text/javascript">
    
    function validateData(obj){
        
        if ((obj.name == "AddNew")||(obj.name == "Edit") ) {
            
        }
        
        return true;
    }
    
    </script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link type="text/css" rel="stylesheet" href="design.css">
        <title>Project Office Management System</title>
    </head>
    <body>
      
        
        <div class="pageHeader">Банковские счета</div>
        
        <form name="BankAccountsTable"
            action="BankAccountWebController"
            method=POST>

            <c:if test="${errorMessage != null}">
                <table class = "errorTable">
                    <tr>
                        <td>${errorMessage}</td>
                        <c:set var="errorMessage" scope="session" value = "${null}" />
                    </tr>
                </table>
            </c:if>
            
            <table class = "table">
                <tr class="tableHeader">
                    <th>Идентификатор</th>
                    <th>Название</th>
                    <th>Банк</th>
                    <th>Валюта</th>
                    <th>Остаток</th>
                </tr>
                <c:if test="${pageScope.bankAccountService != null}" >
                    <!-- <input type="hidden" name="OpenCashMovement" value="${null}" />
                         --> 
                    <c:set var="bankAccounts" scope="page" value = "${bankAccountService.retrieveAll()}" />
                    <c:forEach var="currentbankAccount" items="${bankAccounts}">
                        <tr class="tableRow">
                            <td>${currentbankAccount.getId()}</td>
                            <td>${currentbankAccount.getName()}</td>
                            <td>${currentbankAccount.getBankName()}</td>
                            <td>${currentbankAccount.getCurrency().getCurrencyCode()}</td>
                            <td class="numericColumn">
                                ${cashMovementService.getTotalByBankAccount(currentbankAccount).getValue()}
                            </td>
                            <td>
                                <button class = "defaultButton" type="submit" name="DellCurrent" 
                                        value="${currentbankAccount.getId()}">Удалить</button>
                                <button class = "defaultButton" type="submit" name="EditCurrent" 
                                        value="${currentbankAccount.getId()}">Редактировать</button>
                                <button class = "defaultButton" type="submit" name="OpenCashMovement" 
                                        value="${currentbankAccount.getId()}">Движения</button>
                            </td>   
                        </tr>   
                    </c:forEach>    
                </c:if>
                <tr class="tableRow">
                    <c:choose>
                        <c:when test="${sessionScope.currentAccountForEdit != null}" >
                            
                            <td>${currentAccountForEdit.getId()}</td>
                            <td><input name="name" value= "${currentAccountForEdit.getName()}" />  </td>
                            <td><input name="bankName" value= "${currentAccountForEdit.getBankName()}" />  </td>
                            <td><select name="currency" >
                                <option selected value="${currentAccountForEdit.getCurrency().getCurrencyCode()}" >
                                                        ${currentAccountForEdit.getCurrency().getCurrencyCode()}
                                            </option>
                                    <%
                                        for(Currency currency: Currency.getAvailableCurrencies()) {
                                            out.println("<option>"+currency.getCurrencyCode()+"</option>");
                                        };
                                     %>
                                </select>
                            </td>
                            <td class="numericColumn">${cashMovementService.getTotalByBankAccount(currentAccountForEdit).getValue()}</td>   
                            <td>
                                <input class = "defaultButton" type="submit" name="Edit" value="Записать изменения">
                                <input class = "defaultButton" type="submit" name="UndoEdit" value="Отменить">
                            </td>
                        </c:when>
                        <c:otherwise >
                            <td></td>
                            <td><input name="name" value ="" ></td>
                            <td><input name="bankName" value ="" ></td>
                            <td><select name="currency" >
                                <option disabled selected value="">Выберите валюту</option>
                                    <%
                                        for(Currency currency: Currency.getAvailableCurrencies()) {
                                            out.println("<option>"+currency.getCurrencyCode()+"</option>");
                                        };
                                     %>
                                </select>
                            </td>
                            <td class="numericColumn"></td>
                            <td><input class = "defaultButton" type="submit" name="AddNew" 
                                    onclick="return validateData(this);"
                                    value="Создать новый">
                            </td>
                        </c:otherwise>
                    </c:choose>
                </tr>
           </table>
        </form>
    </body>
</html>