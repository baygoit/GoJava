package goit.iavorskyi.dao;

import goit.iavorskyi.io.Streamer;
import goit.iavorskyi.learningUnit.Article;

import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDao {

	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet result = null;
	private String databaseUser = "postgres";
	private String databasePassword = "1111";
	private String databaseUrl = "jdbc:postgresql://127.0.0.1:5432/JavaHub";
	private String sqlInsert = "INSERT INTO articles (author, header, linkToText) VALUES (?, ?, ?)";
	private String sqlSelect = "SELECT * FROM articles";
	private String sqlDelete = "DELETE FROM users WHERE id = ?";
	private List<Article> allUsers = new ArrayList<Article>();

	public boolean insert(String author, String header, String linkToText) {
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(databaseUrl, databaseUser, databasePassword);
			preparedStatement = conn.prepareStatement(sqlInsert);
			preparedStatement.setString(1, author);
			preparedStatement.setString(2, header);
			preparedStatement.setString(3, linkToText);
			preparedStatement.execute();
			return true;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				preparedStatement.close();
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

	public List<Article> selectAll() {
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(databaseUrl, databaseUser, databasePassword);
			statement = conn.createStatement();
			result = statement.executeQuery(sqlSelect);
			while (result.next()) {
				Article article = new Article();
				article.setAuthor(result.getString(2).trim());
				article.setHeader(result.getString(3).trim());
				;
				article.setText(Streamer.read(result.getString(4)));
				allUsers.add(article);
			}
			return allUsers;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return allUsers;
		} finally {
			try {
				result.close();
				statement.close();
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

	public void delete(int id) {
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(databaseUrl, databaseUser, databasePassword);
			preparedStatement = conn.prepareStatement(sqlDelete);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException | ClassNotFoundException e2) {
			System.out.println(e2.getMessage());
		} finally {
			try {
				preparedStatement.close();
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

	// private void connectToDatabase() {
	// try {
	// Class.forName("org.postgresql.Driver");
	// } catch (ClassNotFoundException e) {
	// e.printStackTrace();
	// }
	// try {
	// conn = DriverManager.getConnection(databaseUrl, databaseUser,
	// databasePassword);
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// private void closeConnection() {
	// try {
	// conn.close();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// }

	// public void save(String author, String header, String text) {
	// String linkToText = null;
	// linkToText = Streamer.write(text);
	// connectToDatabase();
	// insert(author, header, linkToText);
	// closeConnection();
	// }

}
