<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="ua.com.goit.gojava.andriidnikitin.model.*,
			ua.com.goit.gojava.andriidnikitin.model.util.*,
			ua.com.goit.gojava.andriidnikitin.service.*,
			java.util.Enumeration,
			ua.com.goit.gojava.andriidnikitin.servlets.*,
			java.util.List"
				
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/stylesheet1.css" rel="stylesheet" type="text/css" />
<script>
	function edit(unit, operation, destination){		
		var container = document.getElementById('hidden-part');
		var content= "<form ";
		content+=" id=\"hidden-form\"";
		content+=" action=\"show-catalog\"";
		content+=" method=\"post\">";
		content+=" <input type=\"submit\">";
		content+=" <input type='hidden' name='unit' value='" + unit + "'>"; 
		content+=" <input type='hidden' name='operation' value='" + operation + "'>"; 
		content+=" <input type='hidden' name='destination' value='" + destination + "'>"; 
		content+=" </form>";	
		container.innerHTML = content;				
		var form = document.getElementById('hidden-form');	
		form.parent = parent;
		form.submit();
		container.innerHTML=" ";
	}	
	
</script>
<title>Good info</title>
</head>
<body>
	<h2>Good Info</h2>
		<ul>
		<%
		session = request.getSession();
		List<Good> goods = (List<Good>)session.getAttribute("goods");
		if (goods != null){
			for (Good good:  goods){
				out.println("<li>");	
				out.println("<form action=\"act-good\" method=\"post\">");
				out.println(good.getName());
				out.println("<input type=\"hidden\" name=\"good\" value=\"" + good.getId() + "\">");
				out.println("</form>");	
				out.println("</li>");
			}
		}
		else {
			String name = (String)session.getAttribute("name");
			int id = (Integer)session.getAttribute("id");		
			List<Attribute> description = (List<Attribute>)session.getAttribute("description");		
			out.println("<p id = \"attributes\">");
			out.println("<b>Name: </b>" + name + "\n");
			out.println("<b>ID: </b>" + id + "\n");
			out.println("</p>");		
			out.println("<p id = \"description\">");
			for (Attribute attr : description ){
				out.println("<b>" + attr.getName() + ": </b>" + attr.getValue() + "\n");
			}
			out.println("</p>");
		}
			
		%>
		</ul>
	<div id="hidden-part">	
	</div>
	<a href="catalog.jsp">Back</a>
</body>
</html>