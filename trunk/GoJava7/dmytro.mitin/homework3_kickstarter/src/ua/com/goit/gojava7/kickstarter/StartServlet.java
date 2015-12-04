package ua.com.goit.gojava7.kickstarter;

import ua.com.goit.gojava7.kickstarter.controller.Controller;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Kickstarter;
import ua.com.goit.gojava7.kickstarter.model.Quote;
import ua.com.goit.gojava7.kickstarter.model.storage.InMemoryCategoryStorage;
import ua.com.goit.gojava7.kickstarter.model.storage.InMemoryQuoteStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class StartServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Controller controller = new Controller(new Kickstarter(new InMemoryCategoryStorage(), new InMemoryQuoteStorage()));
        Quote quote = controller.getRandomQuote();
        PrintWriter out = response.getWriter();
        out.println("<html>\n" +
                "  <head>\n" +
                "    <title>Kickstarter</title>\n" +
                "  </head>\n" +
                "  <body>\n" +
                quote.getText() + " (" + quote.getAuthor() + ")\n" +
                "  <h3>Categories</h3>");

        out.println();
        List<Category> categories = controller.getKickstarter().getCategoryStorage().getCategories();
        for (int i = 0; i < categories.size(); i++) {
            out.println("<a href=\"category?id=" + i + "\">"
                    + categories.get(i).getName() + "</a><br />");
        }
        out.println("  </body>\n" +
                "</html>");
    }


}
