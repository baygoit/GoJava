package ua.com.goit.gojava7.kickstarter.controller;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.powermock.modules.junit4.PowerMockRunner;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.models.Category;
import ua.com.goit.gojava7.kickstarter.models.Project;
import ua.com.goit.gojava7.kickstarter.models.Question;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SpringBeanAutowiringSupport.class)
public class ProjectServletTest {

    @Mock
    private ProjectDao projectDao;

    @InjectMocks
    private StartController startController;

    @Ignore
    @Test
    public void testDoGet() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getRequestDispatcher(anyString())).thenReturn(mock(RequestDispatcher.class));
        when(request.getParameter("id")).thenReturn("1");

        Project project = new Project();
        when(projectDao.get(anyLong())).thenReturn(project);

        Category category = new Category();
        when(projectDao.getCategory(any(Project.class))).thenReturn(category);

        List<Question> questions = new ArrayList<>();
        when(projectDao.getQuestions(anyLong())).thenReturn(questions);

        HttpServletResponse response = mock(HttpServletResponse.class);
        PrintWriter writer = mock(PrintWriter.class);
        when(response.getWriter()).thenReturn(writer);

        //projectServlet.doGet(request, response);

        verify(request).setAttribute("category", category);
        verify(request).setAttribute("project", project);
        verify(request).setAttribute("questions", questions);
    }
}
