package goit.iavorskyi.dao;

import goit.iavorskyi.learningUnit.Article;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAO {

	private Connection conn = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet result = null;
	private String databaseUser = "postgres";
	private String databasePassword = "1111";
	private String databaseUrl = "jdbc:postgresql://127.0.0.1:5432/JavaHub";
	
	private String sqlInsert = "INSERT INTO users (name, surname) VALUES (?, ?)";
	private String sqlSelect = "SELECT * FROM users";
	private String sqlDelete = "DELETE FROM users WHERE id = ?";
	private List<Article> allUsers = new ArrayList<Article>();

	public void connectToDatabase() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(databaseUrl, databaseUser,
					databasePassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean insert(String author, String header, String pathToArticle) {
		try {
			preparedStatement = conn.prepareStatement(sqlInsert);
			preparedStatement.setString(1, author);
			preparedStatement.setString(2, header);
			preparedStatement.setString(3, pathToArticle);
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Article> selectAll() {
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(sqlSelect);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			while (result.next()) {
				Article article = new Article();
				article.setAuthor(result.getString(2).trim());
				article.setLinkToText(result.getString(3).trim());;
				allUsers.add(article);
			}
			return allUsers;
		} catch (SQLException e) {
			e.printStackTrace();
			return allUsers;
		}
	}

	public void delete(int id) {
		try {
			preparedStatement = conn.prepareStatement(sqlDelete);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e2) {
			System.out.println(e2.getMessage());
		}
	}
	
	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}
