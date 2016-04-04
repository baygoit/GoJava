package ua.dborisenko.kickstarter.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Investment;
import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Question;
import ua.dborisenko.kickstarter.domain.Reward;

public class CategoryDao extends DaoSql {

    public void getQuestions(Project project) {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement
                    .executeQuery("SELECT id, request, reply FROM questions WHERE project_id = " + project.getId());
            while (rs.next()) {
                Question question = new Question();
                question.setId(rs.getInt("id"));
                question.setRequest(rs.getString("request"));
                question.setReply(rs.getString("reply"));
                project.addQuestion(question);
            }
            closeStatement(statement);
        } catch (SQLException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    public void getRewards(Project project) {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement
                    .executeQuery("SELECT id, amount, description FROM rewards WHERE project_id = " + project.getId());
            while (rs.next()) {
                Reward reward = new Reward();
                reward.setId(rs.getInt("id"));
                reward.setAmount(rs.getInt("amount"));
                reward.setDescription(rs.getString("description"));
                project.addReward(reward);
            }
            closeStatement(statement);
        } catch (SQLException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    void getInvestments(Project project) {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement
                    .executeQuery("SELECT id, cardholder_name, card_number, amount FROM investments WHERE project_id = "
                            + project.getId());
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
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    private void getProjects(Category category) {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(
                    "SELECT id, name, description, history, required_sum, days_left, video_url FROM projects WHERE category_id = "
                            + category.getId());
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
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    public Category getCategoryById(int id) {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT id, name FROM categories WHERE id = " + id);
            if (!rs.next()) {
                return null;
            }
            Category category = new Category();
            category.setId(rs.getInt("id"));
            category.setName(rs.getString("name"));
            getProjects(category);
            closeStatement(statement);
            return category;
        } catch (SQLException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    public Project getProjectById(int id) {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(
                    "SELECT id, name, description, history, required_sum, days_left, video_url FROM projects WHERE id = "
                            + id);
            if (!rs.next()) {
                return null;
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
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    public List<Category> getCategories() {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT id, name FROM categories ORDER BY name");
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
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    public void addInvestment(int projectId, Investment investment) {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            statement
                    .executeUpdate("INSERT INTO investments (project_id, cardholder_name, card_number, amount) VALUES ("
                            + projectId + ", '" + investment.getCardHolderName() + "', '" + investment.getCardNumber()
                            + "', " + investment.getAmount() + ")");
            closeStatement(statement);
        } catch (SQLException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    public void addQuestion(int projectId, Question question) {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO questions (project_id, request) VALUES (" + projectId + ", '"
                    + question.getRequest() + "')");
            closeStatement(statement);
        } catch (SQLException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    public Category getCategoryByProjectId(int id) {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(
                    "SELECT c.id, c.name FROM categories c INNER JOIN projects p ON (p.category_id = c.id) WHERE p.id = "
                            + id);
            rs.next();
            Category category = new Category();
            category.setId(rs.getInt("c.id"));
            category.setName(rs.getString("c.name"));
            closeStatement(statement);
            return category;
        } catch (SQLException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

}
