package com.anmertrix.servlet;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.anmertrix.dao.NoResultException;
import com.anmertrix.dao.ProjectDao;
import com.anmertrix.dao.RewardDao;
import com.anmertrix.domain.Answer;
import com.anmertrix.domain.Project;
import com.anmertrix.domain.Question;

@RunWith(MockitoJUnitRunner.class)
public class ProjectServletTest {
	
	@Mock
	private ProjectDao projectDao;
	@Mock
	private RewardDao rewardDao;
	@Mock
	private HttpServletRequest request;
	@Mock
	private HttpServletResponse response;
	@InjectMocks
	private ProjectServlet projectServlet = spy(ProjectServlet.class);
	
	@Test
	public void testDoGet() throws ServletException, IOException {
		when(request.getParameter("projectId")).thenReturn("2");

		when(projectDao.getProjectById(2)).thenReturn(new Project());
		when(projectDao.getQuestionsByProjectId(2)).thenReturn(new ArrayList<>());
		when(projectDao.getAnswersByQuestionId(1)).thenReturn(new ArrayList<>());
		when(projectDao.getPaymentsByProjectId(2)).thenReturn(new ArrayList<>());
		when(rewardDao.getRewards()).thenReturn(new ArrayList<>());
		
		RequestDispatcher dispatcher = mock(RequestDispatcher.class);
		ServletContext context = mock(ServletContext.class);
		when(context.getRequestDispatcher(anyString())).thenReturn(dispatcher);
		doReturn(context).when(projectServlet).getServletContext();
		projectServlet.doGet(request, response);
		verify(dispatcher).forward(any(), any());
	}
	
	@Test
	public void testDoPostQuestion() throws ServletException, IOException {
		when(request.getParameter("requested_action")).thenReturn("ADD_QUESTION");
		when(request.getParameter("question")).thenReturn("Test");
		when(request.getParameter("projectId")).thenReturn("1");
		projectServlet.doPost(request, response);
		assertThat(request.getParameter("requested_action"), is("ADD_QUESTION"));
		verify(projectServlet).addQuestion(request, response);
		verify(projectServlet, never()).addPayment(request, response);
	}
	
	@Test
	public void testDoPostPayment() throws ServletException, IOException {
		when(request.getParameter("requested_action")).thenReturn("ADD_PAYMENT");
		when(request.getParameter("cardholder_name")).thenReturn("TestName");
		when(request.getParameter("card_number")).thenReturn("1111222233334444");
		when(request.getParameter("payment_amount")).thenReturn("100");
		when(request.getParameter("projectId")).thenReturn("3");
		projectServlet.doPost(request, response);
		assertThat(request.getParameter("requested_action"), is("ADD_PAYMENT"));
		verify(projectServlet, never()).addQuestion(request, response);
		verify(projectServlet).addPayment(request, response);
	}
	
	@Test
	public void testDoGetProjectBadRequest() throws ServletException, IOException {
		when(request.getParameter("projectId")).thenReturn("noNumber");
		assertThat(projectServlet.getSelectedProject(request, response), is(nullValue()));
		verify(projectDao, never()).getQuestionsByProjectId(anyInt());
	}
	
	@Test
	public void testDoGetProjectNotFound() throws ServletException, IOException {
		when(request.getParameter("projectId")).thenReturn("123");
		when(projectDao.getProjectById(123)).thenThrow(new NoResultException("No project found"));
		assertThat(projectServlet.getSelectedProject(request, response), is(nullValue()));	
		verify(projectDao, never()).getQuestionsByProjectId(anyInt());
	}
	
	@Spy
	private List<Question> questionsTest = new ArrayList<>();
	@Spy
	private List<Answer> answersTest = new ArrayList<>();

}
