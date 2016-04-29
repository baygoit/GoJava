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

import ua.nenya.dao.PaymentDao;
import ua.nenya.dao.ProjectDao;
import ua.nenya.dao.QuestionDao;
import ua.nenya.domain.Category;
import ua.nenya.domain.Project;
import ua.nenya.domain.Question;

@RunWith(MockitoJUnitRunner.class)
public class ProjectServletTest {
	
	@Mock
	private PaymentDao investmentDao;
	@Mock
	private Project project;
	@Mock
	private Category category;
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
	
	@Test
	public void testDoGetProjectIdValidProjectExists() throws ServletException, IOException {
		when(request.getParameter("projectId")).thenReturn("1");
		when(projectDao.isProjectExist(1)).thenReturn(true);
		
		when(investmentDao.getPaymentSum(1)).thenReturn(100l);
		
		when(projectDao.getProjectByProjectId(1)).thenReturn(project);
		when(project.getCategory()).thenReturn(category);
		
		when(questionDao.getQuestions(1)).thenReturn(new ArrayList<Question>());

		RequestDispatcher dispatcher = mock(RequestDispatcher.class);
		ServletContext context = mock(ServletContext.class);
		
		when(context.getRequestDispatcher(anyString())).thenReturn(dispatcher);
		doReturn(context).when(projectServlet).getServletContext();

		projectServlet.doGet(request, response);
		verify(dispatcher).forward(request, response);
	}
	@Test
	public void testDoGetProjectIdInvalidProjectExists() throws ServletException, IOException {
		when(request.getParameter("projectId")).thenReturn("invalidId");
		when(projectDao.isProjectExist(1)).thenReturn(true);
		
		when(investmentDao.getPaymentSum(1)).thenReturn(100l);
		
		when(projectDao.getProjectByProjectId(1)).thenReturn(new Project());
		when(project.getCategory()).thenReturn(new Category());
		
		when(questionDao.getQuestions(1)).thenReturn(new ArrayList<Question>());

		RequestDispatcher dispatcher = mock(RequestDispatcher.class);
		ServletContext context = mock(ServletContext.class);
		
		when(context.getRequestDispatcher(anyString())).thenReturn(dispatcher);
		doReturn(context).when(projectServlet).getServletContext();

		projectServlet.doGet(request, response);
	}
	
	@Test
	public void testDoGetProjectDoesntExist() throws ServletException, IOException {
		when(request.getParameter("projectId")).thenReturn("1");
		when(projectDao.isProjectExist(1)).thenReturn(false);
		when(investmentDao.getPaymentSum(1)).thenReturn(100l);
		
		when(projectDao.getProjectByProjectId(1)).thenReturn(new Project());
		when(project.getCategory()).thenReturn(new Category());
		when(questionDao.getQuestions(1)).thenReturn(new ArrayList<Question>());

		RequestDispatcher dispatcher = mock(RequestDispatcher.class);
		ServletContext context = mock(ServletContext.class);
		
		when(context.getRequestDispatcher(anyString())).thenReturn(dispatcher);
		doReturn(context).when(projectServlet).getServletContext();

		projectServlet.doGet(request, response);

	}
	
	@Test
	public void testDoPostQuestionValid() throws ServletException, IOException {
		when(request.getParameter("question")).thenReturn("Question");
		when(request.getParameter("projectId")).thenReturn("1");
		when(questionDao.isQuestionAbsent(1, new Question())).thenReturn(true);
		projectServlet.doPost(request, response);
		verify(questionDao).writeQuestionInProject(new Question());
		verify(response).sendRedirect(anyString());
	}
	
	@Test
	public void testDoPostQuestionInvalid() throws ServletException, IOException {
		when(request.getParameter("question")).thenReturn("Question");
		when(request.getParameter("projectId")).thenReturn("1");
		when(questionDao.isQuestionAbsent(1, new Question())).thenReturn(false);
		projectServlet.doPost(request, response);
	}
}
