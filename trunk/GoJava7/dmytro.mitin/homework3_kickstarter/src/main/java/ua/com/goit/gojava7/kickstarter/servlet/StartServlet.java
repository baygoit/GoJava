package ua.com.goit.gojava7.kickstarter.servlet;

import ua.com.goit.gojava7.kickstarter.controller.Controller;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Kickstarter;
import ua.com.goit.gojava7.kickstarter.model.Quote;
import ua.com.goit.gojava7.kickstarter.model.storage.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StartServlet extends HttpServlet {

    private Controller controller;
    private CategoryStorage categoryStorage;

    @Override
    public void init() throws ServletException {
        String property = System.getProperty("a");
        QuoteStorage quoteStorage;

        if (property != null && property.equals("f")) {
            quoteStorage = new FileQuoteStorage("D:\\workspace\\goit-kickstarter\\resources\\quotes.txt");
            categoryStorage = new FileCategoryStorage("D:\\workspace\\goit-kickstarter\\resources\\categories.txt",
                    "D:\\workspace\\goit-kickstarter\\resources\\projects.txt");
        } else if (property != null && property.equals("d")) {
            quoteStorage = new DatabaseQuoteStorage("quotes");
            categoryStorage = new DatabaseCategoryStorage("categories", "projects");
        } else {
            quoteStorage = new InMemoryQuoteStorage();
            categoryStorage = new InMemoryCategoryStorage();
        }

        Kickstarter kickstarter = new Kickstarter(categoryStorage, quoteStorage);
        controller = new Controller(kickstarter);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Quote quote = controller.getRandomQuote();
        List<Category> categories =  categoryStorage.getCategories();

        request.setAttribute("quote", quote);
        ServletContext application = request.getServletContext();
        application.setAttribute("categories", categories);
        application.setAttribute("controller", controller);

        request.getRequestDispatcher("start.jsp").forward(request, response);
    }
}
