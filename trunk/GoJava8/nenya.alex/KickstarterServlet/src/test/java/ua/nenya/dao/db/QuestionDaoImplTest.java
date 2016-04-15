package ua.nenya.dao.db;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import ua.nenya.domain.Project;
import ua.nenya.domain.Question;

@RunWith(MockitoJUnitRunner.class)
public class QuestionDaoImplTest {

	@Mock
	private JdbcTemplate jdbcTemplate;
	@InjectMocks
	private QuestionDaoImpl questionDaoImpl;

	private Project newSongProject;
	private List<Question> questions;

	@Before
	public void init() {
		questions = new ArrayList<>();
		newSongProject = new Project();
		newSongProject.setName("New Song");
		Question question = new Question();
		question.setName("Who?");
		questions.add(question);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testGetQuestions() throws SQLException {
		when(jdbcTemplate.query(anyString(), new Object[] { anyString() }, Matchers.any(BeanPropertyRowMapper.class)))
				.thenReturn(questions);

		List<Question> testQuestions = questionDaoImpl.getQuestions("New Song");
		assertThat(testQuestions.get(0).getName(), is("Who?"));

	}

	@Test
	public void testWriteQuestionInProject() throws SQLException {

	}

}
