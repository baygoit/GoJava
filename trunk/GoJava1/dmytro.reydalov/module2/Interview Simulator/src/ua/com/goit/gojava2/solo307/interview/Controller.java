package ua.com.goit.gojava2.solo307.interview;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String [] answers = request.getParameterValues("answer");
		Interview interview = new Interview();
		try {
			interview.createCategories();
		} catch (InterviewSimulatorException e) {
			e.getMessage();
		}
		Category composed = interview.getComposedCategory();
		Set <Integer> answerIds = composed.parseIds(answers);
		Set <Question> reconstructed = composed.getQuestionsById(answerIds);
		List <Mark> marks = composed.getMarks(reconstructed, answerIds);
		request.setAttribute("stat", marks);
		long startTime = IO.readStartTime();
		long endTime = TimeCounter.getTime();
		long difference = TimeCounter.elapsedTime(startTime, endTime);
		long seconds = TimeCounter.calculateSeconds(difference);
		String time = "";
		try {
			time = TimeCounter.formatIntoMMSS(seconds);
			request.setAttribute("time", time);
		} catch (InterviewSimulatorException e) {
			e.getMessage();
		}
		List <String> statistics = composed.getStatistics();
		statistics.add(new String("test duration: " + time));
		IO.writeToFile("Dmitro", statistics);
	    request.getRequestDispatcher("stats.jsp").forward(request,response);
	}
}
