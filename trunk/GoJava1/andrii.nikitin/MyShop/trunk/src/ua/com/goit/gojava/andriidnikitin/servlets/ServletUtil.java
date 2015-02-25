package ua.com.goit.gojava.andriidnikitin.servlets;

import java.io.PrintWriter;
import java.util.List;

import ua.com.goit.gojava.andriidnikitin.model.Good;
import ua.com.goit.gojava.andriidnikitin.model.GoodType;
import ua.com.goit.gojava.andriidnikitin.service.GoodCatalog;

public class ServletUtil {
	
	public static void printCatalog(GoodType root, PrintWriter out, GoodCatalog catalog,
    		String contextPath){
    	if (catalog.hasChildren(root)){
	    	//out.println("<head><link href=\"css/navbar.css\" rel=\"stylesheet\" type=\"text/css\"/></head>");
	    	out.println("<table>\n<form action=\"" + contextPath + "/print-categories\"" + 
	    			" method=\"post\">");
	    	out.println("<ul id=\"navbar\">\n");
		   	List<GoodType> list = catalog.getChildren(root);
		   	for (GoodType type: list) { //TODO: redo - returns XML with data; JS builds table  	
		   		String name =  type.getName();
		   		Integer id = type.getId();
		   		out.println("    <li><input type=\"submit\"  name=\"" + id +
		   				"\" value=\"" + name + "\">");
		   	}   
		   	out.println("</ul>\n");  		   
	    	out.println("</form></table>\n");
    	}
    	else {
    		String radiobutton = "<input type=\"radio\" name=\"radio-good\" value=\"" ;
    		out.println("<table><ul>");
    	   	for (Good good: catalog.getGoodsInType(root)){  
    	   		String name = good.getName();  
    	   		out.println("<li>" + name + radiobutton + name + "\"></li>" );    	   		
    	   	}
    		out.println("<input type=\"submit\">");
    	   	out.println("</ul></table>");
    		
    	}
    }	
   

}
