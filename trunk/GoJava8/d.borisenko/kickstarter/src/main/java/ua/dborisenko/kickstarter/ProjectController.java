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
import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Question;

@Repository
public class ProjectController {

    static final String ID_PARAM_NAME = "id";
    static final String CATEGORY_ATTR_NAME = "category";
    static final String QUESTIONS_ATTR_NAME = "questions";
    static final String PROJECT_ATTR_NAME = "project";
    static final String PROJECT_JSP_PATH = "/WEB-INF/jsp/project.jsp";
    static final String QUESTION_REQUEST_PARAM_NAME = "question_request";
    static final String PROJECT_ID_PARAM_NAME = "project_id";
    static final String PROJECT_OUT_URL = "?page=project&id=";
    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private CategoryDao categoryDao;

    void showProject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.valueOf(request.getParameter(ID_PARAM_NAME));
            Project project = projectDao.getById(id);
            projectDao.getQuestions(project);
            request.setAttribute(PROJECT_ATTR_NAME, project);
            request.setAttribute(QUESTIONS_ATTR_NAME, project.getQuestions());
            Category category = categoryDao.getByProject(project);
            request.setAttribute(CATEGORY_ATTR_NAME, category);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(PROJECT_JSP_PATH);
            dispatcher.forward(request, response);
        } catch (EmptyResultDataAccessException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, ErrorText.PROJECT_NOT_FOUND);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, ErrorText.NUMBER_FORMAT);
        }
    }
    
    void addQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int projectId = Integer.valueOf(request.getParameter(PROJECT_ID_PARAM_NAME));
            Project project = projectDao.getById(projectId);
            Question question = new Question();
            question.setProject(project);
            question.setRequest(request.getParameter(QUESTION_REQUEST_PARAM_NAME));
            if (question.getRequest().trim().length() == 0) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, ErrorText.EMPTY_STRING);
                return;
            }
            projectDao.addQuestion(question);
            response.sendRedirect(PROJECT_OUT_URL + projectId);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, ErrorText.NUMBER_FORMAT);
        }
    }

}
