package ua.com.goit.gojava.POM.persistence.postgresDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.profitcost.CostItem;
import ua.com.goit.gojava.POM.dataModel.profitcost.ProfitLostsType;
import ua.com.goit.gojava.POM.persistence.postgresDB.abstraction.AbstractDAO;

public class CostItemDAO extends AbstractDAO<CostItem> {
	
	private static final String CLASS_NAME = "Cost Item"; 
	private static final String CLASS_TABLE = "cost_items"; 
	private static final Logger LOG = Logger.getLogger(CostItemDAO.class);
	
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
	protected CostItem getNewObject() {

		return new CostItem();	
	}

	@Override
	protected CostItem getObjectFromRS(ResultSet rs) throws SQLException, POMDataModelException {
		
		CostItem costItem = getNewObject();
		
		costItem.setId(rs.getLong("ID"));
		costItem.setName(rs.getString("name"));
		
		String typeString = rs.getString("type");
		if(typeString != null) {
			costItem.setType(ProfitLostsType.valueOf(typeString));
		}
		
		long parentID = rs.getLong("parent");
		if(parentID != 0) {
			costItem.setParent(retrieveById(parentID));
		}
		
		return costItem;
		
	}

	@Override
	protected void setId(CostItem costItem, long id) {

		costItem.setId(id);	
	}

	@Override
	protected Long getId(CostItem costItem) {
		
		return costItem.getId();
	}

	@Override
	protected PreparedStatement getCreateStatement(Connection connection, CostItem costItem)
			throws SQLException {

		String insertTableSQL = "INSERT INTO "+CLASS_TABLE+" ("
				+ " 	 name "
				+ " 	,type "
				+ " 	,parent "
				+ "	   ) "
				+ " VALUES (?,?,?) "
				+ "	RETURNING ID "
			;

		PreparedStatement statement = connection.prepareStatement(insertTableSQL);
		statement.setString(1, costItem.getName());
		statement.setString(2, costItem.getType().toString());
		long parentId = costItem.getParentId();
		if(parentId != 0) {
			statement.setLong(3, parentId);
		} else {
			statement.setNull(3, java.sql.Types.NULL);
		}
		
		return statement;
	}

	@Override
	protected PreparedStatement getUpdateStatement(Connection connection, CostItem costItem)
			throws SQLException {

		String updateTableSQL = "UPDATE "+CLASS_TABLE
				+ " SET "
				+ " 	 name = ? "
				+ " 	,type = ? "
				+ " 	,parent = ? "
				+ "	WHERE ID = ? "
				;

		PreparedStatement statement = connection.prepareStatement(updateTableSQL);
		statement = connection.prepareStatement(updateTableSQL);
		statement.setString(1, costItem.getName());
		statement.setString(2, costItem.getType().toString());
		long parentId = costItem.getParentId();
		if(parentId != 0) {
			statement.setLong(3, parentId);
		} else {
			statement.setNull(3, java.sql.Types.NULL);
		}statement.setLong(4,  costItem.getId());
		
		return statement;
		
	}

}
