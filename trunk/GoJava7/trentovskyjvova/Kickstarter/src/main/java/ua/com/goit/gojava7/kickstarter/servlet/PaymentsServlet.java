package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

@WebServlet("/payments")
public class PaymentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RewardDao rewardDao;
	
	private DaoProvider daoProvider;
	protected WebApplicationContext applicationContext;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext servletContext = config.getServletContext();
		applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);

		daoProvider = applicationContext.getBean(DaoProvider.class);
		//daoProvider.open();
		super.init(config);
	}
	
	@Override
	public void init() throws ServletException {
		rewardDao = daoProvider.getRewardsReader();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		List<Reward> rewards = rewardDao.getRewards(projectId);
		
		request.setAttribute("rewards", rewards);
		request.setAttribute("projectId", projectId);
		request.getRequestDispatcher("/WEB-INF/jsp/payments.jsp").forward(request, response);
	}

}
