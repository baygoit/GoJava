package site;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.SQLQuotes;

import java.io.IOException;
import java.io.PrintWriter;

 
public class FirstPage extends HttpServlet {
 
	static final String DECORATION = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
 
    	SQLQuotes baseOfQuotes = new SQLQuotes();
    	String quote = baseOfQuotes.showQuote();
    	
        PrintWriter out = resp.getWriter();
        out.print("<h1>"+DECORATION+"</h1>");
        out.print("<h1>"+quote+"</h1>");
        out.print("<h1>"+DECORATION+"</h1>");
        
        out.print("<a href=\"/kickstart-0.0.1-SNAPSHOT/categories\">Go!</a>");
        
        
        
      
 
    }

}