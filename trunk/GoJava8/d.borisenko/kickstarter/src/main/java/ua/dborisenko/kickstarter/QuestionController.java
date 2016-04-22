package ua.dborisenko.kickstarter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.dborisenko.kickstarter.dao.ProjectDao;
import ua.dborisenko.kickstarter.dao.QuestionDao;
import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Question;

@Repository
public class QuestionController {

    static final String QUESTION_REQUEST_PARAM_NAME = "question_request";
    static final String PROJECT_ID_PARAM_NAME = "project_id";
    static final String PROJECT_OUT_URL = "?page=project&id=";
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private ProjectDao projectDao;

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
            questionDao.add(question);
            response.sendRedirect(PROJECT_OUT_URL + projectId);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, ErrorText.NUMBER_FORMAT);
        }
    }

}
