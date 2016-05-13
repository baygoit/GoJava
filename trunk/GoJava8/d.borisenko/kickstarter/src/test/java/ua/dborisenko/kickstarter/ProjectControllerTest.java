package ua.dborisenko.kickstarter;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.dao.EmptyResultDataAccessException;

import ua.dborisenko.kickstarter.dao.ProjectDao;
import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Question;

@RunWith(MockitoJUnitRunner.class)
public class ProjectControllerTest {

    @Mock
    private RequestDispatcher dispatcher;
    @Mock
    private ServletContext context;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private ProjectDao projectDao;
    @InjectMocks
    private ProjectController projectController;

    @Before
    public void setUp() {
        when(request.getServletContext()).thenReturn(context);
        when(context.getRequestDispatcher(anyString())).thenReturn(dispatcher);
    }

    @Test
    public void showProjectTest() throws ServletException, IOException {
        when(request.getParameter(ProjectController.ID_PARAM_NAME)).thenReturn("42");
        Project project = mock(Project.class);
        List<Question> questions = new ArrayList<>();
        when(project.getQuestions()).thenReturn(questions);
        when(projectDao.getWithQuestions(42)).thenReturn(project);
        projectController.showProject(request, response);
        verify(request).setAttribute(ProjectController.PROJECT_ATTR_NAME, project);
        verify(request).setAttribute(ProjectController.QUESTIONS_ATTR_NAME, questions);
        verify(context).getRequestDispatcher(ProjectController.PROJECT_JSP_PATH);
        verify(dispatcher).forward(request, response);
    }

    @Test
    public void showProjectEmptyTest() throws ServletException, IOException {
        when(request.getParameter(ProjectController.ID_PARAM_NAME)).thenReturn("42");
        when(projectDao.getWithQuestions(42)).thenThrow(new EmptyResultDataAccessException(1));
        projectController.showProject(request, response);
        verify(response).sendError(HttpServletResponse.SC_NOT_FOUND, ErrorText.PROJECT_NOT_FOUND);
    }

    @Test
    public void showProjectWrongNumberTest() throws ServletException, IOException {
        when(request.getParameter(ProjectController.ID_PARAM_NAME)).thenReturn("foo");
        projectController.showProject(request, response);
        verify(response).sendError(HttpServletResponse.SC_BAD_REQUEST, ErrorText.NUMBER_FORMAT);
    }

    @Test
    public void addQuestionTest() throws ServletException, IOException {
        when(request.getParameter(ProjectController.PROJECT_ID_PARAM_NAME)).thenReturn("42");
        when(request.getParameter(ProjectController.QUESTION_REQUEST_PARAM_NAME)).thenReturn("foo");
        projectController.addQuestion(request, response);
        verify(projectDao).addQuestion(any(Question.class));
        verify(response).sendRedirect(InvestmentController.PROJECT_OUT_URL + 42);
    }

    @Test
    public void addQuestionEmptyTest() throws ServletException, IOException {
        when(request.getParameter(ProjectController.PROJECT_ID_PARAM_NAME)).thenReturn("42");
        when(request.getParameter(ProjectController.QUESTION_REQUEST_PARAM_NAME)).thenReturn("");
        projectController.addQuestion(request, response);
        verify(response).sendError(HttpServletResponse.SC_BAD_REQUEST, ErrorText.EMPTY_STRING);
    }

    @Test
    public void addQuestionWrongNumberTest() throws ServletException, IOException {
        when(request.getParameter(ProjectController.PROJECT_ID_PARAM_NAME)).thenReturn("foo");
        projectController.addQuestion(request, response);
        verify(response).sendError(HttpServletResponse.SC_BAD_REQUEST, ErrorText.NUMBER_FORMAT);
    }
}
