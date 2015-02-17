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
    	out.println("<table>");
    	out.println("<ul>");
	   	GoodCatalogImpl catalog = GoodCatalogImpl.getInstance();
	   	List<GoodType> list = catalog.getGoodTypesFromRoot();
	   	for (GoodType type: list) { //TODO: redo - returns XML with data; JS builds table  	
	   		out.println("<li>\n");
	   		String name =  type.getName();
	   		out.println("<form action=\"print-goods\" method=\"post\" target=\"category-frame\">");
	   		out.println("<input type=\"submit\" value=\"" + name + "\" ></input>\n");	
	   		out.println("</form>");
	   		out.println("</li>\n");
	   	}   
	   	out.println("</ul>\n"); 
    	out.println("</table>\n"); 	
     }
 }