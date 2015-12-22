package ua.com.goit.gojava7.kickstarter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ua.com.goit.gojava7.kickstarter.models.Project;


@Component
public class DbDao {

	private static final Logger log = LoggerFactory.getLogger(DbDao.class);

	@Autowired
	private BasicDataSource basicDataSource;

	public DbDao() {
		log.info("Constructor DbManager()...");
	}	

	public void updatePledged(Project project, String query) {
		log.info("<void> updatePledged({}, {})...", project, query);
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
}
