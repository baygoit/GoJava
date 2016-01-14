<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <title>
		<c:if test="${not empty param.title}">${param.title}</c:if>
		<c:if test="${empty param.title}">Default title</c:if>
	</title>
    
    <!-- Bootstrap Core CSS -->
    <link href="  https://drive.google.com/uc?export=download&confirm=no_antivirus&id=0B2I6VTKFP4LhYjRFa1Z5SzBybWs" rel="stylesheet">
       
    <!-- Custom CSS -->
    <link href="https://drive.google.com/uc?export=download&confirm=no_antivirus&id=0B2I6VTKFP4LhOU82eWE5T1gzemc" rel="stylesheet">
   
    <!-- Fonts -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
	
	<!-- jQuery -->
    <script src="https://drive.google.com/uc?export=download&confirm=no_antivirus&id=0B2I6VTKFP4LhU1FCcUFQUlU3UWs"></script>

    <!-- Bootstrap Core JavaScript -->
	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	

</head>

<body>

<div class="brand">My Kickstarter</div>
    <div class="address-bar">Anton Smirnov | Kiev, Ukraine 	02068 | +38(063)109-38-08</div>

    <!-- Navigation -->
    <nav class="navbar navbar-default">
        <div class="container">
            
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                
                <!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
                <a class="navbar-brand" href="/kickstarter/">Kickstarter</a>
         
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="/kickstarter">Home</a>
                    </li>
                    
                    <li class="dropdown active">
						<a href="/kickstarter" class="dropdown-toggle" data-toggle="dropdown">Categories<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<c:forEach items="${categories}" var="category">
								<li><a href="/kickstarter/category?id=${category.id}"><c:out value="${category.getName()}"/></a></li>
							</c:forEach>
						</ul>
                    </li>
                    <li>
                        <a href="/kickstarter/top10">Top 10 categories</a>
                    </li>
                    <li>
                        <a href="contact.html">Contact</a>
                    </li>
                </ul>
            </div>
          
            <!-- /.navbar-collapse -->
        </div>
        
        <!-- /.container -->
    </nav>