package ua.com.goit.gojava.solo307.intersim.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class QuestionTest {
	List<Answer> answers = new ArrayList<Answer>();
	List<Answer> markedAnswers = new ArrayList<Answer>();
	Question question;

	@Before
	public void setUp() throws Exception {
		answers.add(new Answer(1, "answer1", true, 1));
		answers.add(new Answer(2, "answer2", false, 2));
		question = new Question("question", answers, 1, 1);
		question.addMarkedAnswer(new Answer(1, "answer1", true, 1));
		question.addMarkedAnswer(new Answer(2, "answer2", false, 2));
	}

	@Test
	public void testHasNextId() {
		final int EXISTING = 1;
		final int NON_EXISTING = 3;
		assertTrue(question.hasNextId(EXISTING));
		assertFalse(question.hasNextId(NON_EXISTING));
	}

	@Test
	public void testFindAnswerById() {
		final int ID = 2;
		Answer expected = question.getAnswers().get(1);
		try {
			assertEquals(question.findAnswerById(ID), expected);
		} catch (InterviewSimulatorDomainException e) {
			e.getMessage();
		}
	}

	@Test(expected = InterviewSimulatorDomainException.class)
	public void testFindAnswerByIdInsertWrongId()
			throws InterviewSimulatorDomainException {
		final int ID = 3;
		question.findAnswerById(ID);
	}

	@Test
	public void testCountMarkedCorrectAnswers() {
		final int expected = 1;
		assertEquals(question.countMarkedCorrectAnswers(), expected);
	}

	@Test
	public void testCountCorrectAnswers() {
		final int expected = 1;
		assertEquals(question.countCorrectAnswers(), expected);
	}

	@Test
	public void testHasIncorrectAnswer() {
		assertTrue(question.hasIncorrectAnswer());
	}

	@Test
	public void testEvaluateMarkTestHalfCorrect() {
		List<Answer> customAnswers = new ArrayList<Answer>();
		customAnswers.add(new Answer(1, "answer1", true, 1));
		customAnswers.add(new Answer(2, "answer2", true, 2));
		Question customQuestion = new Question("question", customAnswers, 1, 1);
		customQuestion.addMarkedAnswer(new Answer(1, "answer1", true, 1));
		customQuestion.addMarkedAnswer(new Answer(2, "answer2", false, 2));
		customQuestion.evaluateMark();
		assertTrue(customQuestion.getMark().isHalfcorrect());
	}

	@Test
	public void testEvaluateMarkTestCorrect() {
		List<Answer> customAnswers = new ArrayList<Answer>();
		customAnswers.add(new Answer(1, "answer1", true, 1));
		customAnswers.add(new Answer(2, "answer2", true, 2));
		Question customQuestion = new Question("question", customAnswers, 1, 1);
		customQuestion.addMarkedAnswer(new Answer(1, "answer1", true, 1));
		customQuestion.addMarkedAnswer(new Answer(2, "answer2", true, 2));
		customQuestion.evaluateMark();
		assertTrue(customQuestion.getMark().isCorrect());
	}

	@Test
	public void testEvaluateMarkTestIncorrect() {
		List<Answer> customAnswers = new ArrayList<Answer>();
		customAnswers.add(new Answer(1, "answer1", true, 1));
		customAnswers.add(new Answer(2, "answer2", true, 2));
		Question customQuestion = new Question("question", customAnswers, 1, 1);
		customQuestion.addMarkedAnswer(new Answer(1, "answer1", false, 1));
		customQuestion.addMarkedAnswer(new Answer(2, "answer2", false, 2));
		customQuestion.evaluateMark();
		assertTrue(customQuestion.getMark().isIncorrect());
	}
}
