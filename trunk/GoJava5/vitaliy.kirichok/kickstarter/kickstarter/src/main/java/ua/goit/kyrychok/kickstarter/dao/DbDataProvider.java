package ua.goit.kyrychok.kickstarter.dao;

import ua.goit.kyrychok.kickstarter.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbDataProvider implements DataProvider {
    private final String DB_CONNECTION;
    private final String DB_USER;
    private final String DB_PASSWORD;

    public DbDataProvider(String db_connection, String db_user, String db_password) {
        DB_CONNECTION = db_connection;
        DB_USER = db_user;
        DB_PASSWORD = db_password;
    }


    @Override
    public String getWelcomeMessage() {
        String sql = "SELECT m.text AS message\n" +
                "  FROM message m\n" +
                " WHERE rownum = 1";
        String result = null; //TODO Null object
        try (Connection connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                result = resultSet.getString("message");
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Category> getCategories() {
        String sql = "SELECT c.category_id AS id,\n" +
                "       c.name        AS NAME\n" +
                "  FROM category c\n" +
                " ORDER BY c.name";
        List<Category> result = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Category category = new Category(resultSet.getString("name"));
                category.setId(resultSet.getInt("id"));
                result.add(category);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Category getCategory(int id) {
        String sql = "SELECT c.category_id   AS category_id,\n" +
                "       c.name          AS category_name,\n" +
                "       p.project_id    AS project_id,\n" +
                "       p.name          AS project_name,\n" +
                "       p.description   AS short_description,\n" +
                "       p.goal          AS goal,\n" +
                "       p.balance       AS balance,\n" +
                "       p.deadline_date AS deadline_date\n" +
                "  FROM category c,\n" +
                "       project  p\n" +
                " WHERE c.category_id = p.category_id\n" +
                "   AND c.category_id = ?\n" +
                " ORDER BY p.name";
        Category result = new Category("");//TODO Null object
        try (Connection connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            boolean isNotFirstIteration = true;
            while (resultSet.next()) {
                if (isNotFirstIteration) {
                    result = new Category(resultSet.getString("category_name"));//TODO zzz
                    result.setId(resultSet.getInt("category_id"));
                    isNotFirstIteration = false;
                }
                Project project = new Project(resultSet.getString("project_name"), resultSet.getInt("goal"), resultSet.getDate("deadline_date"));
                project.setShortDescription(resultSet.getString("short_description"));
                project.setId(resultSet.getInt("project_id"));
                project.setBalance(resultSet.getInt("balance"));
                result.addProject(project);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Project getProject(int id) {
        String sqlProject = "SELECT p.NAME          AS name,\n" +//
                "       p.description   AS description,\n" +//
                "       p.goal          AS goal,\n" +//
                "       p.balance       AS balance,\n" +//
                "       p.deadline_date AS deadline_date,\n" +//
                "       p.demo_link     AS demo_link\n" +
                "  FROM project p\n" +
                " WHERE p.project_id = ?";
        String sqlFaqs = "SELECT f.faq_id   AS id,\n" +
                "       f.question AS question,\n" +
                "       f.answer   AS answer\n" +
                "  FROM faq f\n" +
                " WHERE f.project_id = ?\n" +
                " ORDER BY f.faq_id";
        String sqlEvents = "SELECT pe.project_event_id AS id,\n" +
                "       pe.event_date       AS event_date,\n" +
                "       pe.message          AS message\n" +
                "  FROM project_event pe\n" +
                " WHERE pe.project_id = ?\n" +
                " ORDER BY pe.event_date DESC";
        Project result = null;//TODO Null object
        try (Connection connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
             PreparedStatement projectStatement = connection.prepareStatement(sqlProject);
             PreparedStatement faqStatement = connection.prepareStatement(sqlFaqs);
             PreparedStatement eventsStatement = connection.prepareStatement(sqlEvents)) {
            //TODO To many statements
            projectStatement.setInt(1, id);
            ResultSet resultSetProject = projectStatement.executeQuery();
            while (resultSetProject.next()) {
                result = new Project(resultSetProject.getString("name"), resultSetProject.getInt("goal"), resultSetProject.getDate("deadline_date"));
                result.setShortDescription(resultSetProject.getString("description"));
                result.setBalance(resultSetProject.getInt("balance"));
                result.setDemoLink(resultSetProject.getString("demo_link"));
                result.setId(id);
            }
            resultSetProject.close();

            faqStatement.setInt(1, id);
            ResultSet resultSetFaqs = faqStatement.executeQuery();
            while (resultSetFaqs.next()) {
                Faq faq = new Faq(resultSetFaqs.getString("question"), resultSetFaqs.getString("answer"));
                faq.setId(resultSetFaqs.getInt("id"));
                result.addFaq(faq);
            }
            resultSetFaqs.close();

            eventsStatement.setInt(1, id);
            ResultSet resultSetEvents = eventsStatement.executeQuery();
            while (resultSetEvents.next()) {
                ProjectEvent projectEvent = new ProjectEvent(resultSetEvents.getDate("event_date"), resultSetEvents.getString("message"));
                projectEvent.setId(resultSetEvents.getInt("id"));
                result.addProjectEvent(projectEvent);
            }
            resultSetEvents.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void addFaq(int projectId, Faq faq) {
        String sql = "INSERT INTO faq\n" +
                "    (question, answer, project_id)\n" +
                "VALUES\n" +
                "    (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, faq.getQuestion());
            statement.setString(2, faq.getAnswer());
            statement.setInt(3, projectId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Reward> getRewards(int projectId) {
        String sql = "SELECT r.reward_id   AS id,\n" +
                "       r.amount      AS amount,\n" +
                "       r.description AS description\n" +
                "  FROM reward r\n" +
                " WHERE r.project_id = ?\n" +
                " ORDER BY r.amount,\n" +
                "          r.description";
        List<Reward> result = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, projectId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Reward reward = new Reward(resultSet.getInt("amount"), resultSet.getString("description"));
                reward.setId(resultSet.getInt("id"));
                result.add(reward);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void setProjectBalance(int projectId, int amount) {
        //TODO WTF? Alias does not work!
        String sql = "UPDATE project \n" +
                "   SET balance = ?\n" +
                " WHERE project_id = ?";
        try (Connection connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, amount);
            statement.setInt(2, projectId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getProjectBalance(int projectId) {
        String sql = "SELECT p.balance AS balance\n" +
                "  FROM project p\n" +
                " WHERE p.project_id = ?";
        int result = 0;
        try (Connection connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, projectId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result = resultSet.getInt("balance");
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Reward getReward(int id) {
        String sql = "SELECT r.reward_id   AS id,\n" +
                "       r.amount      AS amount,\n" +
                "       r.description AS description\n" +
                "  FROM reward r\n" +
                " WHERE r.reward_id = ?";
        Reward result = null;//TODO Null object
        try (Connection connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result = new Reward(resultSet.getInt("amount"), resultSet.getString("description"));
                result.setId(resultSet.getInt("id"));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
