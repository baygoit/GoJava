package ua.com.goit.gojava7.kickstarter.servlet;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
		
		Project project = new Project("Project name", projectId);
		project.setCategoryId(1);
		when(projectDao.getProject(projectId)).thenReturn(project);
		when(paymentDao.getPledged(projectId)).thenReturn(100);
		
		List<Question> questions = new ArrayList<>();
		Question question = new Question();
		question.setProjectId(projectId);
		question.setQuestionText("question Text");
		questions.add(question);
		when(questionDao.getQuestions(projectId)).thenReturn(questions);
		
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse resp = mock(HttpServletResponse.class);
		
		when(request.getParameter("projectId")).thenReturn(Integer.toString(projectId));
		
		PrintWriter writer = mock(PrintWriter.class);
		when(resp.getWriter()).thenReturn(writer);

		projectServlet.doGet(request, resp);

		verify(writer).append(contains("Project name"));
		verify(writer).append(contains("pledged: 100"));
		verify(writer).append(contains("question Text"));
	}
}
