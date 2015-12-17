package ua.com.goit.gojava7.kickstarter.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.dao.QuoteDbDao;

@RunWith(MockitoJUnitRunner.class)
public class QuoteDbDaoTest {

	@Mock
	private ResultSet resultSet;
	@Mock
	PreparedStatement statement;
	@InjectMocks
	QuoteDbDao quoteDao;

	@Test
	public void testReadElement() throws SQLException {
		when(resultSet.getString("text")).thenReturn("TestQuote");
		assertThat(quoteDao.readElement(resultSet).getText(), is("TestQuote"));
	}
}
