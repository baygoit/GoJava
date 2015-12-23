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
import ua.com.goit.gojava7.kickstarter.domain.Project;

@RunWith(MockitoJUnitRunner.class)
public class ProjectsServletTest {
	@Mock
	private ProjectDao projectDao;
	@Mock
	private PaymentDao paymentDao;
	@InjectMocks
	private ProjectsServlet projectsServlet;
	
	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() throws ServletException, IOException {

		List<Project> projects = new ArrayList<>();
		Project project = new Project("Project name", 1);
		project.setCategoryId(12);
		projects.add(project);
		when(projectDao.getProjects(12)).thenReturn(projects);
		when(paymentDao.getPledged(1)).thenReturn(0);
		
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse resp = mock(HttpServletResponse.class);
		RequestDispatcher rd = mock(RequestDispatcher.class);
		
		when(request.getRequestDispatcher(contains("projects"))).thenReturn(rd);
		
		when(request.getParameter("id")).thenReturn("12");

		projectsServlet.doGet(request, resp);

		verify(request).setAttribute("projects", projects);
		verify(request).setAttribute("paymentDao", paymentDao);
		verify(rd).forward(request, resp);
	}

}
