package ua.com.goit.gojava.andriidnikitin.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava.andriidnikitin.model.GoodType;
import ua.com.goit.gojava.andriidnikitin.service.GoodCatalog;
import ua.com.goit.gojava.andriidnikitin.service.GoodCatalogImpl;

public class CatalogViewer extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
    public CatalogViewer() {
    	
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	PrintWriter out = response.getWriter(); 
    	GoodCatalogImpl catalog = GoodCatalogImpl.getInstance(); 
    	List<GoodType> types = catalog.getLeaves(); 
    	out.println("<table>\n<ul>"); 
    	for (GoodType type: types){
    		String name = type.getName(); 
    		out.println("<li>" + name + "</li>"); 
    	}    	 
    	out.println("</table>");     	   	
    } 
}