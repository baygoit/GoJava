package ua.com.goit.gojava7.kickstarter.dao.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.QuestionReader;
import ua.com.goit.gojava7.kickstarter.domain.Question;
import ua.com.goit.gojava7.kickstarter.domain.Reward;
import ua.com.goit.gojava7.kickstarter.exception.QuestionReadException;

public class FileQuestionReader implements QuestionReader {
	private static final String CSV_SPLIT_BY = ";";
	private File questionsFile;
	
	public FileQuestionReader(File questionsFile) {
		this.questionsFile = questionsFile;
	}

	@Override
	public List<Question> readQuestions() {
		List<Question> questions = new ArrayList<>();

		BufferedReader fileReader = null;
		try {
			InputStream questionsFileSteam = new FileInputStream(questionsFile);
			fileReader = new BufferedReader(new InputStreamReader(
					questionsFileSteam));

			String line = null;
			int id = 0;
			int projectId = 0;
			String questionText = null;
			while (null != (line = fileReader.readLine())) {
				String[] questionLine = line.split(CSV_SPLIT_BY);
				if (questionLine.length < 3) {
					throw new QuestionReadException("Wrong questions.csv format.");
				} else if (questionLine[0] == "") {
					throw new QuestionReadException(
							"Wrong questions.csv format. Cannot find id");
				} else if (questionLine[1] == "") {
					throw new QuestionReadException(
							"Wrong questions.csv format. Cannot find project id");
				} else if (questionLine[2] == "") {
					throw new QuestionReadException(
							"Wrong questions.csv format. Cannot find text of question");
				}
				id = Integer.parseInt(questionLine[0]);
				projectId = Integer.parseInt(questionLine[1]);
				questionText = questionLine[2];
				
				Question question = new Question(id);
				question.setProjectId(projectId);
				question.setQuestionText(questionText);
				questions.add(question);
			}
		} catch (IOException e) {
			throw new QuestionReadException("File not found or read error", e);
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					System.err.println("Cannot close file " + questionsFile);
				}
			}
		}

		if (questions.isEmpty()) {
			throw new QuestionReadException("There is not questions in file");
		}

		return questions;
	}

}
