package ua.com.goit.gojava7.kickstarter.servlet;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.any;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.domain.Question;

@RunWith(MockitoJUnitRunner.class)
public class QuestionServletTest {
	@Mock
	private QuestionDao questionDao;
	@InjectMocks
	private QuestionServlet questionServlet;
	
	@Test
	public void testInit() throws ServletException, IOException {
		
		DaoProvider daoProvider = mock(DaoProvider.class);
		ServletConfig config = mock(ServletConfig.class);
		ServletContext context = mock(ServletContext.class);
		
		when(config.getServletContext()).thenReturn(context);
		when(context.getAttribute(ContextListener.STORAGE_FACTORY)).thenReturn(daoProvider);

		questionServlet.init(config);

		verify(daoProvider).getQuestionReader();
	}
	
	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() throws ServletException, IOException {

		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse resp = mock(HttpServletResponse.class);
		RequestDispatcher rd = mock(RequestDispatcher.class);
		
		when(request.getRequestDispatcher(contains("question"))).thenReturn(rd);
		when(request.getParameter("projectId")).thenReturn("12");

		questionServlet.doGet(request, resp);

		verify(request).setAttribute("projectId", 12);
		verify(rd).forward(request, resp);
	}

	@Test
	public void testDoPostHttpServletRequestHttpServletResponse() throws ServletException, IOException {

		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		when(request.getParameter("projectId")).thenReturn("12");
		when(request.getParameter("questionText")).thenReturn("que text");

		questionServlet.doPost(request, response);

		verify(questionDao).addQuestion(any(Question.class));
		verify(response).sendRedirect(contains("12"));
	}
}
