package ua.com.goit.gojava7.kickstarter.dao.db;

import static org.mockito.Mockito.when;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.models.Question;

@RunWith(MockitoJUnitRunner.class)
public class QuestionDbDaoTest {

	@Mock
	private ResultSet resultSet;	
	@Mock
	PreparedStatement statement;
	@InjectMocks
	QuestionDbDao questionDao;
	
	@Test
	public void testReadElement() throws SQLException {
		when(resultSet.getString("time")).thenReturn("Today");		
		assertThat(questionDao.readElement(resultSet).getTime(), is("Today"));		
	}
	
	@Test
	public void testWriteElement() throws SQLException {
		Question question = new Question();
		questionDao.writeElement(question, statement);
		verify(statement).setString(1, question.getTime());
	}
	
}
