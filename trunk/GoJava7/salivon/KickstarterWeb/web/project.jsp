<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="WEB-INF/jspf/header.jspf" %>
<section id="category">
    <h2>${requestScope.project.title}</h2>
    Description: ${requestScope.project.description}<br>
    Total ${requestScope.project.total}$<br>
    Collected amount ${requestScope.project.collectedAmount}$<br>
    Number of days to end ${requestScope.project.getNumberOfDaysToEnd()}<br>
    History ${requestScope.project.historyProject}<br>
    Link ${requestScope.project.link}<br>
    FAQ ${requestScope.project.faq}<br>
    <form action="faq" method="post">
        <p>Enter your questions:</p>
        <textarea name="faq" rows="10" cols="60" >
        </textarea><br>
        <input type="hidden" name="id" value="${requestScope.project.id}" />
        <input type="submit" value="Question" />
    </form>
    <div> <a href="payment.jsp">Make a contribution</a></div>
</section>
<%@include file="WEB-INF/jspf/footer.jspf" %>
