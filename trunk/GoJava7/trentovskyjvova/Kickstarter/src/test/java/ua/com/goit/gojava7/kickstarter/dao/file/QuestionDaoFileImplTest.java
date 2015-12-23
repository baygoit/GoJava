package ua.com.goit.gojava7.kickstarter.dao.file;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.domain.Question;
import ua.com.goit.gojava7.kickstarter.exception.WrongFileFormatException;

public class QuestionDaoFileImplTest {
	private File testQuestionsFile;
	private QuestionDaoFileImpl questionDaoFileImpl;
	private static final String PATH = "./././src/test/resources/";

	@Test
	public void testGetQuestions() {
		testQuestionsFile = new File(PATH + "questions.csv");
		questionDaoFileImpl = new QuestionDaoFileImpl(testQuestionsFile);
		assertThat(questionDaoFileImpl.getQuestions(12).size(), is(1));
	}

	@Test
	public void testGetQuestionsNotQuestionsInFile() {
		testQuestionsFile = new File(PATH + "noquestions.csv");
		questionDaoFileImpl = new QuestionDaoFileImpl(testQuestionsFile);
		assertThat(questionDaoFileImpl.getQuestions(1).size(), is(0));
	}

	@Test(expected = WrongFileFormatException.class)
	public void testGetQuestionsNoQuestionsFile() {
		testQuestionsFile = new File(PATH + "notExistentQuestions.csv");
		questionDaoFileImpl = new QuestionDaoFileImpl(testQuestionsFile);
		questionDaoFileImpl.getQuestions(0);
	}

	@Test
	public void testAddQuestion() throws IOException {
		testQuestionsFile = new File(PATH + "questions.csv");
		questionDaoFileImpl = new QuestionDaoFileImpl(testQuestionsFile);

		Question question = new Question();
		question.setId(1);
		question.setProjectId(12);
		question.setQuestionText("Very stupid question");

		FileWriter fileWriter = new FileWriter(testQuestionsFile, false);
		fileWriter.write("");

		questionDaoFileImpl.addQuestion(question);

		List<Question> questions = questionDaoFileImpl.getQuestions(12);
		assertThat(questions.get(0).getQuestionText(), is("Very stupid question"));
		
		fileWriter.close();
	}
}
