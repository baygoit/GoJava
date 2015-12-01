package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.controller.servlet.util.HtmlPageWriter;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.DataType;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDAO;
import ua.com.goit.gojava7.kickstarter.dao.StorageFactory;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

@WebServlet("/categories")
public class CategoryList extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private QuoteDAO quoteDAO;
    private CategoryDAO categoryDAO; 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Random rnd = new Random();       
        List<Quote> quotes = quoteDAO.getAll();
        Quote quote = quotes.get(rnd.nextInt(quotes.size()));
        
        List<Category> categories = categoryDAO.getAll();
        
        StringBuilder body = new StringBuilder();
        body.append("\"" + quote.getText() + "\" - " + quote.getAuthor() + "\n");       
        body.append("\nCategories: | ");
        for (int i = 1; i <= categories.size(); i++) {
            Category category = categories.get(i - 1);
            body.append(String.format("<a href=./category?id=%s>%s</a>", 
                    category.getId(),
                    i + ". " + category.getName()) + " | " );
        }
        body.append("\n");
        
        HtmlPageWriter htmlPageWriter = new HtmlPageWriter();
        htmlPageWriter.setTitle("Categories");
        htmlPageWriter.setBody(body.toString());

        response.getWriter().print(htmlPageWriter.prepare());
    }

    @Override
    public void init() throws ServletException {
        super.init();
        
        StorageFactory factory = new StorageFactory(DataType.POSTGRE, 
                getClass().getClassLoader().getResourceAsStream("config.properties"));
        
        quoteDAO = factory.getQuoteDAO();
        categoryDAO = factory.getCategoryDAO();

    }

}
