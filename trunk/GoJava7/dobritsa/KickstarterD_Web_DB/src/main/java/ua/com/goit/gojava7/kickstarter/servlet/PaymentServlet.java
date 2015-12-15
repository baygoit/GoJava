package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kickstarter.config.Validator;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDbDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDbDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDbDao;

@WebServlet("/payment")
public class PaymentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ProjectDbDao projectDao;
	
	@Autowired
	private RewardDbDao rewardDao;
	
	@Autowired
	private CategoryDbDao categoryDao;

	@Override
	public void init() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int rewardId = Integer.parseInt(request.getParameter("id"));
		int amount;
		int projectId;

		if (rewardId != 0) {
			projectId = rewardDao.get(rewardId).getProjectId();
			amount = rewardDao.get(rewardId).getAmount();
			request.setAttribute("category", categoryDao.get(projectDao.get(projectId).getCategoryId()));
			request.setAttribute("project", projectDao.get(projectId));
			request.setAttribute("amount", amount);
			request.getRequestDispatcher("/WEB-INF/jsp/payment.jsp").forward(request, response);

		} else {
			projectId = Integer.parseInt(request.getParameter("projectId"));
			
			if (Validator.validateAmountOfPledge(request.getParameter("amount"))) {	
				amount = Integer.parseInt(request.getParameter("amount"));
				request.setAttribute("category", categoryDao.get(projectDao.get(projectId).getCategoryId()));
				request.setAttribute("project", projectDao.get(projectId));
				request.setAttribute("amount", amount);
				request.getRequestDispatcher("/WEB-INF/jsp/payment.jsp").forward(request, response);
			} else {
				request.setAttribute("message", "-----Wrong amount-----");
				request.setAttribute("category", categoryDao.get(projectDao.get(projectId).getCategoryId()));
				request.setAttribute("project", projectDao.get(projectId));
				request.setAttribute("rewards", rewardDao.getByProject(projectId));
				request.getRequestDispatcher("/WEB-INF/jsp/rewards.jsp").forward(request, response);
			}
		}
	}
}
