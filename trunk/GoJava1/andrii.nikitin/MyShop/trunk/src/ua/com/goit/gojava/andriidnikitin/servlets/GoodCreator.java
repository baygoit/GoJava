package ua.com.goit.gojava.andriidnikitin.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava.andriidnikitin.model.Good;
import ua.com.goit.gojava.andriidnikitin.service.GoodCatalog;
import ua.com.goit.gojava.andriidnikitin.service.GoodCatalogImpl;

public class GoodCreator extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
    public GoodCreator() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {/*
    	PrintWriter out = response.getWriter();   
    	printCategories(null, out, GoodCatalogImpl.getInstance(), request);*/
     }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	PrintWriter out = response.getWriter();   
    	Map<String, String[]> map = request.getParameterMap();   
    	if (!map.isEmpty()) {   
    		List<String> names = new ArrayList<String>();
	    	Set<Entry<String, String[]>> set = map.entrySet();
	    	for (Entry<String, String[]> attribute: set){
	    		String[] array = attribute.getValue();
	    		names.add(array[0]);
	    	}    	
    		GoodCatalogImpl catalog = GoodCatalogImpl.getInstance(); 
    	   	addGood(catalog.factoryGood(names.get(0), names.get(1)), out, catalog, request);	
    	}
    	else {
    		out.println("<p> no parameters recieved </p>");
    	}
    	   	
    } 
    private void addGood(Good element, PrintWriter out, GoodCatalog catalog,
    		HttpServletRequest request){
    	if (element.getType() == null) {
    		out.println("<p> fail to add - such type does not exist! </p>");
    	}
    	else {
    		if (!catalog.addGood(element)) {
        		out.println("<p> fail to add </p>");
        	}
        	
        	else {
        		out.println("<p> done </p>");
        	}  
    	}
    	  	
    	
    	/*
    	if (catalog.hasChildren(root)){
	    	//out.println("<head><link href=\"css/navbar.css\" rel=\"stylesheet\" type=\"text/css\"/></head>");
	    	out.println("<table>\n<form action=\"" + request.getContextPath() + "/print-categories\"" + 
	    			" method=\"post\">");
	    	out.println("<ul id=\"navbar\">\n");
		   	List<GoodType> list = catalog.getChildren(root);
		   	for (GoodType type: list) { //TODO: redo - returns XML with data; JS builds table  	
		   		String name =  type.getName();
		   		Integer id = type.getId();
		   		out.println("    <li><input type=\"submit\"  name=\"" + id + "\" value=\"" + name + "\">");
		   	}   
		   	out.println("</ul>\n");  		   
	    	out.println("</form></table>\n");
    	}
    	else {
    		String radiobutton = "<input type=\"radio\" name=\"radio-good\" value=\"";
    		out.println("<table><ul>");
    	   	for (Good good: catalog.getGoodsInType(root)){  
    	   		String name = good.getName();  
    	   		out.println("<li>" + name + radiobutton + name + "\"></li>" );    	   		
    	   	}
    		out.println("<input type=\"submit\">");
    	   	out.println("</ul></table>");
    		
    	}*/
    }	
   
 }