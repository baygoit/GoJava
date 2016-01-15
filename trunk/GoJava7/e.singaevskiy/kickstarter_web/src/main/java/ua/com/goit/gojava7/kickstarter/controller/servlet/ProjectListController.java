package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDAO;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDAO;
import ua.com.goit.gojava7.kickstarter.domain.Project;

@WebServlet("/category1")
public class ProjectListController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Autowired
    private ProjectDAO projectDAO;
    @Autowired
    private PaymentDAO paymentDAO;
    @Autowired
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
    	SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

}
