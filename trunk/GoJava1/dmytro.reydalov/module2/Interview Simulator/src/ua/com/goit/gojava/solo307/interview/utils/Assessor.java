package ua.com.goit.gojava.solo307.interview.utils;

import java.util.Set;

import ua.com.goit.gojava.solo307.interview.domain.Category;
import ua.com.goit.gojava.solo307.interview.domain.Interview;
import ua.com.goit.gojava.solo307.interview.domain.Question;

public class Assessor {

	public static Set<Question> getReconstructedQuestions(String[] answers) {
		Interview interview = new Interview();
		try {
			interview.createCategories();
		} catch (InterviewSimulatorException e) {
			e.getMessage();
		}
		Category composed = interview.getComposedCategory();
		Set<Integer> answerIds = composed.parseIds(answers);
		Set<Question> reconstructed = composed.getQuestionsById(answerIds);
		composed.evaluateMarks(reconstructed);
		return reconstructed;
	}

	public static StatisticsDTO getStatisticsDTO(String[] answers) {
		Set<Question> reconstructed = getReconstructedQuestions(answers);
		StatisticsDTO dto = new StatisticsDTO(reconstructed);
		Interview interview = new Interview();
		long start = interview.getStartTime();
		String time = "";
		try {
			time = TimeCounter.getTime(start);
		} catch (InterviewSimulatorException e) {
			e.printStackTrace();
		}
		dto.setDuration(time);
		dto.setDate(TimeCounter.getCurrentTime());
		dto.evaluateAnswers(dto, reconstructed);
		return dto;
	}
}
