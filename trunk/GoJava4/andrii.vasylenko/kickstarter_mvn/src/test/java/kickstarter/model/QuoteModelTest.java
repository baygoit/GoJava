package kickstarter.model;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;
import kickstarter.model.dao.DAO;
import kickstarter.model.entity.Quote;

import org.junit.Test;

public class QuoteModelTest {
	@Test(expected = IncorrectInputException.class)
	public void shouldException_whenDaoIsNull() throws IncorrectInputException {
		DAO dao = null;
		Model model = new QuoteModel();
		model.init(dao);
	}

	@Test(expected = IncorrectInputException.class)
	public void shouldException_whenParametersIsNull() throws IncorrectInputException, DataBaseException, SQLException {
		DAO dao = mock(DAO.class);
		Model model = new QuoteModel();
		model.init(dao);
		model.getData(null);
	}

	@Test
	public void shouldQuote_whenGetData() throws DataBaseException, SQLException, IncorrectInputException {
		Quote expectedQuote = new Quote(3, "test random quote");
		DAO dao = mock(DAO.class);
		when(dao.getRandomQuote()).thenReturn(expectedQuote);

		Model model = new QuoteModel();
		model.init(dao);
		Map<String, Object> actual = model.getData(new HashMap<String, Object>());

		Quote actualQuote = (Quote) actual.get("quote");
		assertEquals(1, actual.size());
		assertEquals(expectedQuote.getQuote(), actualQuote.getQuote());
	}
}
