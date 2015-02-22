package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.JDBCType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoriesFromDB implements Categories{

	private static final String PASS_DB = "7575";//TODO delete duplicate with ATHER CLASS
	private static final String NAME_DB = "postgres";
	private static final String JDBC_POSTGRESQL_PATH = "jdbc:postgresql://127.0.0.1:5432/kickstarter";

	public static void main(String[] args) {
		CategoriesFromDB cat = new CategoriesFromDB();
		Projects projects = new ProjectsFromFile();
		System.out.println(cat.showAllCatecoriesInKickstarter());
		System.out.println(cat.showAllProjectInCategory(1, projects));
		System.out.println(cat.showCatecoryName(2));
		System.out.println(Arrays.toString(cat.getKickCategories()));
		System.out.println(Arrays.toString(cat.projectsThatAreContainedInTheCategory(1)));
	}
	
	@Override
	public void writeAllCatecories() {
	}

	@Override
	public String showAllCatecoriesInKickstarter() {
		StringBuilder s = new StringBuilder();
		Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(JDBC_POSTGRESQL_PATH, NAME_DB, PASS_DB);
            Statement statement = null;
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM categories");
            while (result.next()) {
                s.append(result.getInt("id_category"))
                		.append(" ")
                		.append(result.getString("name_category"))
                		.append("\n").toString();
            }
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
		return s.substring(0, s.length() - 1);
	}

	@Override
	public String showAllProjectInCategory(int categoryId, Projects projects) {
		StringBuilder s = new StringBuilder();
		Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(JDBC_POSTGRESQL_PATH, NAME_DB, PASS_DB);
            Statement statement = null;
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM projects WHERE id_category =" + categoryId + "ORDER BY id_project");
            while (result.next()) {
                s.append(result.getInt("id_project"))
                	.append(", ").append(result.getString("name_project"))
					.append(", ").append(result.getString("short_description_project"))
					.append(", ").append(result.getString("how_much_needed_project"))
					.append(", ").append(result.getString("how_much_collected_project"))
					.append("\n").toString();
            }
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
		return s.substring(0, s.length() - 1);
	}

	@Override
	public String showCatecoryName(int categoryId) {
		StringBuilder s = new StringBuilder();
		Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(JDBC_POSTGRESQL_PATH, NAME_DB, PASS_DB);
            Statement statement = null;
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM categories WHERE id_category =" + categoryId);
            while (result.next()) {
                s.append(result.getString("name_category")).toString();
            }
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
		return s.toString();
	}


	@Override
	public int[] getKickCategories() {
		Connection connection = null;
		ArrayList<Integer> array = new ArrayList<Integer>();
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(JDBC_POSTGRESQL_PATH, NAME_DB, PASS_DB);
            Statement statement = null;
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM categories");
            while (result.next()) {
            	array.add(result.getInt("id_category"));
            }
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
        int[] a = new int[array.size()];
        int j = 0;
        for (Integer i : array){
        	a[j] = i;
        	j++;
        }
		return a;
	}

	@Override
	public int[] projectsThatAreContainedInTheCategory(int categoryId) {
		Connection connection = null;
		ArrayList<Integer> array = new ArrayList<Integer>();
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(JDBC_POSTGRESQL_PATH, NAME_DB, PASS_DB);
            Statement statement = null;
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT id_category, id_project FROM projects WHERE id_category =" + categoryId + "ORDER BY id_project");
            while (result.next()) {
            	array.add(result.getInt("id_project"));
            }
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
        int[] a = new int[array.size()];
        int j = 0;
        for (Integer i : array){
        	a[j] = i;
        	j++;
        }
		return a;
	}

	@Override
	public int getCounterCategory() {
		return 0;
	}

	@Override
	public void setCounterCategory(int counterCategory) {
	}

	@Override
	public ArrayList<Category> getListCatecories() {
		return null;
	}

	@Override
	public void setListCatecories(ArrayList<Category> listCatecories) {
	}

}
