package ua.com.goit.gojava7.kickstarter.servlet;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Question;

@RunWith(MockitoJUnitRunner.class)
public class ProjectServletTest {
	@Mock
	private ProjectDao projectDao;
	@Mock
	private PaymentDao paymentDao;
	@Mock
	private QuestionDao questionDao;
	@InjectMocks
	private ProjectServlet projectServlet;
	
	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() throws ServletException, IOException {
		int projectId = 12;
		
		Project selectedProject = new Project("Project name", projectId);
		selectedProject.setCategoryId(1);
		when(projectDao.getProject(projectId)).thenReturn(selectedProject);
		int pledged = 100;
		when(paymentDao.getPledged(projectId)).thenReturn(pledged);
		
		List<Question> questions = new ArrayList<>();
		when(questionDao.getQuestions(projectId)).thenReturn(questions);
		
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse resp = mock(HttpServletResponse.class);
		RequestDispatcher rd = mock(RequestDispatcher.class);
		
		when(request.getRequestDispatcher(contains("project"))).thenReturn(rd);
		when(request.getParameter("projectId")).thenReturn(Integer.toString(projectId));

		projectServlet.doGet(request, resp);

		verify(request).setAttribute("selectedProject", selectedProject);
		verify(request).setAttribute("pledged", pledged);
		verify(request).setAttribute("questions", questions);
		verify(rd).forward(request, resp);
	}
}
