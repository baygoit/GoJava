package ua.com.goit.gojava.solo307.intersim.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava.solo307.intersim.domain.Category;
import ua.com.goit.gojava.solo307.intersim.domain.Interview;
import ua.com.goit.gojava.solo307.intersim.domain.InterviewSimulatorDomainException;
import ua.com.goit.gojava.solo307.intersim.domain.Question;

@WebServlet("/Composer")
public class Composer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String[] categories = request.getParameterValues("category");
		long start = System.currentTimeMillis();
		Interview interview = new Interview();
		interview.addTime(start);
		try {
			interview.createCategories(categories);
		} catch (InterviewSimulatorDomainException e) {
			e.getMessage();
		}
		Category composed = interview.getComposedCategory();
		List<Question> questions = composed.getQuestions();
		request.setAttribute("questions", questions);
		request.getRequestDispatcher("interview.jsp")
				.forward(request, response);
	}
}
