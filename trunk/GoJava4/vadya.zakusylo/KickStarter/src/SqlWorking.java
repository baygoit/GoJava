package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlWorking {

	String user = "root";
	String password = "root";
	String driver = "com.mysql.jdbc.Driver";

	public static void main(String[] args) {
		SqlWorking sql = new SqlWorking();
		try {
			sql.go();
		} catch (SQLException e) {
			System.out.println("¡Û‚‡∫\n" + e);
		}
	}

	private void go() throws SQLException {
		try {
			Class.forName(driver);

			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/kickstarter", user, password);
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("Select * from category");
			while (rs.next()) {
				System.out.println(rs.getString(2));
			}
			rs = st.executeQuery("Select project, category from project natural join category");
			while (rs.next()) {
				System.out.println(rs.getString(2) + "\t\t" + rs.getString(1));
			}
		} catch (ClassNotFoundException e) {
			System.out.println("¡Û‚‡∫\n" + e);
		}
	}

}
