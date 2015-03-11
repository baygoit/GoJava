package ua.com.goit.gojava.POM.persistence.postgresDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.profitcost.Project;
import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectType;
import ua.com.goit.gojava.POM.persistence.postgresDB.abstraction.AbstractDAO;

public class ProjectDAO extends AbstractDAO<Project> {
	
	private static final String CLASS_NAME = "Project"; 
	private static final String CLASS_TABLE = "projects"; 
	private static final Logger LOG = Logger.getLogger(ProjectDAO.class);
	
	@Override
	protected String getClassName() {
		
		return CLASS_NAME;
	}

	@Override
	protected String getClassTable() {

		return CLASS_TABLE;
	}

	@Override
	protected Logger getLog() {
		
		return LOG;	
	}

	@Override
	protected Project getNewObject() {

		return new Project();	
	}

	@Override
	protected Project getObjectFromRS(ResultSet rs) throws SQLException {
		
		Project project = getNewObject();
		
		project.setId(rs.getLong("ID"));
		project.setName(rs.getString("name"));
		project.setDescription(rs.getString("description"));
		String typeString = rs.getString("type");
		if(typeString != null) {
			project.setType(ProjectType.valueOf(typeString));
		}
		project.setActive(rs.getBoolean("active"));
		project.setPm(rs.getString("pm"));
		
		return project;	
	}

	@Override
	protected void setId(Project project, long id) {

		project.setId(id);	
	}

	@Override
	protected Long getId(Project project) {
		
		return project.getId();
	}

	@Override
	protected PreparedStatement getCreateStatement(Connection connection, Project project)
			throws SQLException {

		String insertTableSQL = "INSERT INTO "+CLASS_TABLE+" ("
				+ " 	 name "
				+ " 	,description "
				+ " 	,type "
				+ " 	,active "
				+ " 	,pm "
				+ "	   ) "
				+ " VALUES (?,?,?,?,?) "
				+ "	RETURNING ID "
			;
		
		PreparedStatement statement = connection.prepareStatement(insertTableSQL);
		statement.setString(1, project.getName());
		statement.setString(2, project.getDescription());
		statement.setString(3, project.getType().toString());
		statement.setBoolean(4, project.isActive());
		statement.setString(5, project.getPm());
		
		return statement;
	}

	@Override
	protected PreparedStatement getUpdateStatement(Connection connection, Project project)
			throws SQLException {

		String updateTableSQL = "UPDATE "+CLASS_TABLE
				+ " SET "
				+ " 	 name = ? "
				+ " 	,description = ? "
				+ " 	,type = ? "
				+ " 	,active = ? "
				+ " 	,pm = ? "
				+ "	WHERE ID = ? "
				;
		
		PreparedStatement statement = connection.prepareStatement(updateTableSQL);
		statement.setString(1, project.getName());
		statement.setString(2, project.getDescription());
		statement.setString(3, project.getType().toString());
		statement.setBoolean(4, project.isActive());
		statement.setString(5, project.getPm());
		statement.setLong(6, project.getId());
		
		return statement;
	}

}
