package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.dao.DaoFactory;
import ua.com.goit.gojava7.kickstarter.dao.MyDataSource;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;

@WebServlet("/paymentsuccessful")
public class PaymentSuccessfulServlet extends HttpServlet {

	DaoFactory daoFactory;
	ProjectDao projectDao;

	@Override
	public void init() {
		MyDataSource dataType = (MyDataSource) getServletContext().getAttribute("mode");
		daoFactory = new DaoFactory(dataType);
		projectDao = daoFactory.getProjectDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String card = request.getParameter("card");
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		int amount =  Integer.parseInt(request.getParameter("amount"));
		int pledgedOld = projectDao.get(projectId).getPledged();
		
		projectDao.updatePledged(projectDao.get(projectId), amount);
		int pledgedNew = projectDao.get(projectId).getPledged();
		request.setAttribute("pledgedOld", pledgedOld);	
		request.setAttribute("pledgedNew", pledgedNew);	
		request.setAttribute("project", projectDao.get(projectId));	
		request.setAttribute("amount", amount);	
		request.getRequestDispatcher("/WEB-INF/jsp/paymentsuccessful.jsp").forward(request, response);		
		doGet(request, response);
	}

}
