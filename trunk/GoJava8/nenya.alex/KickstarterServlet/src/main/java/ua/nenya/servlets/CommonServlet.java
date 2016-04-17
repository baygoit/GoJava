package ua.nenya.servlets;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.nenya.dao.CategoryDao;
import ua.nenya.dao.InvestmentDao;
import ua.nenya.dao.ProjectDao;
import ua.nenya.dao.QuestionDao;
import ua.nenya.dao.QuoteDao;
import ua.nenya.dao.RewardDao;

public class CommonServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private QuoteDao quoteDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private QuestionDao questionDao;
	@Autowired
	private InvestmentDao investmentDao;
	@Autowired
	private RewardDao rewardDao;
	
	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public QuoteDao getQuoteDao() {
		return quoteDao;
	}

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public ProjectDao getProjectDao() {
		return projectDao;
	}

	public QuestionDao getQuestionDao() {
		return questionDao;
	}

	public InvestmentDao getInvestmentDao() {
		return investmentDao;
	}

	public RewardDao getRewardDao() {
		return rewardDao;
	}

	
}
