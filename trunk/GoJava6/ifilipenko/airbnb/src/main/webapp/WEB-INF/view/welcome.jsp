
  <head>
    <meta charset="UTF-8">
    <title>Welcome</title>
        <link rel="stylesheet" href="./css/style.css">
  </head>
  <body>
    <div class="wrapper">
	<div class="container">
	<button type="button"><a href="/login?action=logout" class="button">Log Out</a></button>
	<button type="button"><a href="/clients" class="button" >See all clients!</a></button>
	<button type="button"><a href="/home" class="button">BECOME HOST!</a></button>
		<h1>Welcome, ${user.getName()} ${user.getLastName()}</h1>
	</div>
</div>
  </body>