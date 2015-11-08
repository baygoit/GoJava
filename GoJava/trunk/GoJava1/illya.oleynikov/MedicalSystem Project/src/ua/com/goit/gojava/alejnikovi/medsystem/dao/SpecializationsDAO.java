package ua.com.goit.gojava.alejnikovi.medsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import ua.com.goit.gojava.alejnikovi.medsystem.MedicalSystemException;
import ua.com.goit.gojava.alejnikovi.medsystem.Specialization;

public class SpecializationsDAO {
	
	private DataSource ds;
	
	public SpecializationsDAO() throws MedicalSystemException {
		try {
			InitialContext cxt = new InitialContext();
			ds = (DataSource) cxt.lookup("java:comp/env/jdbc/Med_System");
		} catch (Exception e) {
			throw new MedicalSystemException("Set Connection problem" + e);
		} 
	}
	
	private Specialization setUpSpec(ResultSet rs) throws MedicalSystemException{
		Specialization result = new Specialization();
		try {
			result.setId(rs.getInt("id"));
			result.setName(rs.getString("spec_name"));
		} catch (SQLException e) {
			throw new MedicalSystemException("Problem with set up");
		}
		return result;		
	}
	
	public void update(Specialization spec) throws MedicalSystemException{
		Connection connection = null;
		PreparedStatement statement = null;
		String insert = "UPDATE specializations SET spec_name=? WHERE id=?;";
		
		try {
			connection = ds.getConnection();
			statement = connection.prepareStatement(insert);
			statement.setString(1, spec.getName());
			statement.setInt(2, spec.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new MedicalSystemException("SQL problem", e);
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				throw new MedicalSystemException("Closing connection problem");
			}
		}
	}
	
	public void persist(Specialization spec) throws MedicalSystemException{
		Connection connection = null;
		PreparedStatement statement = null;
		String insert = "INSERT INTO specializations (spec_name) VALUES (?);";
		
		try {
			connection = ds.getConnection();
			statement = connection.prepareStatement(insert);
			statement.setString(1, spec.getName());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new MedicalSystemException("SQL problem", e);
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				throw new MedicalSystemException("Closing connection problem");
			}
		}
		
	}
	
	public List<Specialization> getAll() throws MedicalSystemException{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Specialization> allSpecs = new ArrayList<Specialization>();
		String loadAll = "SELECT * FROM specializations;";

		try {
			connection = ds.getConnection();
			statement = connection.prepareStatement(loadAll);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				allSpecs.add(setUpSpec(resultSet));
			}
		} catch (SQLException e) {
			throw new MedicalSystemException("SQL problem", e);
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				throw new MedicalSystemException("Closing connection problem");
			}
		}
		
		return allSpecs;
	}
	
	public void deleteById(int id) throws MedicalSystemException{
		Connection connection = null;
		PreparedStatement statement = null;
		String delete = "DELETE FROM specializations WHERE id = ?;";
		
		try {
			connection = ds.getConnection();
			statement = connection.prepareStatement(delete);
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new MedicalSystemException("SQL problem", e);
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				throw new MedicalSystemException("Closing connection problem");
			}
		}
	}
	

	
}
