package ua.com.goit.gojava2.solo307.interview;

import java.util.ArrayList;
import java.util.List;

public class StatisticsDTO {

	int correct;
	int halfCorrect;
	int incorrect;

	final String CORRECT = "Правильно отвечено =";
	final String HALF_CORRECT = "Частично правильно отвечено =";
	final String INCORRECT = "Неправильно отвечено =";
	String date = "";
	String duration = "";

	List<String> incorrectAnswers = new ArrayList<String>();

	public void fillIncorrectAnswers(List<Mark> marks) {
		for (Mark mark : marks) {
			if (mark.isIncorrect()) {
				incorrectAnswers.addAll(mark.getIncorrectAnswers());
			}
		}
	}

	public List<String> getStatistics() {
		List<String> stats = new ArrayList<String>();
		stats.add(new String("Дата собеседования: " + date));
		stats.add(new String(CORRECT + " " + correct));
		stats.add(new String(HALF_CORRECT + " " + halfCorrect));
		stats.add(new String(INCORRECT + " " + incorrect));
		stats.add(new String("Длительность: " + duration));
		stats.add(new String("Неправильные ответы: "));
		for (String incorrect : incorrectAnswers) {
			stats.add(new String(incorrect));
		}
		return stats;
	}
	
	public StatisticsDTO evaluateAnswers(StatisticsDTO dto, List<Mark> marks){
		for(Mark mark: marks){
			if(mark.isCorrect())dto.correct++;
			else if(mark.isHalfcorrect())dto.halfCorrect++;
			else if(mark.isIncorrect())dto.incorrect++;
		}
		return dto;
	}

}
