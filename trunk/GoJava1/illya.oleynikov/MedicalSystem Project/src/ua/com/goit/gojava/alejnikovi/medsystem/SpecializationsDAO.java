package ua.com.goit.gojava.alejnikovi.medsystem;

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

public class SpecializationsDAO {
	
	private DataSource ds;
	private Connection con;
	
	public SpecializationsDAO() {
		
	}
	
	private void setUpConnection() throws MedicalSystemException{
		InitialContext cxt;
		try {
			cxt = new InitialContext();
		} catch (NamingException e1) {
			throw new MedicalSystemException("Context problem");
		}
		try {			
			ds = (DataSource) cxt.lookup("java:comp/env/jdbc/Med_System");
		} catch (Exception e) {
			throw new MedicalSystemException("Datasource problem");
		}
		try {
			con = ds.getConnection();
		} catch (Exception e) {
			throw new MedicalSystemException("Connection problem" + e);
		} 
	}
		
	
	public List<String> getAll() throws MedicalSystemException{
		setUpConnection();
		Connection connection = con;
		PreparedStatement getAll = null;
		List<String> allSpec = new ArrayList<String>();
		String loadAllSQL = "SELECT * FROM specializations;";

		try {
			getAll = connection.prepareStatement(loadAllSQL);
			ResultSet specsRS = getAll.executeQuery();
			while(specsRS.next()){
				allSpec.add(specsRS.getString("spec_name"));
			}
		} catch (SQLException e) {
			throw new MedicalSystemException("SQL problem", e);
		} finally {
			try {
				getAll.close();
				connection.close();
			} catch (SQLException e) {
				throw new MedicalSystemException("Closing connection problem");
			}
		}
		
		return allSpec;
	}
	

	
}
