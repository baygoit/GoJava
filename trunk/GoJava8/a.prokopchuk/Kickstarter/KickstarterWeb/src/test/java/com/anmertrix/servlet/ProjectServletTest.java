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
import static org.mockito.Mockito.times;

import java.io.IOException;
import java.time.LocalDate;

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

import com.anmertrix.dao.AnswerDao;
import com.anmertrix.dao.PaymentDao;
import com.anmertrix.dao.ProjectDao;
import com.anmertrix.dao.QuestionDao;
import com.anmertrix.domain.Project;

@RunWith(MockitoJUnitRunner.class)
public class ProjectServletTest {
	
	@Mock
	private ProjectDao projectDao;
	@Mock
	private AnswerDao answerDao;
	@Mock
	private QuestionDao questionDao;
	@Mock
	private PaymentDao paymentDao;
	@Mock
	private HttpServletRequest request;
	@Mock
	private HttpServletResponse response;
	@InjectMocks
	private ProjectServlet projectServlet = spy(ProjectServlet.class);
	
	@Ignore
	@Test
	public void testDoGet() throws ServletException, IOException {
		when(request.getParameter("projectId")).thenReturn("2");
		when(projectDao.projectExists(anyInt())).thenReturn(true);
		when(projectDao.getProjectById(anyInt())).thenReturn(new Project());
		Project project = new Project();
		when(project.getFinalDate().toLocalDate()).thenReturn(LocalDate.of(2016, 6, 18));
		
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
		when(projectDao.projectExists(anyInt())).thenReturn(true);
		projectServlet.doPost(request, response);
		assertThat(request.getParameter("requested_action"), is("ADD_QUESTION"));
		verify(projectServlet).addQuestion(request, response);
		verify(projectServlet, never()).addPayment(request, response);
	}
	
	@Test
	public void testDoPostQuestionNotValid() throws ServletException, IOException {
		when(request.getParameter("requested_action")).thenReturn("ADD_QUESTION");
		when(request.getParameter("question")).thenReturn("Test");
		when(request.getParameter("projectId")).thenReturn("1");
		when(projectDao.projectExists(anyInt())).thenReturn(false);
		projectServlet.doPost(request, response);
		assertThat(request.getParameter("requested_action"), is("ADD_QUESTION"));
		verify(projectServlet).addQuestion(request, response);
		verify(projectServlet, never()).addPayment(request, response);
		verify(response, times(1)).sendError(HttpServletResponse.SC_NOT_FOUND);
	}
	
	@Test
	public void testDoPostValidationQuestion() throws ServletException, IOException {
		when(request.getParameter("requested_action")).thenReturn("ADD_QUESTION");
		when(request.getParameter("question")).thenReturn("TestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteTestQuoteQuote1");
		when(request.getParameter("projectId")).thenReturn("1");
		projectServlet.doPost(request, response);
		verify(response, times(1)).sendError(HttpServletResponse.SC_BAD_REQUEST);
	}
	
	@Test
	public void testDoPostValidationQuestionEmpty() throws ServletException, IOException {
		when(request.getParameter("requested_action")).thenReturn("ADD_QUESTION");
		when(request.getParameter("question")).thenReturn("");
		when(request.getParameter("projectId")).thenReturn("1");
		projectServlet.doPost(request, response);
		verify(response, times(1)).sendError(HttpServletResponse.SC_BAD_REQUEST);
	}
	
	@Test
	public void testDoPostPayment() throws ServletException, IOException {
		when(request.getParameter("requested_action")).thenReturn("ADD_PAYMENT");
		when(request.getParameter("cardholder_name")).thenReturn("TestName");
		when(request.getParameter("card_number")).thenReturn("1111222233334444");
		when(request.getParameter("payment_amount")).thenReturn("100");
		when(request.getParameter("projectId")).thenReturn("1");
		when(projectDao.projectExists(anyInt())).thenReturn(true);
		projectServlet.doPost(request, response);
		assertThat(request.getParameter("requested_action"), is("ADD_PAYMENT"));
		verify(projectServlet, never()).addQuestion(request, response);
		verify(projectServlet).addPayment(request, response);
	}
	
	@Test
	public void testDoPostPaymentNotValid() throws ServletException, IOException {
		when(request.getParameter("requested_action")).thenReturn("ADD_PAYMENT");
		when(request.getParameter("cardholder_name")).thenReturn("TestName");
		when(request.getParameter("card_number")).thenReturn("1111222233334444");
		when(request.getParameter("payment_amount")).thenReturn("100");
		when(request.getParameter("projectId")).thenReturn("1");
		when(projectDao.projectExists(anyInt())).thenReturn(false);
		projectServlet.doPost(request, response);
		assertThat(request.getParameter("requested_action"), is("ADD_PAYMENT"));
		verify(projectServlet, never()).addQuestion(request, response);
		verify(projectServlet).addPayment(request, response);
		verify(response, times(1)).sendError(HttpServletResponse.SC_NOT_FOUND);
	}
	
	@Test
	public void testDoPostPaymentValidationCardholderNameEmpty() throws ServletException, IOException {
		when(request.getParameter("requested_action")).thenReturn("ADD_PAYMENT");
		when(request.getParameter("cardholder_name")).thenReturn("");
		when(request.getParameter("card_number")).thenReturn("1111222233334444");
		when(request.getParameter("payment_amount")).thenReturn("100");
		when(request.getParameter("projectId")).thenReturn("1");
		projectServlet.doPost(request, response);
		verify(response, times(1)).sendError(HttpServletResponse.SC_BAD_REQUEST);
	}
	
	@Test
	public void testDoPostPaymentValidationCardholderNameMore() throws ServletException, IOException {
		when(request.getParameter("requested_action")).thenReturn("ADD_PAYMENT");
		when(request.getParameter("cardholder_name")).thenReturn("TestNamesTestNamesTestNamesTestNamesTestNamesTestNamesTestNames");
		when(request.getParameter("card_number")).thenReturn("1111222233334444");
		when(request.getParameter("payment_amount")).thenReturn("100");
		when(request.getParameter("projectId")).thenReturn("1");
		projectServlet.doPost(request, response);
		verify(response, times(1)).sendError(HttpServletResponse.SC_BAD_REQUEST);
	}

	@Test
	public void testDoPostPaymentValidationCardNumberMore() throws ServletException, IOException {
		when(request.getParameter("requested_action")).thenReturn("ADD_PAYMENT");
		when(request.getParameter("cardholder_name")).thenReturn("test");
		when(request.getParameter("card_number")).thenReturn("434343434343434343433");
		when(request.getParameter("payment_amount")).thenReturn("100");
		when(request.getParameter("projectId")).thenReturn("1");
		projectServlet.doPost(request, response);
		verify(response, times(1)).sendError(HttpServletResponse.SC_BAD_REQUEST);
	}
	
	@Test
	public void testDoPostPaymentValidationCardNumberLess() throws ServletException, IOException {
		when(request.getParameter("requested_action")).thenReturn("ADD_PAYMENT");
		when(request.getParameter("cardholder_name")).thenReturn("test");
		when(request.getParameter("card_number")).thenReturn("111122");
		when(request.getParameter("payment_amount")).thenReturn("100");
		when(request.getParameter("projectId")).thenReturn("1");
		projectServlet.doPost(request, response);
		verify(response, times(1)).sendError(HttpServletResponse.SC_BAD_REQUEST);
	}
	
	@Test
	public void testDoPostPaymentValidationCardNumberNoNumber() throws ServletException, IOException {
		when(request.getParameter("requested_action")).thenReturn("ADD_PAYMENT");
		when(request.getParameter("cardholder_name")).thenReturn("test");
		when(request.getParameter("card_number")).thenReturn("11117434fd354224");
		when(request.getParameter("payment_amount")).thenReturn("100");
		when(request.getParameter("projectId")).thenReturn("1");
		projectServlet.doPost(request, response);
		verify(response, times(1)).sendError(HttpServletResponse.SC_BAD_REQUEST);
	}
	
	@Test
	public void testDoPostPaymentValidationAmountNoNumber() throws ServletException, IOException {
		when(request.getParameter("requested_action")).thenReturn("ADD_PAYMENT");
		when(request.getParameter("cardholder_name")).thenReturn("test");
		when(request.getParameter("card_number")).thenReturn("111174345354224");
		when(request.getParameter("payment_amount")).thenReturn("100f");
		when(request.getParameter("projectId")).thenReturn("1");
		projectServlet.doPost(request, response);
		verify(response, times(1)).sendError(HttpServletResponse.SC_BAD_REQUEST);
	}
	
	@Test
	public void testDoPostPaymentValidationAmountLess() throws ServletException, IOException {
		when(request.getParameter("requested_action")).thenReturn("ADD_PAYMENT");
		when(request.getParameter("cardholder_name")).thenReturn("test");
		when(request.getParameter("card_number")).thenReturn("111174345354224");
		when(request.getParameter("payment_amount")).thenReturn("-31");
		when(request.getParameter("projectId")).thenReturn("1");
		projectServlet.doPost(request, response);
		verify(response, times(1)).sendError(HttpServletResponse.SC_BAD_REQUEST);
	}
	
	@Test
	public void testDoGetProjectBadRequest() throws ServletException, IOException {
		when(request.getParameter("projectId")).thenReturn("noNumber");
		assertThat(projectServlet.getSelectedProject(request, response), is(nullValue()));
	}

	@Test
	public void testDoGetProjectNotFound() throws ServletException, IOException {
		when(request.getParameter("projectId")).thenReturn("233");
		when(projectDao.projectExists(anyInt())).thenReturn(false);
		projectServlet.doGet(request, response);
		assertThat(projectServlet.getSelectedProject(request, response), is(nullValue()));
	}
	
	@Test
	public void testSelectedProjectNotFoundProject() throws ServletException, IOException {
		when(request.getParameter("projectId")).thenReturn("233");
		when(projectDao.projectExists(anyInt())).thenReturn(false);
		projectServlet.getSelectedProject(request, response);
		verify(response, times(1)).sendError(HttpServletResponse.SC_NOT_FOUND);
	}
	
	
}
