<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<blockquote class="blockquote-reverse">
	<p>${quote.text}</p>
	<footer>
		<cite>${quote.author}</cite>
	</footer>
</blockquote>

<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header ">
			<a class="navbar-brand " href="./"><span class="glyphicon glyphicon-link"></span>Kickstarter</a>
		</div>
		<div>
			<ul class="nav navbar-nav	">
				<c:forEach var="category" items="${categories}">
					<li><a href=./category?id=${category.id}>${category.name}</a></li>
				</c:forEach>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-user"></span>
						Sign Up</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
						Login</a></li>
			</ul>
		</div>
	</div>
</nav>