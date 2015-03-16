package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Component;

@Component
public class ProjectsDAO extends DAO {
	@Autowired
	public DataSource dataSource;
	private Connection connection;

	private LinkedList<Project> projects = new LinkedList<Project>();

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public LinkedList<Project> getProjectsList(int categoryId) {
		ResultSet resultSet = getResultSet("SELECT * FROM projects WHERE category_id = "
				+ categoryId);
		try {
			while (resultSet.next()) {
				projects.add(new Project(resultSet.getString("name"), resultSet
						.getString("description"),
						resultSet.getInt("need_sum"), resultSet
								.getInt("current_sum"), resultSet
								.getInt("days_left"), resultSet
								.getString("project_history"), resultSet
								.getString("link_on_video"), resultSet
								.getString("questions_and_answers")));
			}
			return projects;
		} catch (SQLException e) {
			new RuntimeException("SQLException " + e);
		}
		return projects;
	}

	protected ResultSet getResultSet(String sql) {
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			return resultSet;
		} catch (SQLException e) {
			new RuntimeException("SQLException " + e);
		}
		return resultSet;
	}

}
