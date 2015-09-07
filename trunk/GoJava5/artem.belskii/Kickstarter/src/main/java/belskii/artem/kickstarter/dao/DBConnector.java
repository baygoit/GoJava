package belskii.artem.kickstarter.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Properties;

import org.apache.tomcat.jdbc.pool.DataSource;

public class DBConnector {
	private DataSource ds;
	private Connection conn;
	private String configFileName = "";

	public DBConnector(String configFileName) {
		this.configFileName = configFileName;
	}

	public Connection getConnection() {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource(configFileName).getFile());
			input = new FileInputStream(file);
			prop.load(input);

			conn = this.prepareConnection(prop.getProperty("host"), new Integer(prop.getProperty("port")),
					prop.getProperty("user"), prop.getProperty("pass"), prop.getProperty("db"));
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return conn;
	}

	private Connection prepareConnection(String host, int port, String user, String pass, String db) {

		Connection connection = null;
		ds = new DataSource();
		ds.setDriverClassName("org.postgresql.Driver");
		String url = MessageFormat.format("jdbc:postgresql://{0}:{1,number,#}", host, port);
		if (db != null && !db.isEmpty())
			url += "/" + db;
		ds.setUrl(url);
		ds.setUsername(user);
		ds.setPassword(pass);
		ds.setDefaultAutoCommit(false);
		try {
			connection = ds.getConnection();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void test() {
		Connection conn = this.prepareConnection("localhost", 5432, "root", "Vsyfrf;tvpkj", "kickstarter");
		String query = "select * from quotes";
		try (PreparedStatement statement = conn.prepareStatement(query)) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("TEXT"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
