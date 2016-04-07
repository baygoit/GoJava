package ua.dborisenko.kickstarter.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Investment;
import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Question;
import ua.dborisenko.kickstarter.domain.Reward;

public class CategoryDao extends DaoSql {

    private static final String QUERY_GET_CATEGORY_BY_PROJECT_ID = "SELECT c.id, c.name FROM categories c INNER JOIN projects p ON (p.category_id = c.id) WHERE p.id = ?";
    private static final String QUERY_GET_CATEGORY_BY_ID = "SELECT id, name FROM categories WHERE id = ?";
    private static final String QUERY_GET_CATEGORIES = "SELECT id, name FROM categories ORDER BY name";
    private static final String QUERY_GET_PROJECT_BY_ID = "SELECT id, name, description, history, required_sum, days_left, video_url FROM projects WHERE id = ?";
    private static final String QUERY_GET_PROJECTS = "SELECT id, name, description, history, required_sum, days_left, video_url FROM projects WHERE category_id = ?";
    private static final String QUERY_GET_QUESTIONS = "SELECT id, request, reply FROM questions WHERE project_id = ?";
    private static final String QUERY_ADD_QUESTION = "INSERT INTO questions (project_id, request) VALUES (?, ?)";
    private static final String QUERY_GET_INVESTMENTS = "SELECT id, cardholder_name, card_number, amount FROM investments WHERE project_id = ?";
    private static final String QUERY_ADD_INVESTMENT = "INSERT INTO investments (project_id, cardholder_name, card_number, amount) VALUES (?, ?, ?, ?)";
    private static final String QUERY_GET_REWARDS = "SELECT id, amount, description FROM rewards WHERE project_id = ?";

    public void getQuestions(Project project) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(QUERY_GET_QUESTIONS);
            statement.setInt(1, project.getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Question question = new Question();
                question.setId(rs.getInt("id"));
                question.setRequest(rs.getString("request"));
                question.setReply(rs.getString("reply"));
                project.addQuestion(question);
            }
            closeStatement(statement);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void getRewards(Project project) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(QUERY_GET_REWARDS);
            statement.setInt(1, project.getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Reward reward = new Reward();
                reward.setId(rs.getInt("id"));
                reward.setAmount(rs.getInt("amount"));
                reward.setDescription(rs.getString("description"));
                project.addReward(reward);
            }
            closeStatement(statement);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    void getInvestments(Project project) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(QUERY_GET_INVESTMENTS);
            statement.setInt(1, project.getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Investment investment = new Investment();
                investment.setId(rs.getInt("id"));
                investment.setCardHolderName(rs.getString("cardholder_name"));
                investment.setCardNumber(rs.getString("card_number"));
                investment.setAmount(rs.getInt("amount"));
                project.addInvestment(investment);
            }
            closeStatement(statement);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    private void getProjects(Category category) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(QUERY_GET_PROJECTS);
            statement.setInt(1, category.getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Project project = new Project();
                project.setId(rs.getInt("id"));
                project.setName(rs.getString("name"));
                project.setDescription(rs.getString("description"));
                project.setHistory(rs.getString("history"));
                project.setRequiredSum(rs.getInt("required_sum"));
                project.setDaysLeft(rs.getInt("days_left"));
                project.setVideoUrl(rs.getString("video_url"));
                getInvestments(project);
                category.addProject(project);
            }
            closeStatement(statement);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public Category getCategoryById(int id) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(QUERY_GET_CATEGORY_BY_ID);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (!rs.next()) {
                throw new NoResultException("No category found.");
            }
            Category category = new Category();
            category.setId(rs.getInt("id"));
            category.setName(rs.getString("name"));
            getProjects(category);
            closeStatement(statement);
            return category;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public Project getProjectById(int id) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(QUERY_GET_PROJECT_BY_ID);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (!rs.next()) {
                throw new NoResultException("No project found.");
            }
            Project project = new Project();
            project.setId(rs.getInt("id"));
            project.setName(rs.getString("name"));
            project.setDescription(rs.getString("description"));
            project.setHistory(rs.getString("history"));
            project.setRequiredSum(rs.getInt("required_sum"));
            project.setDaysLeft(rs.getInt("days_left"));
            project.setVideoUrl(rs.getString("video_url"));
            getInvestments(project);
            getQuestions(project);
            closeStatement(statement);
            return project;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public List<Category> getCategories() {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(QUERY_GET_CATEGORIES);
            ResultSet rs = statement.executeQuery();
            List<Category> categories = new ArrayList<>();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                categories.add(category);
            }
            closeStatement(statement);
            return categories;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void addInvestment(int projectId, Investment investment) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(QUERY_ADD_INVESTMENT);
            statement.setInt(1, projectId);
            statement.setString(2, investment.getCardHolderName());
            statement.setString(3, investment.getCardNumber());
            statement.setInt(4, investment.getAmount());
            statement.executeUpdate();
            closeStatement(statement);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void addQuestion(int projectId, Question question) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(QUERY_ADD_QUESTION);
            statement.setInt(1, projectId);
            statement.setString(2, question.getRequest());
            statement.executeUpdate();
            closeStatement(statement);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public Category getCategoryByProjectId(int id) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(QUERY_GET_CATEGORY_BY_PROJECT_ID);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (!rs.next()) {
                throw new NoResultException("No category found.");
            }
            Category category = new Category();
            category.setId(rs.getInt("c.id"));
            category.setName(rs.getString("c.name"));
            closeStatement(statement);
            return category;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

}
