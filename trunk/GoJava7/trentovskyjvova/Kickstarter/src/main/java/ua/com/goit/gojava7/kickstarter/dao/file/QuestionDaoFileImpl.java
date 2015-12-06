package ua.com.goit.gojava7.kickstarter.dao.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.domain.Question;
import ua.com.goit.gojava7.kickstarter.exception.WrongFileFormatException;

public class QuestionDaoFileImpl implements QuestionDao {
	private static final String CSV_SPLIT_BY = ";";
	private File questionsFile;

	public QuestionDaoFileImpl(File questionsFile) {
		this.questionsFile = questionsFile;
	}

	@Override
	public List<Question> getQuestions(int projectId) {
		List<Question> questions = new ArrayList<>();

		BufferedReader fileReader = null;
		try {
			InputStream questionsFileSteam = new FileInputStream(questionsFile);
			fileReader = new BufferedReader(new InputStreamReader(
					questionsFileSteam));

			String line = null;
			int id = 0;
			String questionText = null;
			while (null != (line = fileReader.readLine())) {
				String[] questionLine = line.split(CSV_SPLIT_BY);
				if (questionLine.length < 3) {
					throw new WrongFileFormatException(
							"Wrong questions.csv format.");
				} else if (questionLine[0] == "") {
					throw new WrongFileFormatException(
							"Wrong questions.csv format. Cannot find id");
				} else if (questionLine[1] == "") {
					throw new WrongFileFormatException(
							"Wrong questions.csv format. Cannot find project id");
				} else if (questionLine[2] == "") {
					throw new WrongFileFormatException(
							"Wrong questions.csv format. Cannot find text of question");
				}
				if (projectId != 0
						&& projectId != Integer.parseInt(questionLine[1])) {
					continue;
				}
				id = Integer.parseInt(questionLine[0]);
				questionText = questionLine[2];

				Question question = new Question();
				question.setId(id);
				question.setProjectId(projectId);
				question.setQuestionText(questionText);
				questions.add(question);
			}
		} catch (IOException e) {
			throw new WrongFileFormatException("File not found or read error",
					e);
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					System.err.println("Cannot close file " + questionsFile);
				}
			}
		}

		return questions;
	}

	@Override
	public void addQuestion(Question question) {
		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter(questionsFile, true);

			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(generateIdOfNewElement()).append(";");
			stringBuilder.append(question.getProjectId()).append(";");
			stringBuilder.append(question.getQuestionText()).append(";");
			stringBuilder.append("\n");

			fileWriter.write(stringBuilder.toString().toString());

		} catch (IOException e) {
			throw new WrongFileFormatException("File not found or read error",
					e);
		} finally {
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					System.err.println("Cannot close file " + questionsFile);
				}
			}
		}

	}

	private int generateIdOfNewElement() {
		int maxId = 0;
		for (Question question : getQuestions(0)) {
			if (maxId < question.getId()) {
				maxId = question.getId();
			}
		}
		return maxId + 1;
	}

}
