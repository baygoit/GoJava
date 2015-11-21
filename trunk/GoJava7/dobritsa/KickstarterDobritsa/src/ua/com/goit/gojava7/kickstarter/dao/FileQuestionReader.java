package ua.com.goit.gojava7.kickstarter.dao;

import java.io.File;
import java.io.IOException;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Question;

public class FileQuestionReader extends FileReader<Question> {

	public FileQuestionReader(File file) {
		super(file);
	}

	@Override
	public List<Question> readIt() throws IOException {
		String lineTime;
		while ((lineTime = (fileReader.readLine())) != null) {			
			Question question = new Question();
			question.setTime(lineTime);
			question.setQuestion(fileReader.readLine());
			String lineAnswer;
			if ((lineAnswer = (fileReader.readLine())) != null)				
				question.setAnswer(lineAnswer);
			else
				question.setAnswer("There is no answer yet");
				data.add(question);
		}
		if (data.isEmpty()) {
			data.add(new Question());
		}
		return data;
	}
}
