package ua.com.goit.gojava.POM.persistence.postgresDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Currency;
import java.util.Date;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.common.Money;
import ua.com.goit.gojava.POM.dataModel.profitcost.ProfitLostsType;
import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectFinResultEntry;
import ua.com.goit.gojava.POM.persistence.postgresDB.abstraction.AbstractDAO;
import ua.com.goit.gojava.POM.services.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.CostItemService;
import ua.com.goit.gojava.POM.services.ProjectService;
import ua.com.goit.gojava.POM.services.ProjectStageService;


public class ProjectFinResultEntryDAO extends AbstractDAO<ProjectFinResultEntry> {
	
	private static final String CLASS_NAME = "Project FinResult Entry"; 
	private static final String CLASS_TABLE = "project_fin_result"; 
	private static final Logger LOG = Logger.getLogger(ProjectFinResultEntryDAO.class);
	
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
	protected ProjectFinResultEntry getNewObject() {

		return new ProjectFinResultEntry();	
	}

	@Override
	protected ProjectFinResultEntry getObjectFromRS(ResultSet rs) throws SQLException, POMDataModelException {
		
		ProjectFinResultEntry projectFinResultEntry = getNewObject();
		
		projectFinResultEntry.setId(rs.getLong("ID"));
		
		Date date = null;
		Timestamp timestamp = rs.getTimestamp("date");
		if(timestamp != null) {
			date = new Date(timestamp.getTime());
		}
		projectFinResultEntry.setDate(date);
		
		CostItemService costItemService = ApplicationContextProvider.getApplicationContext().getBean(CostItemService.class);
		long costItemId= rs.getLong("cost_item_id");
		if(costItemId != 0) {
			projectFinResultEntry.setCostItem(costItemService.retrieveById(costItemId));;
		}
		ProjectService projectService = ApplicationContextProvider.getApplicationContext().getBean(ProjectService.class);
		long projectId= rs.getLong("project_id");
		if(projectId != 0) {
			projectFinResultEntry.setProject(projectService.retrieveById(projectId));;
		}
		ProjectStageService projectStageService = ApplicationContextProvider.getApplicationContext().getBean(ProjectStageService.class);
		long projectStageId= rs.getLong("project_stage_id");
		if(projectStageId != 0) {
			projectFinResultEntry.setProjectStage(projectStageService.retrieveById(projectStageId));;
		}
		String typeString = rs.getString("profit_type");
		if(typeString != null) {
			projectFinResultEntry.setType(ProfitLostsType.valueOf(typeString));
		}
		
		Currency currency = null;
		String currencyCode = rs.getString("currency");
		if(currencyCode != null) {
			currency = Currency.getInstance(currencyCode);
		}
		projectFinResultEntry.setSum(new Money(rs.getDouble("sum"), currency));;
		
		return projectFinResultEntry;
		
	}

	@Override
	protected void setId(ProjectFinResultEntry projectFinResultEntry, long id) {

		projectFinResultEntry.setId(id);	
	}

	@Override
	protected Long getId(ProjectFinResultEntry projectFinResultEntry) {
		
		return projectFinResultEntry.getId();
	}

	@Override
	protected PreparedStatement getCreateStatement(Connection connection, ProjectFinResultEntry projectFinResultEntry)
			throws SQLException {

		String insertTableSQL = "INSERT INTO "+CLASS_TABLE+" ("
				+ " 	 date "
				+ " 	,cost_item_id "
				+ " 	,project_id "
				+ " 	,project_stage_id "
				+ " 	,sum "
				+ " 	,currency "
				+ " 	,profit_type "
				+ "	   ) "
				+ " VALUES (?,?,?,?,?,?,?) "
				+ "	RETURNING ID "
			;

		PreparedStatement statement = connection.prepareStatement(insertTableSQL);

		java.sql.Timestamp sqlTime = new java.sql.Timestamp(projectFinResultEntry.getDate().getTime());
		Money sum = projectFinResultEntry.getSum();
		
		statement.setTimestamp(1, sqlTime);
		statement.setLong(2, projectFinResultEntry.getCostItem().getId());
		statement.setLong(3, projectFinResultEntry.getProject().getId());
		statement.setLong(4, projectFinResultEntry.getProjectStage().getId());
		statement.setDouble(5, sum.getValue().doubleValue());
		statement.setString(6, sum.getCurrency().getCurrencyCode());
		statement.setString(7, projectFinResultEntry.getType().toString());
		
		return statement;
	}

	@Override
	protected PreparedStatement getUpdateStatement(Connection connection, ProjectFinResultEntry projectFinResultEntry)
			throws SQLException {

		String updateTableSQL = "UPDATE "+CLASS_TABLE
				+ " SET "
				+ " 	 date = ? "
				+ " 	,cost_item_id = ? "
				+ " 	,project_id = ? "
				+ " 	,project_stage_id = ? "
				+ " 	,sum = ? "
				+ " 	,currency = ? "
				+ " 	,profit_type = ? "
				+ "	WHERE ID = ? "
			;

		PreparedStatement statement = connection.prepareStatement(updateTableSQL);
		
		java.sql.Timestamp sqlTime = new java.sql.Timestamp(projectFinResultEntry.getDate().getTime());
		Money sum = projectFinResultEntry.getSum();
		
		statement.setTimestamp(1, sqlTime);
		statement.setLong(2, projectFinResultEntry.getCostItem().getId());
		statement.setLong(3, projectFinResultEntry.getProject().getId());
		statement.setLong(4, projectFinResultEntry.getProjectStage().getId());
		statement.setDouble(5, sum.getValue().doubleValue());
		statement.setString(6, sum.getCurrency().getCurrencyCode());
		statement.setString(7, projectFinResultEntry.getType().toString());
		
		statement.setLong(8,  projectFinResultEntry.getId());
		
		return statement;
		
	}

}
