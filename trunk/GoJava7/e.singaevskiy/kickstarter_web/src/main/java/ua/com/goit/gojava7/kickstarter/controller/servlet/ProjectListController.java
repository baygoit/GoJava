package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.controller.servlet.util.HtmlPageWriter;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDAO;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDAO;
import ua.com.goit.gojava7.kickstarter.dao.StorageFactory;
import ua.com.goit.gojava7.kickstarter.domain.Project;

@WebServlet("/category")
public class ProjectListController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProjectDAO projectDAO;
    private PaymentDAO paymentDAO;
    private CategoryDAO categoryDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int categoryId = Integer.parseInt(request.getParameter("id"));

        StringBuilder body = new StringBuilder();
        List<Project> foundProjects = projectDAO.getByCategory(categoryId);
        for (int i = 0; i < foundProjects.size();) {
            Project project = foundProjects.get(i++);
            project.setBalanceSum(paymentDAO.getSum(project.getId()));
            
            body.append(String.format("<a href=./project?id=%s>%s</a>",
                    project.getId(),
                    "\n" + i + ". " + project));
            body.append("\n" + "Goal: " + project.getGoalSum() + "; Balance: " + project.getBalanceSum()
                    + "; Days left: " + project.daysLeft() + "\n");
        }

        HtmlPageWriter htmlPageWriter = new HtmlPageWriter();
        htmlPageWriter.setTitle(categoryDAO.get(categoryId).getName());
        htmlPageWriter.setBody(body.toString());

        response.getWriter().print(htmlPageWriter.prepare());
    }

    @Override
    public void init() throws ServletException {
    	StorageFactory factory = (StorageFactory) getServletContext().getAttribute(ContextInitializer.STORAGE_FACTORY);        
        projectDAO = factory.getProjectDAO();
        paymentDAO = factory.getPaymentDAO();
        categoryDAO = factory.getCategoryDAO();

    }

}
