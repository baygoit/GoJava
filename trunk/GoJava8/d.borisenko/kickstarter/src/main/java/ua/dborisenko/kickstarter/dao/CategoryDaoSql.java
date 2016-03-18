package ua.dborisenko.kickstarter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Investment;
import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Question;
import ua.dborisenko.kickstarter.domain.Reward;

public class CategoryDaoSql extends DaoSql implements CategoryDao {

    private void getQuestions(Project project) {
        try {
            ResultSet rs = executeQuery(
                    "SELECT id, request, reply FROM questions WHERE project_id = " + project.getId());
            while (rs.next()) {
                Question question = new Question();
                question.setId(rs.getInt("id"));
                question.setRequest(rs.getString("request"));
                question.setReply(rs.getString("reply"));
                project.addQuestion(question);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private void getRewards(Project project) {
        try {
            ResultSet rs = executeQuery(
                    "SELECT id, amount, description FROM rewards WHERE project_id = " + project.getId());
            while (rs.next()) {
                Reward reward = new Reward();
                reward.setId(rs.getInt("id"));
                reward.setAmount(rs.getInt("amount"));
                reward.setDescription(rs.getString("description"));
                project.addReward(reward);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private void getInvestments(Project project) {
        try {
            ResultSet rs = executeQuery(
                    "SELECT id, cardholder_name, card_number, amount FROM investments WHERE project_id = "
                            + project.getId());
            while (rs.next()) {
                Investment investment = new Investment();
                investment.setId(rs.getInt("id"));
                investment.setCardHolderName(rs.getString("cardholder_name"));
                investment.setCardNumber(rs.getString("card_number"));
                investment.setAmount(rs.getInt("amount"));
                project.addInvestment(investment);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private void getProjects(Category category) {
        try {
            ResultSet rs = executeQuery(
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
                getQuestions(project);
                getRewards(project);
                getInvestments(project);
                category.addProject(project);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public Category getByName(String name) {
        try {
            ResultSet rs = executeQuery("SELECT id, name FROM categories WHERE name = '" + name + "'");
            rs.next();
            Category category = new Category();
            category.setId(rs.getInt("id"));
            category.setName(rs.getString("name"));
            getProjects(category);
            return category;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public List<String> getCategoryNames() {
        try {
            ResultSet rs = executeQuery("SELECT name FROM categories ORDER BY name");
            List<String> names = new ArrayList<String>();
            while (rs.next()) {
                names.add(rs.getString("name"));
            }
            return names;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public void addInvestment(Project project, Investment investment) {
        try {
            executeUpdate("INSERT INTO investments (project_id, cardholder_name, card_number, amount) VALUES ("
                    + project.getId() + ", '" + investment.getCardHolderName() + "', '" + investment.getCardNumber()
                    + "', " + investment.getAmount() + ")");
            project.addInvestment(investment);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public void addQuestion(Project project, Question question) {
        try {
            executeUpdate("INSERT INTO questions (project_id, request) VALUES (" + project.getId() + ", '"
                    + question.getRequest() + "')");
            project.addQuestion(question);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
