<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
  <head>
    <link href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css" rel="stylesheet">
    <link rel="stylesheet" href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/bootstrap.css">
    <link rel="stylesheet" href="/css/indexStyle.css">
    <title>AirBnB</title>
  </head>
  <body>

    <div class="jumbotron">
    <div class="nav">
          <div class="containerNav">
            <ul class="pull-left">
              <li><a href="#">Name</a></li>
              <li><a href="#">Browse</a></li>
            </ul>
            <ul class = "pull-right">
              <li id="signup"><a href="/registration">Sign Up</a></li>
              <li id="login"><a href="/login">Log In</a></li>
              <li id="help"><a href="#">Help</a></li>
            </ul>
          </div>
        </div>
      <div class="container">
        <div class="image">

        </div>
        <form action="/" method="get">
            <h1>WELCOME HOME${name}</h1>
            <p>Rent from people in over 34,000 cities and 192 countries.</p>
        </form>
      </div>
    </div>
    <div class="neighborhood-guides">
        <div class="container">
            <h2>Neighborhood Guides</h2>
            <p>Not sure where to stay? We've created neighborhood cuides for cities all around the world</p>
            <div class="row">
                <div class="col-md-4">
                <div class="thumbnail">
                    <a href=""><img src="http://goo.gl/0sX3jq"></a>
                </div>
                <div class="thumbnail">
                    <img src="http://goo.gl/an2HXY">
                </div>
                </div>
                <div class="col-md-4">
                <div class="thumbnail">
                    <img src="http://goo.gl/Av1pac">
                </div>
                <div class="thumbnail">
                    <img src="http://goo.gl/vw43v1">
                </div>
                </div>
                <div class="col-md-4">
                    <div class="thumbnail">
                        <img src="http://goo.gl/0Kd7UO">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="learn-more">
	  <div class="container">
		<div class="row">
	      <div class="col-md-4">
			<h3>Travel</h3>
			<p>From apartments and rooms to treehouses and boats: stay in unique spaces in 192 countries.</p>
			<p><a href="#">See how to travel on Airbnb</a></p>
	      </div>
		  <div class="col-md-4">
			<h3>Host</h3>
			<p>Renting out your unused space could pay your bills or fund your next vacation.</p>
			<p><a href="#">Learn more about hosting</a></p>
		  </div>
		  <div class="col-md-4">
			<h3>Trust and Safety</h3>
			<p>From Verified ID to our worldwide customer support team, we've got your back.</p>
			<p><a href="#">Learn about trust at Airbnb</a></p>
		  </div>
	    </div>
	  </div>
	</div>
  </body>
</html>