package ua.dborisenko.kickstarter;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.dborisenko.kickstarter.dao.CategoryDao;
import ua.dborisenko.kickstarter.dao.NoResultException;
import ua.dborisenko.kickstarter.dao.ProjectDao;
import ua.dborisenko.kickstarter.dao.QuestionDao;
import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Project;

@Repository
public class ProjectController {
    static final String ID_PARAM_NAME = "id";
    static final String CATEGORY_ATTR_NAME = "category";
    static final String QUESTIONS_ATTR_NAME = "questions";
    static final String PROJECT_ATTR_NAME = "project";
    static final String PROJECT_JSP_PATH = "/WEB-INF/jsp/project.jsp";
    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private CategoryDao categoryDao;

    void showProject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.valueOf(request.getParameter(ID_PARAM_NAME));
            Project project = projectDao.getProjectById(id);
            questionDao.getAllForProject(project);
            request.setAttribute(PROJECT_ATTR_NAME, project);
            request.setAttribute(QUESTIONS_ATTR_NAME, project.getQuestions());
            Category category = categoryDao.getByProjectId(id);
            request.setAttribute(CATEGORY_ATTR_NAME, category);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(PROJECT_JSP_PATH);
            dispatcher.forward(request, response);
        } catch (NoResultException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, ErrorText.PROJECT_NOT_FOUND);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, ErrorText.NUMBER_FORMAT);
        }
    }

}
