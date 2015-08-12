package ua.com.goit.kyrychok;

import ua.com.goit.kyrychok.controller.CategoryController;
import ua.com.goit.kyrychok.controller.MainPageController;
import ua.com.goit.kyrychok.controller.ProjectController;
import ua.com.goit.kyrychok.dao.database.DbDataSourceProvider;
import ua.com.goit.kyrychok.dao.database.datasource_provider.H2DataSourceProvider;
import ua.com.goit.kyrychok.dao.database.factory.H2SqlProviderFactory;
import ua.com.goit.kyrychok.dao.factory.AbstractDaoFactory;
import ua.com.goit.kyrychok.dao.factory.DbDaoFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;

public class MainServlet extends HttpServlet {

    private DbDataSourceProvider getDbDataSourceProvider() {
        DbDataSourceProvider result;
        ServletContext context = getServletContext();
        result = (DbDataSourceProvider) context.getAttribute("dataSource");
        System.out.println("Get DS");
        if (result == null) {
            try {
                result = new H2DataSourceProvider();
                URL url = context.getResource("/WEB-INF/classes/database/kickstarter.db");
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
                context.setAttribute("dataSource", result);
                System.out.println("Set DS");
            } catch (MalformedURLException e) {
                throw new RuntimeException("Can't get resource URL", e);
            }
        }
        return result;
    }

    private String getAction(HttpServletRequest req) {
        String result;
        String reqURI = req.getRequestURI();
        result = reqURI.substring(req.getContextPath().length(), reqURI.length());
        return result;
    }

    private void mainPageControl(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AbstractDaoFactory daoFactory = new DbDaoFactory(getDbDataSourceProvider(), new H2SqlProviderFactory());
        MainPageController controller = new MainPageController(daoFactory.createCategory());
        req.setAttribute("model", controller.getModel());
        req.getRequestDispatcher("kickstarter.jsp").forward(req, resp);
    }

    private void categoryControl(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AbstractDaoFactory daoFactory = new DbDaoFactory(getDbDataSourceProvider(), new H2SqlProviderFactory());
        CategoryController controller = new CategoryController(daoFactory.createCategory());
        req.setAttribute("model", controller.getModel(Integer.parseInt(req.getParameter("id"))));
        req.getRequestDispatcher("category.jsp").forward(req, resp);
    }

    private void projectControl(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AbstractDaoFactory daoFactory = new DbDaoFactory(getDbDataSourceProvider(), new H2SqlProviderFactory());
        ProjectController controller = new ProjectController(daoFactory.createProject());
        req.setAttribute("model", controller.getModel(Integer.parseInt(req.getParameter("id"))));
        req.getRequestDispatcher("project.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getAction(req);
        if (action.startsWith("/kickstarter")) {
            mainPageControl(req, resp);
        } else if (action.startsWith("/category")) {
            categoryControl(req, resp);
        } else if (action.startsWith("/project")) {
            projectControl(req, resp);
        } else {
            req.getRequestDispatcher("oops.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
