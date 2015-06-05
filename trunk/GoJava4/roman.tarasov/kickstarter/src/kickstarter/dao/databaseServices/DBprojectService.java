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
		updateProject(project);
	}

	private void updateProject(Project project) throws SQLException {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("UPDATE projects set ");
		buffer.append("id_project=? , ");
		buffer.append("id_category=? , ");
		buffer.append("name=? , ");
		buffer.append("short_description=? , ");
		buffer.append("description=? , ");
		buffer.append("pledged=? , ");
		buffer.append("amount=? , ");
		buffer.append("days_to_go=? , ");
		buffer.append("link=? , ");
		buffer.append("history=? , ");
		buffer.append("invest_options=? ");
		buffer.append("WHERE id_project=");
		buffer.append(Integer.toString(project.getID()));

		PreparedStatement preparedStatement = dbService.getConnection()
				.prepareStatement(buffer.toString());
		fillStatement(preparedStatement, project);
	}

	@Override
	public List<Project> sortProjectsByCategoryID(int categoryID)
			throws SQLException {
		List<Project> sorted = new ArrayList<Project>();
		Statement statement = dbService.getConnection().createStatement();
		StringBuffer buffer = new StringBuffer();

		buffer.append("SELECT ");
		buffer.append("id_project, ");
		buffer.append("id_category, ");
		buffer.append("name, ");
		buffer.append("short_description, ");
		buffer.append("description, ");
		buffer.append("pledged, ");
		buffer.append("amount, ");
		buffer.append("days_to_go, ");
		buffer.append("link, ");
		buffer.append("history,");
		buffer.append("invest_options ");
		buffer.append("FROM projects ");
		buffer.append("WHERE id_category=");
		buffer.append(Integer.toString(categoryID));

		ResultSet rs = statement.executeQuery(buffer.toString());
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
		StringBuffer buffer = new StringBuffer();

		buffer.append("SELECT ");
		buffer.append("id_project, ");
		buffer.append("id_category, ");
		buffer.append("name, ");
		buffer.append("short_description, ");
		buffer.append("description, ");
		buffer.append("pledged, ");
		buffer.append("amount, ");
		buffer.append("days_to_go, ");
		buffer.append("link, ");
		buffer.append("history, ");
		buffer.append("invest_options ");
		buffer.append("FROM projects ");
		buffer.append("WHERE id_project=");
		buffer.append(Integer.toString(ID));

		ResultSet rs = statement.executeQuery(buffer.toString());
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
		Array investOptions = rs.getArray(11);
		String[]str=(String[])investOptions.getArray();
		project.setInvestmentOptions(str);
		return project;
	}

	@Override
	public List<Project> getAll() {
		return projects;
	}

	private void insertProject(Project project) throws SQLException {
		StringBuffer buffer = new StringBuffer();

		buffer.append("INSERT INTO projects ");
		buffer.append("(");
		buffer.append("id_project, ");
		buffer.append("id_category, ");
		buffer.append("name, ");
		buffer.append("short_description, ");
		buffer.append("description, ");
		buffer.append("pledged, ");
		buffer.append("amount, ");
		buffer.append("days_to_go, ");
		buffer.append("link, ");
		buffer.append("history, ");
		buffer.append("invest_options");
		buffer.append(")");
		buffer.append("VALUES");
		buffer.append("(?,?,?,?,?,?,?,?,?,?,?)");

		PreparedStatement preparedStatement = dbService.getConnection()
				.prepareStatement(buffer.toString());
		fillStatement(preparedStatement, project);
	}

	void fillStatement(PreparedStatement ps, Project project)
			throws SQLException {

		ps.setInt(1, project.getID());
		ps.setInt(2, project.getCategoryID());
		ps.setString(3, project.getName());
		ps.setString(4, project.getShortDescription());
		ps.setString(5, project.getDescription());
		ps.setDouble(6, project.getPledged());
		Array sqlArray = dbService.getConnection().createArrayOf("float8",
				project.getAmount());
		ps.setArray(7, sqlArray);
		ps.setInt(8, project.getDaysToGo());
		ps.setString(9, project.getLinkToVideo());
		ps.setString(10, project.getHistory());
		sqlArray = dbService.getConnection().createArrayOf("varchar",
				project.getInvestmentOptions());
		ps.setArray(11, sqlArray);
		ps.executeUpdate();
	}

	@Override
	public void createProjects(iDAO sourceDAO) throws SQLException {
		List<Project> projects = sourceDAO.getProjectService().getAll();
		Statement statement = dbService.getConnection().createStatement();
		statement.executeUpdate("DROP TABLE IF EXISTS  projects ");
		StringBuffer buffer = new StringBuffer();

		buffer.append("CREATE TABLE projects");
		buffer.append("(");
		buffer.append("id_project SERIAL not null PRIMARY KEY,");
		buffer.append("id_category integer,");
		buffer.append("name varchar(255),");
		buffer.append("short_description varchar(255),");
		buffer.append("description varchar(255),");
		buffer.append("pledged float8,");
		buffer.append("amount float8[],");
		buffer.append("days_to_go integer,");
		buffer.append("link varchar(255),");
		buffer.append("history varchar(255),");
		buffer.append("invest_options varchar(255)[]");
		buffer.append(")");

		statement
				.executeUpdate(buffer.toString());
		for (Project project : projects) {
			insertProject(project);
		}
	}

}
