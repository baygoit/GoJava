<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<title>Kickstarter</title>

<body>
<h2><c:out value="${model.name}"/></h2>
<c:out value="${model.shortDescription}"/>
<br>
Goal: <c:out value="${model.goal}"/>
<br>
Balance: <c:out value="${model.balance}"/>
<br>
Time left: <c:out value="${model.timeLeft}"/>
<br>
Demo link: <c:out value="${model.demoLink}"/>

<ol>FAQ:
    <c:forEach items="${model.faqs}" var="faq">
        <li>
            Q: <c:out value="${faq.question}"/>
            <br>
            A: <c:out value="${faq.answer}"/>
        </li>
    </c:forEach>
</ol>

<ol>Events:
    <c:forEach items="${model.projectEvents}" var="event">
        <li>
            <c:out value="${event.eventDate}"/>: <c:out value="${event.message}"/>
        </li>
    </c:forEach>
</ol>

<ol>Rewards:
    <c:forEach items="${model.rewards}" var="reward">
        <li>
            <c:out value="${reward.amount}"/>: <c:out value="${reward.description}"/>
        </li>
    </c:forEach>
</ol>

</body>
</html>
