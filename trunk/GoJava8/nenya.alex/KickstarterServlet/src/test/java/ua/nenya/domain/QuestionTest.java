package ua.nenya.domain;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Test;

public class QuestionTest {

	private Question question = new Question();
	@Before
	public void init() {
		question.setName("?");
		question.setId(1);
		question.setProjectId(1);
	}
	@Test
	public void testGetName() {
		assertThat(question.getName(), is("?"));
		assertThat(question.getId(), is(1));
		assertThat(question.getProjectId(), is(1));
	}

}
