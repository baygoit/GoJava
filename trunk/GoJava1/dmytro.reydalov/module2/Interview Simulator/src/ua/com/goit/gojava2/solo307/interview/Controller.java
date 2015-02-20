package ua.com.goit.gojava2.solo307.interview;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		String [] answers = request.getParameterValues("answer");
		Interview interview = new Interview();
		File file = new File("Questions.xml.");
		interview.addCategory("Questions", file.getAbsolutePath());
		File file2 = new File("MeratechTest.xml.");
		interview.addCategory("Questions1", file2.getAbsolutePath());
		Category composed = interview.getComposedCategory();
		List<Integer> answerIds = composed.parseIds(answers);
		int correctAnswers = composed.countCorrectAnswers(answerIds);
		out.println("Anwered correct: " + correctAnswers);
	}

	
}
