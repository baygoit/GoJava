package ua.com.goit.gojava7.kickstarter;

import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.storage.InMemoryCategoryStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//        String query = request.getQueryString();
//        out.println(query);
//        int categoryId = Integer.parseInt(query.substring(query.indexOf("=") + 1, query.length()));
        int categoryId = Integer.parseInt(request.getParameter("id"));
        Category category = new InMemoryCategoryStorage().getCategories().get(categoryId);
        PrintWriter out = response.getWriter();
        out.println("<html>\n" +
                "<head>\n" +
                "    <title>Category: " + category.getName() + "</title>\n" +
                "</head>\n" +
                "<body>");
        out.println("<h3>Category: " + category.getName() + "</h3>");
        out.println("Projects:<br /><br />");
        for (Project project : category.getProjects()) {
            out.println("Project: " + project.getName() + "<br />");
            out.println("Description: " + project.getShortDescription() + "<br />");
            out.println("Money needed: $" + project.getMoneyNeeded() + "<br />");
            out.println("Money donated: $" + project.getMoneyDonated() + "<br />");
            out.println("Days left: " + project.getDaysLeft() + "<br /><br />");
        }
        out.print("</body>\n" +
                "</html>");
    }
}
