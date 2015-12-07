package ua.com.goit.gojava7.kickstarter.DAO.fileStorage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import ua.com.goit.gojava7.kickstarter.DAO.AbstractQuestionStorage;
import ua.com.goit.gojava7.kickstarter.model.Question;

public class QuestionFileStorage extends AbstractQuestionStorage {

	private static int idGenerator;
	private File questionFile;
	List<String> questionLines;

	public QuestionFileStorage() {
		idGenerator = 0;
		questionFile = new File("./resources/questions.csv");
		questionLines = new ArrayList<>();
		ReadFile();
	}

	private void ReadFile() {
		try {
			questionLines = FileUtils.readLines(questionFile);
			if (questionLines.size() > 0) {
				String[] id = questionLines.get(questionLines.size() - 1).split(";");
				idGenerator = Integer.parseInt(id[0]);
			}
		} catch (IOException e) {
			System.err.println("CSV file reading error");
		}
	}

	@Override
	public List<Question> getAll() {
		ReadFile();
		List<Question> allQuestions = new ArrayList<>();

		for (String questionLine : questionLines) {
			String[] splittedQuestionLine = questionLine.split(";");
			Question question = new Question();
			question.setIdQuestion(Integer.parseInt(splittedQuestionLine[0]));
			question.setIdParentProject(Integer.parseInt(splittedQuestionLine[1]));
			question.setQuestion(splittedQuestionLine[2]);
			allQuestions.add(question);
		}
		return allQuestions;
	}

	@Override
	public void add(Question question) {
		StringBuilder questionLine = new StringBuilder(++idGenerator + ";");
		questionLine.append(question.getIdParentProject() + ";");
		questionLine.append(question.getQuestion() + "\n");

		try {
			FileUtils.writeStringToFile(questionFile, questionLine.toString(), true);
		} catch (IOException e) {
			System.err.println("CSV file writting error");
		}

	}

}
