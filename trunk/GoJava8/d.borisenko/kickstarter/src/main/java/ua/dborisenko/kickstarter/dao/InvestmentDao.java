package ua.dborisenko.kickstarter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.dborisenko.kickstarter.domain.Investment;
import ua.dborisenko.kickstarter.domain.Project;

@Repository
public class InvestmentDao {

    private static final String QUERY_GET_INVESTMENTS = "SELECT id, cardholder_name, card_number, amount FROM investments WHERE project_id = ?";
    private static final String QUERY_ADD_INVESTMENT = "INSERT INTO investments (project_id, cardholder_name, card_number, amount) VALUES (?, ?, ?, ?)";
    @Autowired
    private DataSource dataSource;

    void getInvestments(Project project) {
        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(QUERY_GET_INVESTMENTS)) {
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
        } catch (SQLException | NullPointerException e) {
            throw new IllegalStateException(e);
        }
    }

    public void addInvestment(int projectId, Investment investment) {
        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(QUERY_ADD_INVESTMENT)) {
            statement.setInt(1, projectId);
            statement.setString(2, investment.getCardHolderName());
            statement.setString(3, investment.getCardNumber());
            statement.setInt(4, investment.getAmount());
            statement.executeUpdate();
        } catch (SQLException | NullPointerException e) {
            throw new IllegalStateException(e);
        }
    }
}
