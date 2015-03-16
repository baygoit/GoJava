package ua.com.goit.gojava.POM.persistence.postgresDB.abstraction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.persistence.postgresDB.DBDataManager;

public abstract class AbstractDAO<T> {
	
	protected abstract String getClassName(); 
	protected abstract String getClassTable(); 
	protected abstract Logger getLog();
	
	protected abstract T getNewObject();
	protected abstract T getObjectFromRS(ResultSet rs) throws SQLException, POMDataModelException;
	protected abstract void setId(T object, long id);
	protected abstract Long getId(T object);
	protected abstract PreparedStatement getCreateStatement(Connection connection, T object) throws SQLException;
	protected abstract PreparedStatement getUpdateStatement(Connection connection, T object) throws SQLException;
	
	protected Connection getDBConnection() {
		
		return DBDataManager.getConnection();
		
	}
	
	protected void closeDBConnections(ResultSet rs, Statement statement, Connection connection) {
		
		DBDataManager.CloseConnections(rs, statement, connection);
		
	}

	public T create() throws POMDataModelException {

		ResultSet rs = null;
		Statement statement = null; 	
		Connection connection = getDBConnection();
		
		String insertTableSQL = "INSERT INTO "+getClassTable()
								+ " DEFAULT VALUES"
								+ "	RETURNING ID "
								;
		
		T newObject = getNewObject();
		
		try {

			statement = connection.createStatement();
			rs = statement.executeQuery(insertTableSQL);
			 
			if (rs.next()) {
				
				setId(newObject,rs.getLong("ID"));
 				
			}
			
		} catch (SQLException | NullPointerException e) {
 
			getLog().error("Could not create new "+getClassName()+": "+e.getMessage(), e);
			throw new POMDataModelException("Could not create new "+getClassName()+": "+e.getMessage(), e);
 
		} finally {
 
			closeDBConnections(rs, statement, connection);
 
		}
		
		return newObject;
	
	}
	
	public T create(T newObject) throws POMDataModelException {

		ResultSet rs = null;
		PreparedStatement statement = null; 	
		Connection connection = getDBConnection();
		
		try {

			statement = getCreateStatement(connection, newObject);
			
			rs = statement.executeQuery();
			if (rs.next()) {
				setId(newObject, rs.getLong("ID"));
 			}
			
		} catch (SQLException | NullPointerException e) {
 
			getLog().error("Could not create new "+getClassName()+": "+e.getMessage(), e);
			throw new POMDataModelException("Could not create new "+getClassName()+": "+e.getMessage() , e);
 
		} finally {
 
			closeDBConnections(rs, statement, connection);
 
		}
		
		return newObject;
	
	}
	
	public List<T> retrieveAll() throws POMDataModelException {

		List<T> resultList = new ArrayList<T>();
		
		ResultSet rs = null;
		Statement statement = null; 	
		Connection connection = getDBConnection();
		
		String selectTableSQL = "SELECT * FROM "+getClassTable()
							   +" ORDER BY ID"
								;
		
		try {

			statement = connection.createStatement();
			rs = statement.executeQuery(selectTableSQL);
			 
			while (rs.next()) {
				
				T tObject = getObjectFromRS(rs);
				
				resultList.add(tObject);
				
			}
			
		} catch (SQLException e) {
 
			getLog().error("Could not retrieve all "+getClassName()+"s: "+e.getMessage(), e);
			throw new POMDataModelException("Could not retrieve all "+getClassName()+"s: "+e.getMessage(), e);
 
		} finally {
 
			closeDBConnections(rs, statement, connection);
 
		}
		
		return resultList;
	
	}
	
	public T retrieveById(Long id) throws POMDataModelException {

		T result = getNewObject();
		
		ResultSet rs = null;
		PreparedStatement statement = null; 	
		Connection connection = getDBConnection();
		
		String selectTableSQL = " SELECT * FROM "+getClassTable()
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
 
			getLog().error("Could not retrieve "+getClassName()+" by ID: "+e.getMessage(), e);
			throw new POMDataModelException("Could not retrieve "+getClassName()+" by ID: "+e.getMessage() , e);
 
		} finally {
 
			closeDBConnections(rs, statement, connection);
 
		}
		
		return result;
	
	}

	public void update(T tObject) throws POMDataModelException {

		ResultSet rs = null;
		PreparedStatement statement = null;
		Connection connection = getDBConnection();
		
		try {

			statement = getUpdateStatement(connection, tObject);		
			statement.execute();
				
		} catch (SQLException | NullPointerException e) {
 
			getLog().error("Could not update "+getClassName()+": "+e.getMessage(), e);
			throw new POMDataModelException("Could not update "+getClassName()+": "+e.getMessage(), e);
 
		} finally {
 
			closeDBConnections(rs, statement, connection);
 
		}
	
	}
	
	public void delete(T tObject) throws POMDataModelException {

		ResultSet rs = null;
		PreparedStatement statement = null;
		Connection connection = getDBConnection();
		
		String updateTableSQL = "DELETE FROM "+getClassTable()
								+ "	WHERE ID = ? "
								;
		
		try {

			statement = connection.prepareStatement(updateTableSQL);
			statement.setLong(1,  getId(tObject));
			statement.execute();
			
			tObject = null;
				
		} catch (SQLException e) {
 
			getLog().error("Could not delete "+getClassName()+": "+e.getMessage(), e);
			throw new POMDataModelException("Could not delete "+getClassName()+": "+e.getMessage(), e);
 
		} finally {
 
			closeDBConnections(rs, statement, connection);
 
		}
	
	}

}
