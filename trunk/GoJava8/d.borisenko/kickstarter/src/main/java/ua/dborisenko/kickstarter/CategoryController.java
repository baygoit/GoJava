package ua.dborisenko.kickstarter;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import ua.dborisenko.kickstarter.dao.CategoryDao;
import ua.dborisenko.kickstarter.dao.ProjectDao;
import ua.dborisenko.kickstarter.dao.QuoteDao;
import ua.dborisenko.kickstarter.domain.Category;

@Repository
public class CategoryController {

    static final String ID_PARAM_NAME = "id";
    static final String PROJECTS_ATTR_NAME = "projects";
    static final String CATEGORY_ATTR_NAME = "category";
    static final String CATEGORIES_ATTR_NAME = "categories";
    static final String QUOTE_ATTR_NAME = "quote";
    static final String CATEGORY_JSP_PATH = "/WEB-INF/jsp/category.jsp";
    static final String CATEGORIES_JSP_PATH = "/WEB-INF/jsp/categories.jsp";
    @Autowired
    private QuoteDao quoteDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private ProjectDao projectDao;

    void showCategories(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute(QUOTE_ATTR_NAME, quoteDao.getRandom());
        request.setAttribute(CATEGORIES_ATTR_NAME, categoryDao.getAll());
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(CATEGORIES_JSP_PATH);
        dispatcher.forward(request, response);
    }

    void showCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.valueOf(request.getParameter(ID_PARAM_NAME));
            Category category = categoryDao.getById(id);
            projectDao.getAllForCategory(category);
            request.setAttribute(CATEGORY_ATTR_NAME, category);
            request.setAttribute(PROJECTS_ATTR_NAME, category.getProjects());
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(CATEGORY_JSP_PATH);
            dispatcher.forward(request, response);
        } catch (EmptyResultDataAccessException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, ErrorText.CATEGORY_NOT_FOUND);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, ErrorText.NUMBER_FORMAT);
        }
    }
}
