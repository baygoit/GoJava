package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDAO;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre.CategoryPostgreDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre.PaymentPostgreDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre.ProjectPostgreDAO;
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

        List<Project> foundProjects = projectDAO.getByCategory(categoryId);
        foundProjects.forEach(project -> project.setBalanceSum(paymentDAO.getSum(project.getId())));

        request.setAttribute("category", categoryDAO.get(categoryId));
        request.setAttribute("projects", foundProjects);
        request.getRequestDispatcher("view/ProjectList.jsp").forward(request, response);
    }

    @Override
    public void init() throws ServletException {
    	WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        categoryDAO = context.getBean(CategoryPostgreDAO.class);
        projectDAO = context.getBean(ProjectPostgreDAO.class);
        paymentDAO = context.getBean(PaymentPostgreDAO.class);
    }

}
