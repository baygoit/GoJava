package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.com.goit.gojava7.kickstarter.beans.Faq;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import ua.com.goit.gojava7.kickstarter.config.DataSource;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.FaqDao;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;

/**
 * Servlet implementation class ProjectDetailInfo
 */
@WebServlet("/project")
public class ProjectDetailInfo extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private DaoProvider daoProvider;
	private ProjectDao projectDao;
	private PaymentDao paymentDao;
	private FaqDao faqDao;

	public void init(ServletConfig config) throws ServletException {
		
		daoProvider = new DaoProvider(DataSource.MYSQL);
		daoProvider.open();
		
		projectDao = daoProvider.getProjectDao();
		paymentDao = daoProvider.getPaymentDao();
		faqDao = daoProvider.getFaqDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int selectedProjectId = Integer.parseInt(request.getParameter("id"));
		
		Project project = projectDao.getProjectById(selectedProjectId);
		
		project.setCollectedSum(paymentDao.getSumProjectPayments(selectedProjectId));
		
		List<Faq> questions = faqDao.getProjectFaqs(selectedProjectId);
		
		request.setAttribute("project", project);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("questions", questions);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/project_detail_info.jsp");
		
		view.forward(request, response);
		
	}
}
