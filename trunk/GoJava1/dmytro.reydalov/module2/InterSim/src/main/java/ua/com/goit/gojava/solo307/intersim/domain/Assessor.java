package ua.com.goit.gojava.solo307.intersim.domain;

import java.util.Set;

import ua.com.goit.gojava.solo307.intersim.commons.InterviewSimulatorCommonsException;
import ua.com.goit.gojava.solo307.intersim.commons.StatisticsTraveler;
import ua.com.goit.gojava.solo307.intersim.commons.TimeCounter;

public class Assessor {

	public static Set<Question> getReconstructedQuestions(String[] answers) {
		Interview interview = new Interview();
		interview.fillCategories();
		Category composed = interview.getComposedCategory();
		Set<Integer> answerIds = composed.parseIds(answers);
		Set<Question> reconstructed = composed.getQuestionsById(answerIds);
		composed.evaluateMarks(reconstructed);
		return reconstructed;
	}

	public static StatisticsTraveler getStatisticsTraveler(String[] answers) {
		Set<Question> reconstructed = getReconstructedQuestions(answers);
		StatisticsTraveler traveller = new StatisticsTraveler(reconstructed);
		Interview interview = new Interview();
		long start = interview.getStartTime();
		String time = "";
		try {
			time = TimeCounter.getTime(start);
		} catch (InterviewSimulatorCommonsException e) {
			e.printStackTrace();
		}
		traveller.setDuration(time);
		traveller.setDate(TimeCounter.getCurrentTime());
		traveller.evaluateAnswers(traveller, reconstructed);
		return traveller;
	}
}
