package ua.com.goit.gojava7.kickstarter.servlet;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

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
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.domain.Payment;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

@RunWith(MockitoJUnitRunner.class)
public class PledgeServletTest {
	@Mock
	private PaymentDao paymentDao;
	@Mock
	private RewardDao rewardDao;
	@Mock
	private ProjectDao projectDao;
	@Mock
	RequestValidation requestValidation;
	@InjectMocks
	private PledgeServlet pledgeServlet;
	
	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() throws ServletException, IOException {

		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse resp = mock(HttpServletResponse.class);
		RequestDispatcher rd = mock(RequestDispatcher.class);
		
		when(request.getRequestDispatcher(contains("pledge"))).thenReturn(rd);
		when(request.getParameter("projectId")).thenReturn("12");
		when(request.getParameter("rewardId")).thenReturn("1");

		pledgeServlet.doGet(request, resp);

		verify(request).setAttribute("rewardId", 1);
		verify(request).setAttribute("projectId", 12);
		verify(rd).forward(request, resp);
	}

	@Test
	public void testDoPostHttpServletRequestHttpServletResponse() throws ServletException, IOException {

		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		
		when(request.getParameter("projectId")).thenReturn("12");
		when(request.getParameter("rewardId")).thenReturn("1");
		when(request.getParameter("amount")).thenReturn("100");

		Reward reward = mock(Reward.class);
		when(rewardDao.getReward(1)).thenReturn(reward);
		when(reward.getPledge()).thenReturn(200);
		
		pledgeServlet.doPost(request, response);
		
		verify(paymentDao).addPayment(any(Payment.class));
		verify(response).sendRedirect(contains("12"));
	}

}
