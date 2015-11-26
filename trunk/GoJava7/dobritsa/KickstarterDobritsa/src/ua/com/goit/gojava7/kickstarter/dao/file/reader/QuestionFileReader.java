package ua.com.goit.gojava7.kickstarter.dao.file.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Question;

public class QuestionFileReader extends FileReader<Question> {

	public QuestionFileReader(File file) {
		super(file);
	}
 
	@Override
	public List<Question> readFromFile(BufferedReader bufferedReader) throws IOException {
		String lineTime;
		while ((lineTime = (bufferedReader.readLine())) != null) {					
			Question question = new Question();
			question.setTime(lineTime);
			question.setQuestion(bufferedReader.readLine());
			String lineAnswer;
			if ((lineAnswer = (bufferedReader.readLine())) != null)				
				question.setAnswer(lineAnswer);
			else
				question.setAnswer("There is no answer yet");
				data.add(question);
		}
		
		//TODO if Empty
		if (data.isEmpty()) {
			data.add(new Question());
		}
		return data;
	}
}
