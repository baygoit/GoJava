package site;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.SQLLoader;
import project.SQLQuotes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

 
public class Categories extends HttpServlet {
 
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
 
    	try {
		SQLLoader base = new SQLLoader();
    	
			List<String> categories = base.getCategories();
			
			 req.setAttribute("categories", categories);
	    	 req.getRequestDispatcher("Categories.jsp").forward(req, resp);
	
       } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
      
    	/**
        PrintWriter out = resp.getWriter();
        out.print("<h1>"+FirstPage.DECORATION+"</h1>");
        out.print("<h1>Categories</h1>");
        out.print("<h1>"+FirstPage.DECORATION+"</h1>");
        
        for(String type:categories){
        	out.println("<a href=\"/kickstart-0.0.1-SNAPSHOT/type"+"?"+type+"\">"+type+"</a>");
        	out.println("<br />"); 
        }
        
        out.print("<h1>"+FirstPage.DECORATION+"</h1>");
        out.print("<a href=\"/kickstart-0.0.1-SNAPSHOT/\">previous</a>");
        */
    }

}