package ua.nenya.servlets;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hamcrest.core.AnyOf;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.nenya.dao.ProjectDao;
import ua.nenya.dao.QuestionDao;
import ua.nenya.domain.Project;
import ua.nenya.domain.Question;

@RunWith(MockitoJUnitRunner.class)
public class ProjectServletTest {
	
	@Mock
	private QuestionDao questionDao;
	@Mock
	private ProjectDao projectDao;
	@Mock
	private HttpServletRequest request;
	@Mock
	private HttpServletResponse response;
	@InjectMocks
	private ProjectServlet projectServlet = spy(ProjectServlet.class);
	@Ignore
	@Test
	public void testDoGetProjectExists() throws ServletException, IOException {
		when(request.getParameter("projectName")).thenReturn("Project");
		when(projectDao.isProjectExist(1)).thenReturn(true);
		when(request.getParameter("categoryName")).thenReturn("Film");
		when(projectDao.getProject(1)).thenReturn(new Project());
		when(questionDao.getQuestions(1)).thenReturn(new ArrayList<Question>());

		RequestDispatcher dispatcher = mock(RequestDispatcher.class);
		ServletContext context = mock(ServletContext.class);
		
		when(context.getRequestDispatcher(anyString())).thenReturn(dispatcher);
		doReturn(context).when(projectServlet).getServletContext();

		projectServlet.doGet(request, response);
		verify(dispatcher).forward(request, response);
	}

	@Test
	public void testDoGetProjectDoesntExist() throws ServletException, IOException {
		when(request.getParameter("projectName")).thenReturn("Project");
		when(projectDao.isProjectExist(1)).thenReturn(false);
		when(request.getParameter("categoryName")).thenReturn("Film");
		when(projectDao.getProject(1)).thenReturn(new Project());
		when(questionDao.getQuestions(1)).thenReturn(new ArrayList<Question>());

		RequestDispatcher dispatcher = mock(RequestDispatcher.class);
		ServletContext context = mock(ServletContext.class);
		
		when(context.getRequestDispatcher(anyString())).thenReturn(dispatcher);
		doReturn(context).when(projectServlet).getServletContext();
		projectServlet.doGet(request, response);

	}
	
	@Ignore
	@Test
	public void testDoPost() throws ServletException, IOException {
		when(request.getParameter("question")).thenReturn("Question");
		when(request.getParameter("projectName")).thenReturn("Project");
		when(request.getParameter("categoryName")).thenReturn("Film");
		when(questionDao.isQuestionValid(1, anyString())).thenReturn(true);
		
		verify(questionDao).writeQuestionInProject(1, "Question");

		//verify(response).sendRedirect(anyString());
	}
}
