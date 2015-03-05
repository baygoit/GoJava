<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/stylesheet1.css" rel="stylesheet" type="text/css" />
<!-- script >	function init(){		
		document.getElementsByName("form").innerHTML = ""; 
	}
</script-->
<title>MyShop</title>
</head>
<body onload="init('welcome.html', 'main-frame')">
	<h2> Welcome </h2>
		
	<div> 
			<table id="topside" border="3">
				<tr>
					<td><a href="pages/welcome.html" target="main-frame"> Home </a></td>
					<td><a href="pages/content.html" target="main-frame"> Catalog </a></td>
					<td><a href="pages/construct.html" target="main-frame"> About </a></td>
				</tr>
			</table>
	</div>			

	<div> 
		<p>
			<iframe name="main-frame" height="400" width="400"> </iframe>
		</p>
	</div>
	
	<table>
		<tr>
			<td><a href="pages/construct.html" target="main-frame"> Contacts </a>
			</td>
			<td><a href="pages/construct.html" target="main-frame"> Gallery </a>
			</td>
			<td><a href="pages/unicorns_page.html" target="main-frame"> Unicorns </a>
			</td>
			<td><a href="editor_page.jsp"> Editing </a>
			</td>
		</tr>
	</table>
	
	<p id="paragraph"> </p>

</body>
</html>