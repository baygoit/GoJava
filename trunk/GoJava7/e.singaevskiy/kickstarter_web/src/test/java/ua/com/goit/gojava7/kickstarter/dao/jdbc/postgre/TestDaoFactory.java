package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import ua.com.goit.gojava7.kickstarter.util.Utils;

public class TestDaoFactory {
	public static JdbcTemplate setupJdbcTemplate() {
		Properties properties = Utils.readProperties("./src/test/resources/storages/db/config.properties");
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
        BasicDataSource datasource = new BasicDataSource();
		datasource.setDriverClassName(properties.getProperty("driver"));
		datasource.setUrl(properties.getProperty("url"));
		datasource.setUsername(properties.getProperty("user"));
		datasource.setPassword(properties.getProperty("password"));
		jdbcTemplate.setDataSource(datasource);
		return jdbcTemplate;
	}
}
