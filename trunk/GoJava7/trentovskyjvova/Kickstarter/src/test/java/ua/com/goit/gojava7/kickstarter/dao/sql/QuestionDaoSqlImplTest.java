package ua.com.goit.gojava7.kickstarter.dao.sql;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.verify;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.dao.sql.QuestionDaoSqlImpl;
import ua.com.goit.gojava7.kickstarter.domain.Question;

@RunWith(MockitoJUnitRunner.class)
public class QuestionDaoSqlImplTest {
	@Mock
	private JdbcTemplate jdbcTemplate;
	@InjectMocks
	private QuestionDao questionDaoMySqlImpl = new QuestionDaoSqlImpl();
	
	@Test
	@Ignore
	public void testGetQuestions(){

		questionDaoMySqlImpl.getQuestions(1L);
		verify(jdbcTemplate).query(contains("question WHERE projectId = ?"), any(Integer[].class),
				any(BeanPropertyRowMapper.class));
	}
	
	@Test
	@Ignore
	public void testAddQuestion(){

		questionDaoMySqlImpl.addQuestion(new Question());
		verify(jdbcTemplate).update(anyString(), any(Integer.class), anyString());

	}
}
