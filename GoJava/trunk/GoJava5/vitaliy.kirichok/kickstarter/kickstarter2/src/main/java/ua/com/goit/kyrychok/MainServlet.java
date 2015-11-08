package ua.com.goit.kyrychok;

import ua.com.goit.kyrychok.controller.CategoryController;
import ua.com.goit.kyrychok.controller.ProjectController;
import ua.com.goit.kyrychok.controller.RewardController;
import ua.com.goit.kyrychok.dao.database.datasource_provider.DbDataSourceProvider;
import ua.com.goit.kyrychok.dao.database.datasource_provider.H2DataSourceProvider;
import ua.com.goit.kyrychok.dao.database.factory.H2SqlProviderFactory;
import ua.com.goit.kyrychok.dao.factory.DbDaoFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

public class MainServlet extends HttpServlet {
    private CategoryController categoryController;
    private ProjectController projectController;
    private RewardController rewardController;

    private DbDataSourceProvider createDataSourceProvider(String url) {
        DbDataSourceProvider result = new H2DataSourceProvider();
        try {
            result.init("jdbc:h2:" + url, "sa", "");
        } catch (SQLException e) {
            throw new RuntimeException("Can't connect to database", e);
        }
        try {
            result.testConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Test connection fail", e);
        }
        return result;
    }

    private String getAction(HttpServletRequest req) {
        String result;
        String reqURI = req.getRequestURI();
        result = reqURI.substring(req.getContextPath().length(), reqURI.length());
        return result;
    }

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext context = getServletContext();
        String url = context.getRealPath("/WEB-INF/classes/database/kickstarter.db");
        DbDataSourceProvider dataSourceProvider = createDataSourceProvider(url);
        DbDaoFactory daoFactory = new DbDaoFactory(dataSourceProvider, new H2SqlProviderFactory());
        categoryController = new CategoryController(daoFactory.createCategory());
        projectController = new ProjectController(daoFactory.createProject(), daoFactory.createReward());
        rewardController = new RewardController(daoFactory.createReward());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("URI=" + req.getRequestURI());
        String action = getAction(req);
        System.out.println(new Date() + "action=" + action);
        if (action.startsWith("/kickstarter")) {
            req.setAttribute("welcomeMessage", categoryController.getWelcomeMessage());
            req.setAttribute("activeHome", "active");
            req.setAttribute("container", "parts/kickstarter.jsp");
        } else if (action.startsWith("/categories")) {
            req.setAttribute("categories", categoryController.getCategories());
            req.setAttribute("activeCategories", "active");
            req.setAttribute("container", "parts/categories.jsp");
        } else if (action.startsWith("/category")) {
            int categoryId = Integer.parseInt(req.getParameter("id"));
            req.setAttribute("activeCategories", "active");
            req.setAttribute("category", categoryController.get(categoryId));
            req.setAttribute("projects", projectController.fetch(categoryId));
            req.setAttribute("container", "parts/category.jsp");
        } else if (action.startsWith("/project")) {
            int projectId = Integer.parseInt(req.getParameter("id"));
            req.setAttribute("activeProjects", "active");
            req.setAttribute("project", projectController.get(projectId));
            req.setAttribute("rewards", rewardController.fetch(projectId));
            req.setAttribute("container", "parts/project.jsp");
        } else if (action.startsWith("/donate")) {
            int projectId = Integer.parseInt(req.getParameter("projectId"));
            req.setAttribute("activeProjects", "active");
            req.setAttribute("project", projectController.get(projectId));
            String rewardParametr = req.getParameter("rewardId");
            if (rewardParametr != null) {
                int rewardId = Integer.parseInt(rewardParametr);
                req.setAttribute("reward", rewardController.get(rewardId));
            }
            req.setAttribute("container", "parts/donate.jsp");
        }
        req.getRequestDispatcher("main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getAction(req);
        System.out.println(action);
        if (action.startsWith("/donate")) {
            int projectId = Integer.parseInt(req.getParameter("projectId"));
            projectController.doDonate(projectId, req.getParameter("rewardId"), req.getParameter("userName"),
                    req.getParameter("cardNumber"), req.getParameter("pledge"));
        }
        resp.sendRedirect("project?id=" + req.getParameter("projectId"));
    }
}
