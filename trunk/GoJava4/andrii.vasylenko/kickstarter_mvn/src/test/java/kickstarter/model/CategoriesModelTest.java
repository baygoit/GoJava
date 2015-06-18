package kickstarter.model;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;
import kickstarter.model.dao.DAO;
import kickstarter.model.entity.Category;

import org.junit.Test;

public class CategoriesModelTest {
	@Test(expected = IncorrectInputException.class)
	public void shouldException_whenDaoIsNull() throws IncorrectInputException {
		DAO dao = null;
		Model model = new CategoriesModel();
		model.init(dao);
	}

	@Test(expected = IncorrectInputException.class)
	public void shouldException_whenParametersIsNull() throws IncorrectInputException, DataBaseException, SQLException {
		DAO dao = mock(DAO.class);
		Model model = new CategoriesModel();
		model.init(dao);
		model.getData(null);
	}

	@Test
	public void shouldCategories_whenGetData() throws DataBaseException, SQLException, IncorrectInputException {
		Category testCategory1 = new Category(4, "test Category1");
		Category testCategory2 = new Category(6, "test Category2");

		List<Category> expectedCategories = new ArrayList<>();
		expectedCategories.add(testCategory1);
		expectedCategories.add(testCategory2);

		DAO dao = mock(DAO.class);
		when(dao.getCategories()).thenReturn(expectedCategories);

		Model model = new CategoriesModel();
		model.init(dao);
		Map<String, Object> actual = model.getData(new HashMap<String, Object>());

		@SuppressWarnings("unchecked")
		List<Category> actualCategories = (List<Category>) actual.get("categories");
		assertEquals(1, actual.size());
		assertEquals(expectedCategories, actualCategories);
	}
}
