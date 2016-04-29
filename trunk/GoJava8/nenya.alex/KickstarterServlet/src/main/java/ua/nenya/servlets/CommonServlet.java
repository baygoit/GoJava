package ua.nenya.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.nenya.dao.CategoryDao;
import ua.nenya.dao.PaymentDao;
import ua.nenya.dao.ProjectDao;
import ua.nenya.dao.QuestionDao;
import ua.nenya.dao.QuoteDao;
import ua.nenya.dao.RewardDao;

public class CommonServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	protected QuoteDao quoteDao;
	
	@Autowired
	protected CategoryDao categoryDao;
	
	@Autowired
	protected ProjectDao projectDao;
	
	@Autowired
	protected QuestionDao questionDao;
	
	@Autowired
	protected PaymentDao paymentDao;
	
	@Autowired
	protected RewardDao rewardDao;
	
	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

}
