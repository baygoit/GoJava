<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>Kickstarter categories</title>
		<meta name="generator" content="Bootply" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link href="./css/bootstrap.min.css" rel="stylesheet" type="text/css">
		<link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.min.css" rel="stylesheet" type="text/css">
		<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<link href="./css/styles.css" rel="stylesheet" type="text/css">
	</head>
	<body>
<header class="navbar navbar-bright navbar-fixed-top" role="banner">
  <div class="container">
    <div class="navbar-header">
      <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>
    <nav class="collapse navbar-collapse" role="navigation">
      <ul class="nav navbar-nav">
        <li>
          <a href="http://localhost:8080/categories" class="navbar-brand">Home</a>
        </li>
        <li>
          <a href="#">Category</a>
        </li>
        <li>
          <a href="#">Category</a>
        </li>
        <li>
          <a href="#">Category</a>
        </li>
        <li>
          <a href="#">About</a>
        </li>
      </ul>
      <ul class="nav navbar-right navbar-nav">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-search"></i></a>
          <ul class="dropdown-menu" style="padding:12px;">
            <form class="form-inline">
              <button type="submit" class="btn btn-default pull-right"><i class="glyphicon glyphicon-search"></i></button><input type="text" class="form-control pull-left" placeholder="Search">
            </form>
          </ul>
        </li>
      </ul>
    </nav>
  </div>
</header>

<div id="masthead">  
  <div class="container">
    <div class="row">
      <div class="col-md-7">
        <h1>Kickstarter
          <p class="lead"></p>
        </h1>
      </div>
      <div class="col-md-5 sasha-logo">
       </div>
    </div> 
  </div><!-- /cont -->
  
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <!-- <div class="top-spacer"> </div> -->
      </div>
    </div> 
  </div><!-- /cont -->
  
</div>


<div class="container">
  <div class="row">
    
    <div class="col-md-12"> 
      
      <div class="panel">
        <div class="panel-body">
        <h2><c:out value="${quote.quote}"/></h2>
          
          
          
          <!--/stories-->
          <c:forEach items="${categories}" var="category"> 
          <div class="row">    
            <br>
            <div class="col-md-2 col-sm-3 text-center">
              <a class="story-title" href="/projects?category=${category.id}"><img alt="" src="https://www.kickstarter.com/download/kickstarter-badge-funded.png" style="width:100px;height:100px" class="img-circle"></a>
            </div>
            <div class="col-md-10 col-sm-9">
              <a href="/projects?category=${category.id}"><h3><c:out value="${category.name}"/></h3></a>
              <div class="row">
                <div class="col-xs-9">
                  <h4>More info about categories </h4><h4>
                  <small style="font-family:courier,'new courier';" class="text-muted">Date last update - <a href="theme_1.html" class="text-muted">Read More</a></small>
                  </h4></div>
                <div class="col-xs-3"></div>
              </div>
              <br><br>
            </div>
          </div>
          <hr>
          </c:forEach>
          
          <!--/stories-->
          
        </div>
      </div>
                                                                                       
	                                                
                                                      
   	</div><!--/col-12-->
  </div>
</div>
                                                
                                                                                
<!-- <hr> -->

<div class="container" id="footer">
  <div class="row">
    <div class="col col-sm-12">
      
      <h1>Follow Us</h1>
      <div class="btn-group">
       <a class="btn btn-twitter btn-lg" href="#"><i class="icon-twitter icon-large"></i> Twitter</a>
	   <a class="btn btn-facebook btn-lg" href="#"><i class="icon-facebook icon-large"></i> Facebook</a>
	   <a class="btn btn-google-plus btn-lg" href="#"><i class="icon-google-plus icon-large"></i> Google+</a>
      </div>
      
    </div>
  </div>
</div>

<!-- <hr> -->

<!-- <hr> -->

<footer>
  <div class="container">
    <div class="row">
      <div class="col-sm-6">
          <h3 class="pull-center foot">&copy; Deuces Inc. 2014. All Rights Reserved.</a></p>      
      </div>
    </div>
  </div>
</footer>
	<!-- script references -->
		<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>
