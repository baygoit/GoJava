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
	public void testDoGetHttpServletRequestHttpServletResponse() throws ServletException, IOException {

		List<Reward> rewards = new ArrayList<>();
		Reward reward = new Reward(1, 12);
		reward.setBenefit("Benefit");
		reward.setPledge(100);
		rewards.add(reward);
		when(rewardDao.getRewards(12)).thenReturn(rewards);

		HttpServletRequest req = mock(HttpServletRequest.class);
		HttpServletResponse resp = mock(HttpServletResponse.class);

		when(req.getParameter("projectId")).thenReturn("12");

		PrintWriter writer = mock(PrintWriter.class);
		when(resp.getWriter()).thenReturn(writer);

		paymentsServlet.doGet(req, resp);

		verify(writer).append(contains("Benefit"));
		verify(writer).append(contains("own amount"));
	}

}
