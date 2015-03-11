package ua.com.goit.gojava2.solo307.interview;

import java.util.Set;

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
		long start = Interview.readStartTime();
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
