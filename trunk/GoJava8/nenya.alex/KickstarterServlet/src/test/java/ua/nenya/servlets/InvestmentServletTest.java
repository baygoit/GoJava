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

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.nenya.dao.PaymentDao;
import ua.nenya.dao.ProjectDao;
import ua.nenya.dao.RewardDao;
import ua.nenya.domain.Project;
import ua.nenya.domain.Reward;

@RunWith(MockitoJUnitRunner.class)
public class InvestmentServletTest {

	@Mock
	private PaymentDao investmentDao;
	@Mock
	private RewardDao rewardDao;
	@Mock
	private ProjectDao projectDao;
	@Mock
	private HttpServletRequest request;
	@Mock
	private HttpServletResponse response;
	@InjectMocks
	private InvestmentServlet invesmentServlet = spy(InvestmentServlet.class);
	
	@Test
	public void testDoGetProjectIdValidProjectExists() throws ServletException, IOException {
		when(request.getParameter("projectId")).thenReturn("1");
		when(projectDao.isProjectExist(1)).thenReturn(true);
		when(projectDao.getProject(1)).thenReturn(new Project());
		when(rewardDao.getRewards(1)).thenReturn(new ArrayList<Reward>());

		RequestDispatcher dispatcher = mock(RequestDispatcher.class);
		ServletContext context = mock(ServletContext.class);
		
		when(context.getRequestDispatcher(anyString())).thenReturn(dispatcher);
		doReturn(context).when(invesmentServlet).getServletContext();

		invesmentServlet.doGet(request, response);
		verify(dispatcher).forward(request, response);
	}
	@Test
	public void testDoGetProjectIdInvalidProjectExists() throws ServletException, IOException {
		when(request.getParameter("projectId")).thenReturn("uio");
		when(projectDao.isProjectExist(1)).thenReturn(true);
		when(projectDao.getProject(1)).thenReturn(new Project());
		when(rewardDao.getRewards(1)).thenReturn(new ArrayList<Reward>());

		RequestDispatcher dispatcher = mock(RequestDispatcher.class);
		ServletContext context = mock(ServletContext.class);
		
		when(context.getRequestDispatcher(anyString())).thenReturn(dispatcher);
		doReturn(context).when(invesmentServlet).getServletContext();

		invesmentServlet.doGet(request, response);
	}
	@Test
	public void testDoGetProjectIdValidProjectDoesntExist() throws ServletException, IOException {
		when(request.getParameter("projectId")).thenReturn("1");
		when(projectDao.isProjectExist(1)).thenReturn(false);
		when(projectDao.getProject(1)).thenReturn(new Project());
		when(rewardDao.getRewards(1)).thenReturn(new ArrayList<Reward>());

		RequestDispatcher dispatcher = mock(RequestDispatcher.class);
		ServletContext context = mock(ServletContext.class);
		
		when(context.getRequestDispatcher(anyString())).thenReturn(dispatcher);
		doReturn(context).when(invesmentServlet).getServletContext();

		invesmentServlet.doGet(request, response);
	}
	
	@Test
	public void testDoPostProjectIdValidAmountIsntO() throws ServletException, IOException {
		when(request.getParameter("amount")).thenReturn("100");
		when(request.getParameter("projectId")).thenReturn("1");
		invesmentServlet.doPost(request, response);
		verify(investmentDao).writePaymentInProject(1, 100);
		verify(response).sendRedirect(anyString());
	}
	@Test
	public void testDoPostProjectIdValidAmountIsOInvestmentValid() throws ServletException, IOException {
		when(request.getParameter("amount")).thenReturn("0");
		when(request.getParameter("projectId")).thenReturn("1");
		when(request.getParameter("investment")).thenReturn("100");
		invesmentServlet.doPost(request, response);
		verify(investmentDao).writePaymentInProject(1, 100);
		verify(response).sendRedirect(anyString());
	}
	
	@Test
	public void testDoPostProjectIdValidAmountIsOInvestmentInvalid() throws ServletException, IOException {
		when(request.getParameter("amount")).thenReturn("0");
		when(request.getParameter("projectId")).thenReturn("1");
		when(request.getParameter("investment")).thenReturn("invalid");
		invesmentServlet.doPost(request, response);
	}

	@Test
	public void testDoPostProjectIdInvalid() throws ServletException, IOException {
		when(request.getParameter("amount")).thenReturn("100");
		when(request.getParameter("projectId")).thenReturn("invalid");
		invesmentServlet.doPost(request, response);
	}
}
