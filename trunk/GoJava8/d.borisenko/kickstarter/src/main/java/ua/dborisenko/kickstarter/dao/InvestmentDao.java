package ua.dborisenko.kickstarter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ua.dborisenko.kickstarter.domain.Investment;
import ua.dborisenko.kickstarter.domain.Project;

@Repository
public class InvestmentDao {

    final class InvestmentRowMapper implements RowMapper<Investment> {
        @Override
        public Investment mapRow(ResultSet rs, int rowNum) throws SQLException {
            Investment investment = new Investment();
            investment.setId(rs.getInt("id"));
            investment.setAmount(rs.getInt("amount"));
            investment.setCardHolderName(rs.getString("cardholder_name"));
            investment.setCardNumber(rs.getString("card_number"));
            return investment;
        }
    }

    static final String GET_INVESTMENTS_QUERY = "SELECT id, cardholder_name, card_number, amount FROM investments WHERE project_id = ?";
    static final String ADD_INVESTMENT_QUERY = "INSERT INTO investments (project_id, cardholder_name, card_number, amount) VALUES (?, ?, ?, ?)";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private InvestmentRowMapper mapper = new InvestmentRowMapper();

    void getAllForProject(Project project) {
        project.setInvestment(
                jdbcTemplate.query(GET_INVESTMENTS_QUERY, new Object[] { project.getId() }, mapper));
    }

    public void addToProject(int projectId, Investment investment) {
        jdbcTemplate.update(ADD_INVESTMENT_QUERY, projectId, investment.getCardHolderName(), investment.getCardNumber(),
                investment.getAmount());
    }
}

