package ua.com.goit.gojava.andriidnikitin.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava.andriidnikitin.model.GoodType;
import ua.com.goit.gojava.andriidnikitin.service.GoodCatalogImpl;

public class CategoryPrinter extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
    public CategoryPrinter() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out = response.getWriter();   
    	out.println("<head><link href=\"css/navbar.css\" rel=\"stylesheet\" type=\"text/css\"/></head>");
    	out.println("<table>\n");
    	out.println("<ul id=\"navbar\">\n");
	   	GoodCatalogImpl catalog = GoodCatalogImpl.getInstance();
	   	List<GoodType> list = catalog.getGoodTypesFromRoot();
	   	for (GoodType type: list) { //TODO: redo - returns XML with data; JS builds table  	
	   		String name =  type.getName();
	   		out.println("    <li><a href=\"/url?param=\"" + name + "\">" + name + "</a></li>\n");	
	   	}   
	   	out.println("</ul>\n");  
    	out.println("</table>\n");
     }
 }