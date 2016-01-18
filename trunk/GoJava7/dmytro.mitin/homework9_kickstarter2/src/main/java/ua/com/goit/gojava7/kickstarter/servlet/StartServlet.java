package ua.com.goit.gojava7.kickstarter.servlet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.com.goit.gojava7.kickstarter.controller.Controller;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Quote;
import ua.com.goit.gojava7.kickstarter.model.storage.CategoryStorage;

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

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        controller = context.getBean("controller", Controller.class);
        categoryStorage = context.getBean("categoryStorage", CategoryStorage.class);
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
