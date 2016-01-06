<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
		
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.css">
		<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
		<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		
		<title>
			<c:if test="${not empty param.title}">${param.title}</c:if>
			<c:if test="${empty param.title}">Default title</c:if>
		</title>
	</head>
	<body>
	
	<div class="navbar navbar-inverse navbar-static-top ">
            <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#responsive-menu">
                            <span class="sr-only">Open navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="/kickstarter/">Kickstarter</a> 
                    </div>                    
                    <div class="collapse navbar-collapse" id="responsive-menu">
                        <ul class="nav navbar-nav">
                            <li class="dropdown">
                                <a href="/kickstarter/" class="dropdown-toggle" data-toggle="dropdown">Categories<b class="caret"></b></a>
                                <ul class="dropdown-menu">
	                                <c:forEach items="${categories}" var="category">
										<li><a href="/kickstarter/category?id=${category.id}"><c:out value="${category.getName()}"/></a></li>
									</c:forEach>
                                </ul>
                            </li>
                            <li><a href="/kickstarter/top10">Top 10</a></li>
                        </ul>
                    </div>  
            </div>
        </div>
	
	
	