package ua.com.goit.gojava.POM.persistence.postgresDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectStage;
import ua.com.goit.gojava.POM.persistence.postgresDB.abstraction.AbstractDAO;
import ua.com.goit.gojava.POM.services.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.ProjectService;

public class ProjectStageDAO extends AbstractDAO<ProjectStage> {
	
	private static final String CLASS_NAME = "Project Stage"; 
	private static final String CLASS_TABLE = "project_stages"; 
	private static final Logger LOG = Logger.getLogger(ProjectStageDAO.class);
	
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
	protected ProjectStage getNewObject() {

		return new ProjectStage();	
	}

	@Override
	protected ProjectStage getObjectFromRS(ResultSet rs) throws SQLException, POMDataModelException {
		
		ProjectStage projectStage = getNewObject();
		
		projectStage.setId(rs.getLong("ID"));
		projectStage.setName(rs.getString("name"));
		projectStage.setDescription(rs.getString("description"));
		
		ProjectService projectService = ApplicationContextProvider.getApplicationContext().getBean(ProjectService.class);
		long parentId = rs.getLong("parent");
		if(parentId != 0) {
			projectStage.setParent(projectService.retrieveById(parentId));
		}
		
		return projectStage;	
	}

	@Override
	protected void setId(ProjectStage projectStage, long id) {

		projectStage.setId(id);	
	}

	@Override
	protected Long getId(ProjectStage projectStage) {
		
		return projectStage.getId();
	}

	@Override
	protected PreparedStatement getCreateStatement(Connection connection, ProjectStage projectStage)
			throws SQLException {

		String insertTableSQL = "INSERT INTO "+CLASS_TABLE+" ("
				+ " 	 name "
				+ " 	,description "
				+ " 	,parent "
				+ "	   ) "
				+ " VALUES (?,?,?) "
				+ "	RETURNING ID "
			;
		
		PreparedStatement statement = connection.prepareStatement(insertTableSQL);
		statement.setString(1, projectStage.getName());
		statement.setString(2, projectStage.getDescription());
		statement.setLong(3, projectStage.getParent().getId());
		
		return statement;
	}

	@Override
	protected PreparedStatement getUpdateStatement(Connection connection, ProjectStage projectStage)
			throws SQLException {

		String updateTableSQL = "UPDATE "+CLASS_TABLE
				+ " SET "
				+ " 	 name = ? "
				+ " 	,description = ? "
				+ " 	,parent = ? "
				+ "	WHERE ID = ? "
				;
		
		PreparedStatement statement = connection.prepareStatement(updateTableSQL);
		statement.setString(1, projectStage.getName());
		statement.setString(2, projectStage.getDescription());
		statement.setLong(3, projectStage.getParent().getId());
		statement.setLong(4, projectStage.getId());
		
		return statement;
	}

}
