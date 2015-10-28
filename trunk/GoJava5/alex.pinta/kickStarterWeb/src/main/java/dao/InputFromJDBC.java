package dao;

import model.Category;
import model.Project;
import model.Quote;

import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDataSource;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;

import javax.sql.DataSource;
import java.sql.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 31.07.15
 * Time: 15:58
 * @version: 1.0
 */
public class InputFromJDBC implements LoadingData {

    private DataSource dataSource;
//    private List<Category> catalogCategory = new ArrayList<>();
//    private Map<Category, List<Project>> mappingCategoryAndProject = new HashMap<>();
    private final long MILLIS_IN_DAY = 86400000;

    public InputFromJDBC(String url, String user, String password) {
        PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(new DriverManagerConnectionFactory("jdbc:postgresql:" + url, user, password), null);
        ObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<>(poolableConnectionFactory);
        poolableConnectionFactory.setPool(connectionPool);
        dataSource = new PoolingDataSource<>(connectionPool);
    }


    public InputFromJDBC(DataSource pDataSource) {
        dataSource = pDataSource;
    }

    @Override
    public List<Quote> getQuoteList() {
        try (Connection tmpConnect = dataSource.getConnection();
             PreparedStatement statement = tmpConnect.prepareStatement("SELECT description, id FROM quote")){

            tmpConnect.setAutoCommit(false);
            ResultSet resultSet = statement.executeQuery();
            tmpConnect.commit();
            List<Quote> quotes = new ArrayList<>();
            while (resultSet.next()){
                quotes.add(new Quote(resultSet.getInt("id"), resultSet.getString("description")));
            }
            return quotes;

        } catch (SQLException e) {
            throw new RuntimeException("Can't connect to database.");
        }
    }

    @Override
    public List<Category> getCategoryList() {
        try (Connection tmpConnect = dataSource.getConnection();
             PreparedStatement statement = tmpConnect.prepareStatement("SELECT name, id FROM categories")){

            tmpConnect.setAutoCommit(false);
            ResultSet resultSet = statement.executeQuery();
            tmpConnect.commit();
            ArrayList<Category> categories = new ArrayList<>();
            while (resultSet.next()){
                categories.add(new Category(resultSet.getInt("id"), resultSet.getString("name")));
            }
            return categories;

        } catch (SQLException e) {
            throw new RuntimeException("Can't connect to database.");
        }
    }

    @Override
    public Category getCategoryByID(int categoryId) {
        try (Connection tmpConnect = dataSource.getConnection();
             PreparedStatement statement = tmpConnect.prepareStatement("SELECT * FROM categories WHERE id = ?")){

            tmpConnect.setAutoCommit(false);
            statement.setInt(1, categoryId);
            ResultSet resultSet = statement.executeQuery();
            tmpConnect.commit();
            ArrayList<Category> categories = new ArrayList<>();
            if (resultSet.next()){
                return new Category(resultSet.getInt("id"), resultSet.getString("name"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Can't connect to database.");
        }
    }

    @Override
    public Project getProjectByID(int projectId) {
        try (Connection tmpConnect = dataSource.getConnection();
             PreparedStatement statement = tmpConnect.prepareStatement("SELECT * FROM projects WHERE id = ?")){

            tmpConnect.setAutoCommit(false);
            statement.setInt(1, projectId);
            ResultSet resultSet = statement.executeQuery();
            tmpConnect.commit();
            if (resultSet.next()){
                Calendar calDB = Calendar.getInstance();
                Calendar calNow = Calendar.getInstance();
                calDB.setTime(resultSet.getDate("start_date"));
                calNow.setTime(new Date(System.currentTimeMillis()));
                Long different = (calDB.getTimeInMillis() - calNow.getTimeInMillis() / 86400000);

                return  new Project(resultSet.getInt("id"),
                        resultSet.getString("short_name"),
                        resultSet.getString("full_description"),
                        resultSet.getInt("requirement_amount"),
                        resultSet.getInt("balanced_amount"),
                        different.intValue());
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Can't connect to database.");
        }
    }

    @Override
    public List<Project> getListOfProjectByCategoryID(int categoryId){
        try (Connection tmpConnect = dataSource.getConnection();
//             PreparedStatement statement = tmpConnect.prepareStatement("SELECT short_name, full_description, category_id, " +
//                                                                       "requirement_amount, id, balanced_amount, start_date" +
//                                                                       "FROM projects WHERE category_id = ?")){
             PreparedStatement statement = tmpConnect.prepareStatement("SELECT *" +
                                                                       "FROM projects WHERE category_id = ?")){

            statement.setInt(1, categoryId);
            tmpConnect.setAutoCommit(false);
            ResultSet resultSet = statement.executeQuery();
            tmpConnect.commit();
            ArrayList<Project> projects = new ArrayList<>();
            while (resultSet.next()){
                Calendar calDB = Calendar.getInstance();
                Calendar calNow = Calendar.getInstance();
                calDB.setTime(resultSet.getDate("start_date"));
                calNow.setTime(new Date(System.currentTimeMillis()));
                Long different = (calDB.getTimeInMillis() - calNow.getTimeInMillis() / 86400000);

                projects.add(new Project(resultSet.getInt("id"),
                        resultSet.getString("short_name"),
                        resultSet.getString("full_description"),
                        resultSet.getInt("requirement_amount"),
                        resultSet.getInt("balanced_amount"),
                        different.intValue()));
            }
            return projects;

        } catch (SQLException e) {
            throw new RuntimeException("Can't connect to database.");
        }
    }

    @Override
    public void updateHistoryOfProject(Project project){
        try (Connection tmpConnect = dataSource.getConnection();
             PreparedStatement statement = tmpConnect.prepareStatement("SELECT id, description, user_login, date_added, project_id " +
                                                                       "FROM history_of_project WHERE project_id = ?")){

            statement.setInt(1, project.getId());
            tmpConnect.setAutoCommit(false);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                project.addHistoryOfProject(resultSet.getString("description"), resultSet.getString("user_login"), resultSet.getDate("date_added"));
            }
            tmpConnect.commit();
        } catch (SQLException e) {
            throw new RuntimeException("Can't connect to database.");
        }
    }

    @Override
    public void updateDemoLinkOfProject(Project project){
        try (Connection tmpConnect = dataSource.getConnection();
             PreparedStatement statement = tmpConnect.prepareStatement("SELECT id, description, link, project_id " +
                                                                       "FROM link_of_project WHERE project_id = ?")){

            statement.setInt(1, project.getId());
            tmpConnect.setAutoCommit(false);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                project.addDemoLink(resultSet.getString("description"), resultSet.getString("link"));
            }
            tmpConnect.commit();
        } catch (SQLException e) {
            throw new RuntimeException("Can't connect to database.");
        }
    }

    @Override
    public void updateUserQuestionAnswerOfProject(Project project){
        try (Connection tmpConnect = dataSource.getConnection();
             PreparedStatement statement = tmpConnect.prepareStatement("SELECT id, description, user_login, date_added, project_id " +
                                                                       "FROM question_answer_of_project WHERE project_id = ?")){

            statement.setInt(1, project.getId());
            tmpConnect.setAutoCommit(false);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                project.addUserQuestionAnswer(resultSet.getString("description"), resultSet.getString("user_login"), resultSet.getDate("date_added"));
            }
            tmpConnect.commit();
        } catch (SQLException e) {
            throw new RuntimeException("Can't connect to database.");
        }
    }

    @Override
    public void updateTermsOfProject(Project project) {
    }

    @Override
    public <T> void setInfoOfProject(Project project, String field, T value) {
    }

    @Override
    public Project.Terms getTermByID(int projectId, int termId) {
        return null;
    }

    @Override
    public void setQuestionAnswerOfProject(Project project, String description, String user) {

    }
}
