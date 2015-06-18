package kickstarter.model;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import kickstarter.exception.DataBaseException;
import kickstarter.exception.IncorrectInputException;
import kickstarter.model.dao.DAO;
import kickstarter.model.entity.Project;

import org.junit.Test;

public class ProjectModelTest {
	@Test(expected = IncorrectInputException.class)
	public void shouldException_whenDaoIsNull() throws IncorrectInputException {
		DAO dao = null;
		Model model = new ProjectModel();
		model.init(dao);
	}

	@Test(expected = IncorrectInputException.class)
	public void shouldException_whenParametersIsNull() throws IncorrectInputException, DataBaseException, SQLException {
		DAO dao = mock(DAO.class);
		Model model = new ProjectModel();
		model.init(dao);
		model.getData(null);
	}

	@Test(expected = IncorrectInputException.class)
	public void shouldException_whenParametersIsEmpty() throws IncorrectInputException, DataBaseException, SQLException {
		DAO dao = mock(DAO.class);

		HashMap<String, Object> parameters = new HashMap<String, Object>();

		Model model = new ProjectModel();
		model.init(dao);
		model.getData(parameters);
	}

	@Test(expected = IncorrectInputException.class)
	public void shouldException_whenParameterProjectIsNull() throws IncorrectInputException, DataBaseException,
			SQLException {
		DAO dao = mock(DAO.class);

		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("project", null);
		parameters.put("category", 1);

		Model model = new ProjectModel();
		model.init(dao);
		model.getData(parameters);
	}

	@Test(expected = IncorrectInputException.class)
	public void shouldException_whenParameterСategoryIsNull() throws IncorrectInputException, DataBaseException,
			SQLException {
		DAO dao = mock(DAO.class);

		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("project", 1);
		parameters.put("category", null);

		Model model = new ProjectModel();
		model.init(dao);
		model.getData(parameters);
	}

	@Test
	public void shouldCategories_whenGetData() throws DataBaseException, SQLException, IncorrectInputException {
		int projectId = 3;
		int categoryId = 1;
		Project expectedProject = new Project(projectId, categoryId, "test name1", "test description", 111, 11,
				"test history", "test link", new ArrayList<String>(), 22);

		DAO dao = mock(DAO.class);
		when(dao.getProject(anyInt(), anyInt())).thenReturn(expectedProject);

		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("project", projectId);
		parameters.put("category", categoryId);

		Model model = new ProjectModel();
		model.init(dao);
		Map<String, Object> actual = model.getData(parameters);

		Project actualProject = (Project) actual.get("project");
		assertEquals(1, actual.size());
		assertEquals(expectedProject, actualProject);
	}
}
