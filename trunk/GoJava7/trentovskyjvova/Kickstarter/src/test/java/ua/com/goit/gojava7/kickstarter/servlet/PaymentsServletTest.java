package ua.com.goit.gojava7.kickstarter.servlet;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

@RunWith(MockitoJUnitRunner.class)
public class PaymentsServletTest {
	@Mock
	private ProjectDao projectDao;
	@Mock
	private RewardDao rewardDao;
	@InjectMocks
	private PaymentsServlet paymentsServlet;
	
	@Test
	public void testInit() throws ServletException, IOException {
		
		DaoProvider daoProvider = mock(DaoProvider.class);
		ServletConfig config = mock(ServletConfig.class);
		ServletContext context = mock(ServletContext.class);
		
		when(config.getServletContext()).thenReturn(context);
		when(context.getAttribute(ContextListener.STORAGE_FACTORY)).thenReturn(daoProvider);

		paymentsServlet.init(config);

		verify(daoProvider).getRewardsReader();
	}
	
	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() throws ServletException, IOException {
		int projectId = 12;
		
		List<Reward> rewards = new ArrayList<>();
		when(rewardDao.getRewards(12)).thenReturn(rewards);

		HttpServletRequest req = mock(HttpServletRequest.class);
		HttpServletResponse resp = mock(HttpServletResponse.class);
		RequestDispatcher rd = mock(RequestDispatcher.class);
		
		when(req.getRequestDispatcher(contains("payments"))).thenReturn(rd);
		when(req.getParameter("projectId")).thenReturn(Integer.toString(projectId));

		paymentsServlet.doGet(req, resp);

		verify(req).setAttribute("rewards", rewards);
		verify(req).setAttribute("projectId", projectId);
		verify(rd).forward(req, resp);
	}

}
