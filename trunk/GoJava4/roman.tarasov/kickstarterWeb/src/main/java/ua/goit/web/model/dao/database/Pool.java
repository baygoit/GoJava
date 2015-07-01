package ua.goit.web.model.dao.database;

import javax.sql.DataSource;

import org.springframework.stereotype.Component;

@Component
public class Pool {
	private static DataSource dataSource = null;

	public static DataSource getDataSource() {
		return dataSource;
	}

	public  void setDataSource(DataSource dataSource) {
		Pool.dataSource = dataSource;
	}
}
