package ua.nenya.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class QuestionServlet extends CommonServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String projectIndexStr = request.getParameter("projectIndex");
		String categoryIndexStr = request.getParameter("categoryIndex");
		
		int projectIndex = 0;
		int categoryIndex = 0;
		try {
			projectIndex = Integer.parseInt(projectIndexStr);
			categoryIndex = Integer.parseInt(categoryIndexStr);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		request.setAttribute("categoryIndex", categoryIndex);
		request.setAttribute("projectIndex", projectIndex);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/question.jsp");
		dispatcher.forward(request, response);
		

	}


}
