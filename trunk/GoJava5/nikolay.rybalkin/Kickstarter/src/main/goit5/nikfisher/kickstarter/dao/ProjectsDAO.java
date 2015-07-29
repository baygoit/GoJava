package goit5.nikfisher.kickstarter.dao;

import goit5.nikfisher.kickstarter.model.Category;
import goit5.nikfisher.kickstarter.model.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectsDAO implements Projects {

    //TODO duplicated method
    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Error loading JDBC driver! ", e);
        }
    }

    Connection connection = null;
    Project project = null;

    //TODO duplicated method
    private ResultSet getResultSet() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/kickstarter.db");
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        return statement.executeQuery("SELECT * FROM projects");
    }

    public static void main(String[] args) {
        ProjectsDAO projectsDAO = new ProjectsDAO();
        Project project = projectsDAO.get(1);
        System.out.println(project);
//        Cate categoriesDAO = new CategoriesDAO();
//        System.out.println(projectsDAO.getProjects(categoriesDAO);
//        System.out.println(categoriesDAO.getCategories());
    }

    @Override
    public void add(Project project) {

    }

//    Map<Integer, Project> projects = new HashMap<>();

    @Override
    public List<Project> getProjects(Category category) {

        int found = 0;
        List<Project> result = new ArrayList<>();

        try {
            ResultSet rs = getResultSet();

            while (rs.next()) {

                CategoriesDAO categoriesDAO = new CategoriesDAO();
                categoriesDAO.get(rs.getInt("id"));
                rs.getInt("id");

                if (categoriesDAO.equals(category)) {
                    result.add(found, project);
                    found++;
                }
            }

            return result;

        }catch (SQLException e) {
            throw new RuntimeException("Error query! (method getCategories()", e);
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    @Override
    public Project get(int index) {
        try {
            ResultSet rs = getResultSet();

            while (rs.next()) {
//                project = new Project(rs.getInt("id"), rs.getString("name"));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error query! (method get() ", e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return project;
    }
}
