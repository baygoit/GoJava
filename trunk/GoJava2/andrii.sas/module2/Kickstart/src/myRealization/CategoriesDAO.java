package myRealization;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CategoriesDAO implements Categories {

	private Connection connection;
	private String nameOfDB;
	
	public CategoriesDAO(String nameOfDB) {
		this.nameOfDB = nameOfDB;
	}
	
	@Override
	public void addCategory(Category category) {
		try {
			Class.forName("org.postgresql.Driver");
			try {
				connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + nameOfDB, "postgres", "gfhfien17");
				Statement statement = connection.createStatement();
				statement.setQueryTimeout(30);
				statement.execute("insert into categories (name) values (\'" + category.getName() + "\')");
			} catch (SQLException e) {
				throw new RuntimeException("Connection Failed! Check output console", e);
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Problems with JDBC driver!!!", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException("Can't close connection");
			}
		}
	}

	@Override
	public String getCategories() {
		try {
			Class.forName("org.postgresql.Driver");
			try {
				connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + nameOfDB, "postgres", "gfhfien17");
				Statement statement = connection.createStatement();
				statement.setQueryTimeout(30);
				ResultSet rs = statement.executeQuery("select * from categories");
				String result = "";
				int index = 1;
				while (rs.next()){
					String lastPart = getLenth() == index ? "" : ", ";
					result += index + " - " + rs.getString("name") + lastPart;
					index++;
				}
				return result;
			} catch (SQLException e) {
				throw new RuntimeException("Connection Failed! Check output console", e);
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Problems with JDBC driver!!!", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException("Can't close connection");
			}
		}
	}
	
	public static void main(String[] args){
		CategoriesDAO categoriesDAO = new CategoriesDAO("kickstarter_db");
		Category category = categoriesDAO.readCategory(1);
		System.out.println(category.toString());
		System.out.println(categoriesDAO.getLenth());
		System.out.println(categoriesDAO.getCategories());
	}

	@Override
	public Category readCategory(int index) {
		try {
			Class.forName("org.postgresql.Driver");
			try {
				Category category = null;
				connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + nameOfDB, "postgres", "gfhfien17");
				Statement statement = connection.createStatement();
				statement.setQueryTimeout(30);
				ResultSet rs = statement.executeQuery("select * from categories");
				int i = 0;
				while (rs.next()) {
					if (index == i){
						category = new Category(rs.getInt("id"), rs.getString("name"));
					}
					i++;
				}
				return category;
			} catch (SQLException e) {
				throw new RuntimeException("Connection Failed! Check output console", e);
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Problems with JDBC driver!!!", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException("Can't close connection");
			}
		}
	}

	@Override
	public int getLenth() {
		try {
			Class.forName("org.postgresql.Driver");
			try {
				int size = 0;
				connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + nameOfDB, "postgres", "gfhfien17");
				Statement statement = connection.createStatement();
				statement.setQueryTimeout(30);
				ResultSet rs = statement.executeQuery("select count(*) from categories");
				while (rs.next()) {
					size = rs.getInt(1);
				}
				return size;
			} catch (SQLException e) {
				throw new RuntimeException("Connection Failed! Check output console", e);
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Problems with JDBC driver!!!", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException("Can't close connection");
			}
		}
	}
	
	public void deleteData() {
		try {
			Class.forName("org.postgresql.Driver");
			try {
				connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + nameOfDB, "postgres", "gfhfien17");
				Statement statement = connection.createStatement();
				statement.setQueryTimeout(30);
				statement.execute("delete from categories");
			} catch (SQLException e) {
				throw new RuntimeException("Connection Failed! Check output console", e);
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Problems with JDBC driver!!!", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException("Can't close connection");
			}
		}
	}
}
