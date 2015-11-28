package ua.com.goit.gojava7.kickstarter.dao.file;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;

import ua.com.goit.gojava7.kickstarter.domain.Question;
import ua.com.goit.gojava7.kickstarter.exception.WrongFileFormatException;

public class TestFileQuestionReader {
	private File testQuestionsFile;
	@InjectMocks
	private FileQuestionReader fileQuestionReader;

	@Test
	public void testGetQuestions() {
		testQuestionsFile = new File("./resources/questions.csv");
		fileQuestionReader = new FileQuestionReader(testQuestionsFile);
		assertThat(fileQuestionReader.getQuestions(12).size(), is(1));
	}

	@Test
	public void testGetQuestionsNotQuestionsInFile() {
		testQuestionsFile = new File("./resources/noquestions.csv");
		fileQuestionReader = new FileQuestionReader(testQuestionsFile);
		assertThat(fileQuestionReader.getQuestions(1).size(), is(0));
	}

	@Test(expected = WrongFileFormatException.class)
	public void testGetQuestionsNoQuestionsFile() {
		testQuestionsFile = new File("./resources/notExistentQuestions.csv");
		fileQuestionReader = new FileQuestionReader(testQuestionsFile);
		fileQuestionReader.getQuestions(0);
	}
	
	@Test
	public void testAddQuestion() throws IOException{		 
		testQuestionsFile = new File("./resources/questions.csv");
		fileQuestionReader = new FileQuestionReader(testQuestionsFile);
		 
		Question question = new Question();
		question.setId(1);
		question.setProjectId(12);
		question.setQuestionText("Very stupid question");
		
		FileWriter fileWriter = new FileWriter(testQuestionsFile, false);
		fileWriter.write("");
		
		fileQuestionReader.addQuestion(question);
	       
		List<Question> questions = fileQuestionReader.getQuestions(12);
		assertThat(questions.get(0).getQuestionText(), is("Very stupid question"));
 
	}
}
