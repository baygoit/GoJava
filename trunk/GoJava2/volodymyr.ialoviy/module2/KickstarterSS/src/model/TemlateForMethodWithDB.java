package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.JDBCType;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class TemlateForMethodWithDB {

	private static final String PASS_DB = "7575";//TODO delete duplicate with ATHER CLASS
	private static final String NAME_DB = "postgres";
	private static final String JDBC_POSTGRESQL_PATH = "jdbc:postgresql://127.0.0.1:5432/kickstarter";
	
	public void templateWorkWithDB() {
		Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(JDBC_POSTGRESQL_PATH, NAME_DB, PASS_DB);
            Statement statement = null;
            statement = connection.createStatement();

            logic(statement);

        } catch (Exception ex) {
            Logger.getLogger(JDBCType.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JDBCType.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
	}

	abstract void logic(Statement statement) throws SQLException;
	
//	abstract Object logic(Statement statement) throws SQLException {
//		StringBuilder s = new StringBuilder();
//		ResultSet result = statement.executeQuery("SELECT * FROM categories");
//		while (result.next()) {
//		    s.append(result.getInt("id_category"))
//		    		.append(" ")
//		    		.append(result.getString("name_category"))
//		    		.append("\n").toString();
//		}
//		return s.substring(0, s.length() - 1);
//	}
}
