package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

public class ConnectionToDBTest {

	
	@Test
	public void test() {
		
		Properties properties = new Properties();
		properties.setProperty("user", "postgres");
		properties.setProperty("password", "root");
		
		properties.setProperty("useUnicode", "true");
		properties.setProperty("characterEncoding", "UTF-8");
		properties.setProperty("ssl","true");
			
		String url = "jdbc:postgresql://localhost/testingDB";

		try (Connection con = DriverManager.getConnection(url, properties);) {

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from simple_question");

			while (rs.next()) {
				System.out.println("id= " + rs.getInt(1) + ", content= "
						+ rs.getString(2) + ", standartAnswer= "
						+ rs.getString(3));
			}
			System.out.println("Connection fine!");

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
				
	}

}
