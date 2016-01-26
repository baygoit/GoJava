<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<blockquote class="blockquote-reverse">
	<p>${quote.text}</p>
	<footer>
		<cite>${quote.author}</cite>
	</footer>
</blockquote>

<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header ">
			<a class="navbar-brand " href="./"><span
				class="glyphicon glyphicon-link"></span>Kickstarter</a>
		</div>
		<div>

			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="/kickstarter"
					class="dropdown-toggle" data-toggle="dropdown">Categories<span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<c:forEach items="${categories}" var="category">
							<li><a href=./category?id=${category.id}>${category.name}
									<c:if test="${category.totalProjects > 0}">
										<span class="badge">${category.totalProjects}</span>
									</c:if>
							</a></li>
						</c:forEach>
					</ul></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<security:authorize access="isAnonymous()">
					<li><a href="./signup"><span
							class="glyphicon glyphicon-user"></span> Sign Up</a></li>
					<li><a href="./login"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
					<li><a href="#"><span
							class="glyphicon glyphicon-user"></span> <security:authentication property="principal.username" /></a></li>
					<li><a href="./logout"><span
							class="glyphicon glyphicon-log-out"></span> Logout</a></li>
				</security:authorize>
			</ul>

		</div>

	</div>
</nav>