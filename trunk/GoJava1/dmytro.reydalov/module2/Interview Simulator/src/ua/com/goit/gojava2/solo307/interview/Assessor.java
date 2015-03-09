package ua.com.goit.gojava2.solo307.interview;

import java.util.List;
import java.util.Set;

public class Assessor {

	public static List<Mark> getMarks(String[] answers) {
		Interview interview = new Interview();
		try {
			interview.createCategories();
		} catch (InterviewSimulatorException e) {
			e.getMessage();
		}
		Category composed = interview.getComposedCategory();
		Set<Integer> answerIds = composed.parseIds(answers);
		Set<Question> reconstructed = composed.getQuestionsById(answerIds);
		List<Mark> marks = composed.getMarks(reconstructed, answerIds);
		return marks;
	}

}
