package ua.com.goit.gojava.POM.persistence.postgresDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.profitcost.CostItem;
import ua.com.goit.gojava.POM.dataModel.profitcost.ProfitLostsType;

public class CostItemDAO {
	
	private static final String CLASS_TABLE = "cost_items"; 
	private static final Logger LOG=Logger.getLogger(CostItemDAO.class);
	
	private Connection getDBConnection() {
		
		return DBDataManager.getConnection();
		
	}
	
	private void closeDBConnections(ResultSet rs, Statement statement, Connection connection) {
		
		DBDataManager.CloseConnections(rs, statement, connection);
		
	}

	
	private CostItem getObjectFromRS(ResultSet rs) throws SQLException, POMDataModelException {
		
		CostItem costItem = new CostItem();
		
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

	public CostItem create() throws POMDataModelException {

		ResultSet rs = null;
		Statement statement = null; 	
		Connection connection = getDBConnection();
		
		String insertTableSQL = "INSERT INTO "+CLASS_TABLE
								+ " DEFAULT VALUES"
								+ "	RETURNING ID "
								;
		
		CostItem costItem = new CostItem();
		
		try {

			statement = connection.createStatement();
			rs = statement.executeQuery(insertTableSQL);
			 
			if (rs.next()) {
				
				costItem.setId(rs.getLong("ID"));
 				
			}
			
		} catch (SQLException | NullPointerException e) {
 
			LOG.error("Could not create new Cost Item: "+e.getMessage(), e);
			throw new POMDataModelException("Could not create new Cost Item: "+e.getMessage(), e);
 
		} finally {
 
			closeDBConnections(rs, statement, connection);
 
		}
		
		return costItem;
	
	}
	
	public CostItem create(CostItem costItem) throws POMDataModelException {

		ResultSet rs = null;
		PreparedStatement statement = null; 	
		Connection connection = getDBConnection();
		
		String insertTableSQL = "INSERT INTO "+CLASS_TABLE+" ("
										+ " 	 name "
										+ " 	,type "
										+ " 	,parent "
										+ "	   ) "
										+ " VALUES (?,?,?) "
										+ "	RETURNING ID "
														;
		
		try {

			statement = connection.prepareStatement(insertTableSQL);
			statement.setString(1, costItem.getName());
			statement.setString(2, costItem.getType().toString());
			long parentId = costItem.getParentId();
			if(parentId != 0) {
				statement.setLong(3, parentId);
			} else {
				statement.setNull(3, java.sql.Types.NULL);
			}
			
			rs = statement.executeQuery();
			if (rs.next()) {
				costItem.setId(rs.getLong("ID"));
 			}
			
		} catch (SQLException | NullPointerException e) {
 
			LOG.error("Could not create new Cost Item: "+e.getMessage(), e);
			throw new POMDataModelException("Could not create new Cost Item: "+e.getMessage() , e);
 
		} finally {
 
			closeDBConnections(rs, statement, connection);
 
		}
		
		return costItem;
	
	}
	
	public List<CostItem> retrieveAll() throws POMDataModelException {

		List<CostItem> resultList = new ArrayList<CostItem>();
		
		ResultSet rs = null;
		Statement statement = null; 	
		Connection connection = getDBConnection();
		
		String selectTableSQL = "SELECT * FROM "+CLASS_TABLE
							   +" ORDER BY ID"
								;
		
		try {

			statement = connection.createStatement();
			rs = statement.executeQuery(selectTableSQL);
			 
			while (rs.next()) {
				
				CostItem costItem = getObjectFromRS(rs);
				
				resultList.add(costItem);
				
			}
			
		} catch (SQLException e) {
 
			LOG.error("Could not retrieve all Cost Items: "+e.getMessage(), e);
			throw new POMDataModelException("Could not retrieve all Cost Items: "+e.getMessage(), e);
 
		} finally {
 
			closeDBConnections(rs, statement, connection);
 
		}
		
		return resultList;
	
	}
	
	public CostItem retrieveById(Long id) throws POMDataModelException {

		CostItem result = new CostItem();
		
		ResultSet rs = null;
		PreparedStatement statement = null; 	
		Connection connection = getDBConnection();
		
		String selectTableSQL = " SELECT * FROM "+CLASS_TABLE
							  + " WHERE ID = ? "
								;
		
		try {

			statement = connection.prepareStatement(selectTableSQL);
			statement.setLong(1, id);
			rs = statement.executeQuery();
			 
			if (rs.next()) {
				
				result = getObjectFromRS(rs);
				
			}
			
		} catch (SQLException e) {
 
			LOG.error("Could not retrieve Cost Item by ID: "+e.getMessage(), e);
			throw new POMDataModelException("Could not retrieve Cost Item by ID: "+e.getMessage() , e);
 
		} finally {
 
			closeDBConnections(rs, statement, connection);
 
		}
		
		return result;
	
	}

	public void update(CostItem costItem) throws POMDataModelException {

		ResultSet rs = null;
		PreparedStatement statement = null;
		Connection connection = getDBConnection();
		
		String updateTableSQL = "UPDATE "+CLASS_TABLE
								+ " SET "
								+ " 	 name = ? "
								+ " 	,type = ? "
								+ " 	,parent = ? "
								+ "	WHERE ID = ? "
								;
		
		try {

			statement = connection.prepareStatement(updateTableSQL);
			statement.setString(1, costItem.getName());
			statement.setString(2, costItem.getType().toString());
			long parentId = costItem.getParentId();
			if(parentId != 0) {
				statement.setLong(3, parentId);
			} else {
				statement.setNull(3, java.sql.Types.NULL);
			}statement.setLong(4,  costItem.getId());
			
			statement.execute();
				
		} catch (SQLException | NullPointerException e) {
 
			LOG.error("Could not update Cost Item: "+e.getMessage(), e);
			throw new POMDataModelException("Could not update Cost Item: "+e.getMessage(), e);
 
		} finally {
 
			closeDBConnections(rs, statement, connection);
 
		}
	
	}
	
	public void delete(CostItem costItem) throws POMDataModelException {

		ResultSet rs = null;
		PreparedStatement statement = null;
		Connection connection = getDBConnection();
		
		String updateTableSQL = "DELETE FROM "+CLASS_TABLE
								+ "	WHERE ID = ? "
								;
		
		try {

			statement = connection.prepareStatement(updateTableSQL);
			statement.setLong(1,  costItem.getId());
			
			statement.execute();
			
			costItem = null;
				
		} catch (SQLException e) {
 
			LOG.error("Could not delete Cost Item: "+e.getMessage(), e);
			throw new POMDataModelException("Could not delete Cost Item: "+e.getMessage(), e);
 
		} finally {
 
			closeDBConnections(rs, statement, connection);
 
		}
	
	}

}
