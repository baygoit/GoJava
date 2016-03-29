package ua.nenya.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import ua.nenya.dao.QuoteDao;
import ua.nenya.main.DaoInitilizer;
import ua.nenya.project.Quote;

//@WebServlet("/quote")
public class QuoteServlet extends CommonServlet{
	private static final long serialVersionUID = 1L;
       
    
    public QuoteServlet() {
    }

//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
//        ServletContext servletContext = config.getServletContext();
//        servletContext.getRealPath("/");
//    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		initDao();
		showQuote(printWriter, initilizer);
		printWriter.println("<p><a href=\"category\">Let's go to the categories!</a></p>");
	}


	private void showQuote(PrintWriter printWriter, DaoInitilizer initilizer) {
		QuoteDao quoteDao = initilizer.getQuoteDao();
		Quote quote = quoteDao.getRandomQuote(new Random());
		printWriter.println("<p><h3>"+quote.getName()+"</h3></p>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
