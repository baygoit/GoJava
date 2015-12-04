package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.beans.Faq;
import ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import ua.com.goit.gojava7.kickstarter.config.DataSource;
import ua.com.goit.gojava7.kickstarter.dao.FaqDao;

/**
 * Servlet implementation class AskQuestion
 */
@WebServlet("/ask")
public class AskQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FaqDao faqDao;
	private DaoProvider daoProvider;
	private int projectId;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AskQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		daoProvider = new DaoProvider(DataSource.MYSQL);
		
		daoProvider.open();
		
		faqDao = daoProvider.getFaqDao();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		projectId = Integer.parseInt(request.getParameter("id"));
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/askQuestion.jsp");
		
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userName = request.getParameter("first-name");
		
		String question = request.getParameter("question");
		
		Faq faq = new Faq();
		
		faq.setQuestion(question);
		
		faq.setProjectID(projectId);
		
		faqDao.add(faq);
		
		response.sendRedirect("/mykickstarter/project?id=" + projectId);
		
	}
}
