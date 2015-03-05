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
	function getTypes(parent, destination){		
		var container = document.getElementById('hidden-part', destination);
		var content= "<form ";
		content+=" id=\"hidden-form\"";
		content+=" action=\"show-catalog\"";
		content+=" method=\"post\">";
		content+=" <input type=\"submit\">";
		content+=" <input type='text' name='parent' value='" + parent + "'>"; 
		content+=" <input type='hidden' name='destination' value='" + destination + "'>"; 
		content+=" </form>";	
		container.innerHTML = content;				
		var form = document.getElementById('hidden-form');	
		form.parent = parent;
		form.submit();
		container.innerHTML=" ";
	}
	
	function getDescription(good, destination){		
		var container = document.getElementById('hidden-part');
		var content= "<form ";
		content+=" id=\"hidden-form\"";
		content+=" action=\"act-good\"";
		content+=" method=\"post\">";
		content+=" <input type=\"submit\">";
		content+=" <input type=\"hidden\" name=\"action\" value=\"retrieve\">"; 
		content+=" <input type='hidden' name='destination' value='" + destination + "'>"; 
		content+=" <input type='text' name='good' value='" + good + "'>"; 
		content+=" </form>";	
		container.innerHTML = content;				
		var form = document.getElementById('hidden-form');	
		form.parent = parent;
		form.submit();
		container.innerHTML=" ";
	}
</script>
<title>Catalog</title>
</head>
<body>
	<h2>Catalog</h2>
		<p>
			<span onclick="getTypes('root', 'catalog.jsp')">top</span>
		</p>	
		<ul>
		<%
		session = request.getSession();
		List<GoodType> types = (List<GoodType>)session.getAttribute("types");
		List<Good> goods = (List<Good>)session.getAttribute("goods");	
				
		if (types != null){
			for (GoodType type:  types){
				out.println("<li>");	
				out.println("<form action=\"act-type\" method=\"post\">");
				String name =  type.getName();
				out.println("<span onclick=\"getTypes('" + name + "', 'catalog.jsp')\">" + name + "</span>");
				out.println("<input type=\"hidden\" name=\"type\" value=\"" + type.getId() + "\">");
				out.println("<input type=\"submit\" name=\"action\" value=\"update\">");
				out.println("<input type=\"hidden\" name=\"step\" value=\"pre\">");				
				out.println("<input type=\"submit\" name=\"action\" value=\"delete\">");	
				out.println("</form>");	
				out.println("</li>");
			}
			
		}
		if (goods != null){
			if (goods.isEmpty()){
				out.println("<li> empty </li>");
			}
			for (Good good:  goods){
				String name = good.getName();
				out.println("<li name=\"" + name + "\" onclick=\"getDescription('" + name + "', 'good_view.jsp')\">");					
				out.println("<form action=\"act-good\" method=\"post\">" + name);				
				out.println("<input type=\"hidden\" name=\"good\" value=\"" + good.getId() + "\">");
				out.println("<input type=\"hidden\" name=\"step\" value=\"pre\">");
				out.println("<input type=\"submit\" name=\"action\" value=\"update\">");	
				out.println("<input type=\"submit\" name=\"action\" value=\"delete\">");	
				out.println("</form>");	
				out.println("</li>");
			}
		}
		%>
		</ul>
	<div id="hidden-part">
	</div>	<a href="index.html">Back</a>
</body>
</html>