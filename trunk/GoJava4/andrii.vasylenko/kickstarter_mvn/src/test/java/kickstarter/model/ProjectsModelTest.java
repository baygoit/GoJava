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
import kickstarter.model.entity.Project;

import org.junit.Test;

public class ProjectsModelTest {
	@Test(expected = IncorrectInputException.class)
	public void shouldException_whenDaoIsNull() throws IncorrectInputException {
		DAO dao = null;
		Model model = new ProjectsModel();
		model.init(dao);
	}

	@Test(expected = IncorrectInputException.class)
	public void shouldException_whenParametersIsNull() throws IncorrectInputException, DataBaseException, SQLException {
		DAO dao = mock(DAO.class);
		Model model = new ProjectsModel();
		model.init(dao);
		model.getData(null);
	}

	@Test(expected = IncorrectInputException.class)
	public void shouldException_whenParametersIsEmpty() throws IncorrectInputException, DataBaseException, SQLException {
		DAO dao = mock(DAO.class);

		HashMap<String, Object> parameters = new HashMap<String, Object>();

		Model model = new ProjectsModel();
		model.init(dao);
		model.getData(parameters);
	}

	@Test(expected = IncorrectInputException.class)
	public void shouldException_whenParameterСategoryIsNull() throws IncorrectInputException, DataBaseException,
			SQLException {
		DAO dao = mock(DAO.class);

		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("category", null);

		Model model = new ProjectsModel();
		model.init(dao);
		model.getData(parameters);
	}

	@Test
	public void shouldCategories_whenGetData() throws DataBaseException, SQLException, IncorrectInputException {
		int categoryId = 1;
		Project testProject1 = new Project(6, categoryId, "test name1", "test description", 111, 11, "test history",
				"test link", new ArrayList<String>(), 22);
		Project testProject2 = new Project(8, categoryId, "test name2", "test description", 111, 11, "test history",
				"test link", new ArrayList<String>(), 22);

		List<Project> expectedProjects = new ArrayList<>();
		expectedProjects.add(testProject1);
		expectedProjects.add(testProject2);

		DAO dao = mock(DAO.class);
		when(dao.getProjects(anyInt())).thenReturn(expectedProjects);

		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("category", categoryId);

		Model model = new ProjectsModel();
		model.init(dao);
		Map<String, Object> actual = model.getData(parameters);

		@SuppressWarnings("unchecked")
		List<Project> actualProjects = (List<Project>) actual.get("projects");
		assertEquals(1, actual.size());
		assertEquals(expectedProjects, actualProjects);
	}
}
