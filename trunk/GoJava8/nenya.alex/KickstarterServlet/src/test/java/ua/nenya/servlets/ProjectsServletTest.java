package ua.nenya.servlets;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
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

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.nenya.dao.CategoryDao;
import ua.nenya.dao.ProjectDao;
import ua.nenya.domain.Project;

@Ignore
@RunWith(MockitoJUnitRunner.class)
public class ProjectsServletTest {

	@Mock
	private CategoryDao categoryDao;
	
	@Mock
	private ProjectDao projectDao;
	
	@Mock
	private HttpServletRequest request;
	@Mock
	private HttpServletResponse response;
	@InjectMocks
	private ProjectsServlet projectsServlet = spy(ProjectsServlet.class);
	
	@Test
	public void testDoGet() throws ServletException, IOException {
		when(request.getParameter("categoryName")).thenReturn("Film");

		when(projectDao.getProjects("Film")).thenReturn(new ArrayList<Project>());


		RequestDispatcher dispatcher = mock(RequestDispatcher.class);

		ServletContext context = mock(ServletContext.class);
		when(context.getRequestDispatcher(anyString())).thenReturn(dispatcher);

		doReturn(context).when(projectsServlet).getServletContext();

		projectsServlet.doGet(request, response);

		//verify(dispatcher).forward(any(), any());

	}

}
