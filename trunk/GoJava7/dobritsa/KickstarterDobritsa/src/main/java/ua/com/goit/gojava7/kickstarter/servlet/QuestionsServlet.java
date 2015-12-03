package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.dao.DaoFactory;
import ua.com.goit.gojava7.kickstarter.dao.MyDataSource;
import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;

@WebServlet("/questions")
public class QuestionsServlet extends HttpServlet {

	DaoFactory daoFactory;
	QuestionDao questionDao;

	@Override
	public void init() {
		daoFactory = new DaoFactory(MyDataSource.DB);
		questionDao = daoFactory.getQuestionDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int projectId = Integer.parseInt(request.getParameter("projectId"));
		
		StringBuilder stringBuilder = new StringBuilder("<html><head><title>Rewards</title></head><body>");
		
		
		
		stringBuilder.append("</body></html>");
		response.getWriter().append(stringBuilder);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
