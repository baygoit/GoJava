package kickstarter.dao.databaseServices;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kickstarter.dao.interfaces.iDAO;
import kickstarter.dao.interfaces.iProjectService;
import kickstarter.entity.Project;

public class DBprojectService implements iProjectService {
	private List<Project> projects;
	private iDatabaseService dbService;

	public DBprojectService(iDatabaseService dbService) {
		this.dbService = dbService;
	}

	@Override
	public void storeProject(Project project) throws SQLException {
		insertProject(project);
		//updateProject(project);

	}
private void updateProject(Project project) throws SQLException{
	PreparedStatement preparedStatement = dbService
			.getConnection()
			.prepareStatement(
					"UPDATE projects ("
							+ "id_project,id_category, name, description, amount, days_to_go, pledged, "
							+ "history, link, short_description) values(?,?,?,?,?,?,?,?,?,?)");
	fillStatement(preparedStatement, project);
}
	@Override
	public List<Project> sortProjectsByCategoryID(int categoryID)
			throws SQLException {
		List<Project> sorted = new ArrayList<Project>();
		Statement statement = dbService.getConnection().createStatement();
		ResultSet rs = statement
				.executeQuery("SELECT id_project,id_category,name,short_description,description,pledged,amount,days_to_go,link,history FROM projects WHERE id_category="
						+ Integer.toString(categoryID));
		while (rs.next()) {
			sorted.add(newProject(rs));
		}
		return sorted;
	}

	@Override
	public int getProjectsLength() throws SQLException {
		Statement statement = dbService.getConnection().createStatement();
		ResultSet rs = statement
				.executeQuery("SELECT COUNT(*) AS rowcount FROM projects");
		rs.next();
		int rowcount = rs.getInt("rowcount");
		return rowcount;
	}

	@Override
	public Project getProjectById(int ID) throws SQLException {

		Statement statement = dbService.getConnection().createStatement();
		ResultSet rs = statement
				.executeQuery("SELECT id_project,id_category,name,short_description,description,pledged,amount,days_to_go,link,history FROM projects WHERE id_project="
						+ Integer.toString(ID));
		rs.next();
		return newProject(rs);

	}

	private Project newProject(ResultSet rs) throws SQLException {
		Project project = new Project();
		project.setID(rs.getInt(1));
		project.setCategoryID(rs.getInt(2));
		project.setName(rs.getString(3));
		project.setShortDescription(rs.getString(4));
		project.setDescription(rs.getString(5));
		project.setPledged(rs.getDouble(6));
		Array amount = rs.getArray(7);
		Double[] a = (Double[]) amount.getArray();
		project.setAmount(a);
		project.setDaysToGo(rs.getInt(8));
		project.setLinkToVideo(rs.getString(9));
		project.setHistory(rs.getString(10));
		return project;
	}

	@Override
	public List<Project> getAll() {
		return projects;
	}

	private void insertProject(Project project) throws SQLException {
		PreparedStatement preparedStatement = dbService
				.getConnection()
				.prepareStatement(
						"INSERT INTO projects ("
								+ "id_project,id_category, name, description, amount, days_to_go, pledged, "
								+ "history, link, short_description) values(?,?,?,?,?,?,?,?,?,?)");
		fillStatement(preparedStatement, project);

	}
	void fillStatement(PreparedStatement preparedStatement,Project project) throws SQLException{
		Array sqlArray = dbService.getConnection().createArrayOf("float8",
				project.getAmount());
		preparedStatement.setInt(1, project.getID());
		preparedStatement.setInt(2, project.getCategoryID());
		preparedStatement.setString(3, project.getName());
		preparedStatement.setString(4, project.getDescription());
		preparedStatement.setArray(5, sqlArray);
		preparedStatement.setInt(6, project.getDaysToGo());
		preparedStatement.setDouble(7, project.getPledged());
		preparedStatement.setString(8, project.getHistory());
		preparedStatement.setString(9, project.getLinkToVideo());
		preparedStatement.setString(10, project.getShortDescription());
		preparedStatement.executeUpdate();
	}

	@Override
	public void createProjects(iDAO sourceDAO) throws SQLException {
		List<Project> projects = sourceDAO.getProjectService().getAll();
		Statement statement = dbService.getConnection().createStatement();
		statement.executeUpdate("DROP TABLE IF EXISTS  projects ");
		statement
				.executeUpdate("CREATE TABLE projects (id_project SERIAL not null PRIMARY KEY,id_category integer, name varchar(255),description varchar(255),amount float8[],days_to_go integer,pledged float8,history varchar(255),link varchar(255),short_description varchar(255))");
		for (Project project : projects) {
			insertProject(project);
		}
	}

}
