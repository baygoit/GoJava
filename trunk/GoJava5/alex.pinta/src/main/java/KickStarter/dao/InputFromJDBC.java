package KickStarter.dao;

import KickStarter.model.Category;
import KickStarter.model.Project;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDataSource;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import javax.sql.DataSource;

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
    private List<Category> catalogCategory = new ArrayList<>();
    private Map<Category, ArrayList<Project>> mappingCategoryAndProject = new HashMap<>();
    private final long MILLIS_IN_DAY = 86400000;

    public InputFromJDBC(String url, String user, String password) {
        PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(new DriverManagerConnectionFactory("jdbc:postgresql:" + url, user, password), null);
        ObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<>(poolableConnectionFactory);
        poolableConnectionFactory.setPool(connectionPool);
        dataSource = new PoolingDataSource<>(connectionPool);
    }

    public boolean isNeedInitDatabase(){

        try (Connection tmpConnect = dataSource.getConnection();
             PreparedStatement statement = tmpConnect.prepareStatement("SELECT Count(id) FROM categories ")){

            tmpConnect.setAutoCommit(false);
            ResultSet resultSet = statement.executeQuery();
            tmpConnect.commit();
            resultSet.next();
            return resultSet.getInt("count") == 0;

        } catch (SQLException e) {
            throw new RuntimeException("Can't connect to database.");
        }
    }

    @Override
    public void load() {
        if (isNeedInitDatabase()){
           loadFromMemory();
        }
        catalogCategory = getCategoryList();
        mappingCategoryAndProject = getMapping();
    }

    @Override
    public Map<Category, ArrayList<Project>> getMapping() {
        catalogCategory = getCategoryList();
        Map<Category, ArrayList<Project>> mappingCategoryAndProject = new HashMap<>(catalogCategory.size());
        for (Category elemOfCategory : catalogCategory){
            List<Project> projects = getListOfProjectByCategoryID(elemOfCategory.getId());
            mappingCategoryAndProject.put(elemOfCategory, (ArrayList)projects);
            for (Project elemOfProject : projects){
                getHistoryOfProject(elemOfProject);
                getDemoLinkOfProject(elemOfProject);
                getUserQuestionAnswerOfProject(elemOfProject);
            }
        }
        return mappingCategoryAndProject;
    }

    @Override
    public ArrayList<Category> getCategoryList() {
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
    public void saveData() {
        //TODO
    }


    private void loadFromMemory(){
        ManualInput manualInput = new ManualInput();
        manualInput.load();
        this.mappingCategoryAndProject = manualInput.getMapping();
        this.catalogCategory = manualInput.getCategoryList();
        setCategoryList(catalogCategory);
        for (Map.Entry<Category, ArrayList<Project>> entry : mappingCategoryAndProject.entrySet()){
            for (Project project : entry.getValue()){
                setProject(entry.getKey(), project);
                setHistoryOfProject(project);
                setDemoLinkOfProject(project);
                setUserQuestionAnswerOfProject(project);
            }
        }
    }

    private List<Project> getListOfProjectByCategoryID(int categoryId){
        try (Connection tmpConnect = dataSource.getConnection();
             PreparedStatement statement = tmpConnect.prepareStatement("SELECT short_name, full_description, category_id, " +
                                                                       "requirement_amount, id, balanced_amount, start_date" +
                                                                       "FROM projects WHERE category_id = ?")){

            statement.setInt(1, categoryId);
            tmpConnect.setAutoCommit(false);
            ResultSet resultSet = statement.executeQuery();
            tmpConnect.commit();
            ArrayList<Project> projects = new ArrayList<>();
            while (resultSet.next()){
                Calendar calDB = Calendar.getInstance();
                Calendar calNow = Calendar.getInstance();
                calDB.setTime(resultSet.getDate("startDate"));
                calNow.setTime(new Date(System.currentTimeMillis()));
                Long different = (calDB.getTimeInMillis() - calNow.getTimeInMillis() / 86400000);

                projects.add(new Project(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("fullDescription"),
                        resultSet.getInt("requirementAmount"),
                        resultSet.getInt("balancedAmount"),
                        different.intValue()));
            }
            return projects;

        } catch (SQLException e) {
            throw new RuntimeException("Can't connect to database.");
        }
    }

    private void setCategoryList(List<Category> categories){
        try (Connection tmpConnect = dataSource.getConnection();
             PreparedStatement statement = tmpConnect.prepareStatement("INSERT INTO categories(name, id) " +
                                                                       "VALUES (?, ?)")){
            tmpConnect.setAutoCommit(false);
            for (Category elem : categories ){
                statement.setString(1, elem.name);
                statement.setInt(2, elem.getId());
                statement.executeUpdate();
            }
            tmpConnect.commit();

        } catch (SQLException e) {
            throw new RuntimeException("Can't connect to database.");
        }
    }

    private void setProject(Category category, Project project){
        try (Connection tmpConnect = dataSource.getConnection();
             PreparedStatement statement = tmpConnect.prepareStatement("INSERT INTO projects(short_name, full_description, " +
                                                                       "category_id, requirement_amount, id, balanced_amount, start_date) " +
                                                                       "VALUES (?, ?, ?, ?, ?, ?, ?)")){
            tmpConnect.setAutoCommit(false);
            statement.setString(1, project.name);
            statement.setString(2, project.fullDescription);
            statement.setInt   (3, category.getId());
            statement.setDouble(4, project.requirementAmount);
            statement.setInt   (5, project.getId());
            statement.setDouble(6, project.balancedAmount);
            statement.setDate  (7, new Date(System.currentTimeMillis() + project.daysLeft*MILLIS_IN_DAY));

            statement.executeUpdate();
            tmpConnect.commit();

        } catch (SQLException e) {
            throw new RuntimeException("Can't connect to database.");
        }
    }

    private void getHistoryOfProject(Project project){
        try (Connection tmpConnect = dataSource.getConnection();
             PreparedStatement statement = tmpConnect.prepareStatement("SELECT id, description, user_login, date_added, project_id " +
                                                                       "FROM history_of_project WHERE project_id = ?")){

            statement.setInt(1, project.getId());
            tmpConnect.setAutoCommit(false);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                project.addHistoryOfProject(resultSet.getString("description"), resultSet.getString("user_login"), resultSet.getDate("dateAdded"));
            }
            tmpConnect.commit();
        } catch (SQLException e) {
            throw new RuntimeException("Can't connect to database.");
        }
    }

    private void setHistoryOfProject(Project project){
        try (Connection tmpConnect = dataSource.getConnection();
             PreparedStatement statement = tmpConnect.prepareStatement("INSERT INTO history_of_project(description, user_login, date_added, project_id) " +
                                                                       "VALUES (?, ?, ?, ?)")){
            tmpConnect.setAutoCommit(false);
            for (Project.History history : project.historyOfProject){
                statement.setString(1, history.description);
                statement.setString(2, history.user);
                statement.setDate  (3, history.dateAdded);
                statement.setInt   (4, project.getId());

                statement.executeUpdate();
            }
            tmpConnect.commit();

        } catch (SQLException e) {
            throw new RuntimeException("Can't connect to database.");
        }
    }

    private void getDemoLinkOfProject(Project project){
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

    private void setDemoLinkOfProject(Project project){
        try (Connection tmpConnect = dataSource.getConnection();
             PreparedStatement statement = tmpConnect.prepareStatement("INSERT INTO link_of_project(description, link, project_id) " +
                                                                       "VALUES (?, ?, ?)")){
            tmpConnect.setAutoCommit(false);
            for (Project.VideoLink history : project.demoLink){
                statement.setString(1, history.description);
                statement.setString(2, history.link);
                statement.setInt   (3, project.getId());

                statement.executeUpdate();
            }
            tmpConnect.commit();

        } catch (SQLException e) {
            throw new RuntimeException("Can't connect to database.");
        }
    }
    private void getUserQuestionAnswerOfProject(Project project){
        try (Connection tmpConnect = dataSource.getConnection();
             PreparedStatement statement = tmpConnect.prepareStatement("SELECT id, description, user_login, date_added, project_id " +
                                                                       "FROM question_answer_of_project WHERE project_id = ?")){

            statement.setInt(1, project.getId());
            tmpConnect.setAutoCommit(false);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                project.addUserQuestionAnswer(resultSet.getString("description"), resultSet.getString("user_login"), resultSet.getDate("dateAdded"));
            }
            tmpConnect.commit();
        } catch (SQLException e) {
            throw new RuntimeException("Can't connect to database.");
        }
    }
    private void setUserQuestionAnswerOfProject(Project project){
        try (Connection tmpConnect = dataSource.getConnection();
             PreparedStatement statement = tmpConnect.prepareStatement("INSERT INTO question_answer_of_project(description, user_login, date_added, project_id) " +
                                                                       "VALUES (?, ?, ?, ?)")){
            tmpConnect.setAutoCommit(false);
            for (Project.QuestionAnswer history : project.userQuestion){
                statement.setString(1, history.description);
                statement.setString(2, history.user);
                statement.setDate  (3, history.dateAdded);
                statement.setInt   (4, project.getId());

                statement.executeUpdate();
            }
            tmpConnect.commit();

        } catch (SQLException e) {
            throw new RuntimeException("Can't connect to database.");
        }
    }
}
