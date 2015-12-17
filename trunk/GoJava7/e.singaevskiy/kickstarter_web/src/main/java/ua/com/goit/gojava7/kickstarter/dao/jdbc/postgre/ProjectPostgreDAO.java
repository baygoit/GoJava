package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.goit.gojava7.kickstarter.dao.ProjectDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.JdbcDataSource;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.JdbcDispatcher;
import ua.com.goit.gojava7.kickstarter.domain.Project;

public class ProjectPostgreDAO implements ProjectDAO, JdbcDataSource<Project> {

	final static Logger logger = LoggerFactory.getLogger(ProjectPostgreDAO.class);
	
	private static final String TABLE = "project";
	private static final String FIELDS = "id,name,goalSum,startDate,endDate,category_id,description,videoUrl,author";
	private static final String INSERTION = FIELDS.replaceAll("[^,]+", "?");
	private static final String KEY = "id";

	private static final String SELECTION = "   SELECT project.id, project.name, project.goalsum, project.balancesum, project.startdate, project.enddate, "
			+ " project.description, project.videourl, project.author, category.id as category_id, category.name as category_name "
			+ " FROM project left join category " + " ON project.category_id = category.id ";

	private JdbcDispatcher dispatcher;

	public ProjectPostgreDAO(JdbcDispatcher dispatcher) {
		this.dispatcher = dispatcher;
		logger.info("dao created");
	}

	@Override
	public void clear() {
		String sql = "delete from " + TABLE;
		dispatcher.clear(sql);
	}

	@Override
	public Project get(int index) {
		String sql = SELECTION + " where " + TABLE + "." + KEY + " = " + index;
		List<Project> list = dispatcher.get(sql, this);
		Project project = null;
		if (!list.isEmpty()) {
			project = list.get(0);
		}
		return project;
	}

	@Override
	public void add(Project element) {
		String sql = "insert into " + TABLE + " (" + FIELDS + ") values (" + INSERTION + ")";
		dispatcher.add(sql, element, this);
	}

	@Override
	public void addAll(List<Project> elements) {
		String sql = "insert into " + TABLE + " (" + FIELDS + ") values (" + INSERTION + ")";
		dispatcher.add(sql, elements, this);
	}

	@Override
	public List<Project> getAll() {
		String sql = SELECTION;
		List<Project> result = dispatcher.get(sql, this);
		return result;
	}

	@Override
	public List<Project> getByCategory(int categoryId) {
		String sql = SELECTION + " where project.category_id = " + categoryId;
		List<Project> result = dispatcher.get(sql, this);
		return result;
	}

	@Override
	public Project read(ResultSet resultSet) throws SQLException {
		Project project = new Project();
		project.setId(resultSet.getInt("id"));
		project.setName(resultSet.getString("name"));
		project.setAuthor(resultSet.getString("author"));
		project.setDescription(resultSet.getString("description"));
		project.setVideoUrl(resultSet.getString("videoUrl"));
		project.setStartDate(resultSet.getDate("startDate"));
		project.setEndDate(resultSet.getDate("endDate"));
		project.setGoalSum(resultSet.getLong("goalSum"));
		project.setCategoryId(resultSet.getInt("category_id"));
		return project;
	}

	@Override
	public void prepare(Project element, PreparedStatement statement) throws SQLException {
		int i = 0;
		statement.setInt(++i, element.getId());
		statement.setString(++i, element.getName());
		statement.setLong(++i, element.getGoalSum());
		statement.setDate(++i, element.getStartDate());
		statement.setDate(++i, element.getEndDate());
		if (element.getCategoryId() == 0) {
			statement.setNull(++i, java.sql.Types.INTEGER);
		} else {
			statement.setInt(++i, element.getCategoryId());
		}
		statement.setString(++i, element.getDescription());
		statement.setString(++i, element.getVideoUrl());
		statement.setString(++i, element.getAuthor());
	}
}
