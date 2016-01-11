package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kickstarter.dao.db.CategoryDatabaseDao;
import ua.com.goit.gojava7.kickstarter.dao.db.ProjectDatabaseDao;
import ua.com.goit.gojava7.kickstarter.dao.db.QuestionDatabaseDao;
import ua.com.goit.gojava7.kickstarter.dao.db.QuoteDatabaseDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Question;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

/**
 * Servlet implementation class MainServlet
 */

public class MainServlet extends HttpServlet{
    private static final long   serialVersionUID = 1L;
    private static final Logger logger           = LogManager.getLogger(MainServlet.class);
    @Autowired
    private CategoryDatabaseDao categoryStorage;
    @Autowired
    private ProjectDatabaseDao  projectStorage;
    @Autowired
    private QuoteDatabaseDao    quoteStorage;
    @Autowired
    private QuestionDatabaseDao questionStorage;

    @Override
    public void init(ServletConfig config) throws ServletException {
        logger.log(Level.INFO, "Start autowire.");
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
        logger.log(Level.INFO, "End Spring autowire.");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = getAction(request);
        Quote quote = quoteStorage.getRandomQuote();
        request.setAttribute("quote", quote);

        if (action.startsWith("/categories")) { // All categories
            logger.log(Level.DEBUG, "action: categories");
            List<Category> categories = categoryStorage.getAll();

            request.setAttribute("categories", categories);
            request.getRequestDispatcher("/WEB-INF/jsp/categories.jsp").forward(request, response);

        } else if (action.startsWith("/category")) { // All projects in specific
                                                     // category
            logger.log(Level.DEBUG, "action: category");
            int categoryId = Integer.parseInt(request.getParameter("id"));
            List<Project> projects = projectStorage.getProjectsByCategoryId(categoryId);
            request.setAttribute("projects", projects);
            request.setAttribute("categoryName", categoryStorage.getCategoryById(categoryId).getCategoryName());
            request.getRequestDispatcher("/WEB-INF/jsp/projects.jsp").forward(request, response);
        } else if (action.startsWith("/project")) {
            logger.log(Level.DEBUG, "action: project");
            String projectName = request.getParameter("name");
            Project project = null;
            try {
                project = projectStorage.getProjectByName(projectName);
            } catch (NoSuchElementException e) {
                logger.info("Didn't find project", e);
            }
            if (project != null) {
                request.setAttribute("project", project);
                request.setAttribute("endtime", project.getProjectEndTime());
              
                request.setAttribute("paymentBonuses", project.getBonuses());
                List<Question> questions = questionStorage.getQuestionsByProjectId(project.getId());
                request.setAttribute("questions", questions);
            } else {
                request.setAttribute("notfound", true);
            }
            request.getRequestDispatcher("/WEB-INF/jsp/project.jsp").forward(request, response);
        } else if (action.startsWith("/projects")) {
            logger.log(Level.DEBUG, "action: projects");
            List<Project> projects = projectStorage.getAll();
            request.setAttribute("projects", projects);
            request.getRequestDispatcher("/WEB-INF/jsp/projects.jsp").forward(request, response);

        } else {
            logger.log(Level.DEBUG, "action: default");
            request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
        }
    }

    private String getAction(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        String action = requestURI.substring(request.getContextPath().length(), requestURI.length());
        return action;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

}
