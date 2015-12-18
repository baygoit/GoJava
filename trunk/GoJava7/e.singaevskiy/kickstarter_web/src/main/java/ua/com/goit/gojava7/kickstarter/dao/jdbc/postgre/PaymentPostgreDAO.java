package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.goit.gojava7.kickstarter.dao.PaymentDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.JdbcDataSource;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.JdbcDispatcher;
import ua.com.goit.gojava7.kickstarter.domain.Payment;

public class PaymentPostgreDAO implements PaymentDAO, JdbcDataSource<Payment> {

	final static Logger logger = LoggerFactory.getLogger(PaymentPostgreDAO.class);
	
    private static final String TABLE = "payment";
    private static final String FIELDS = "cardid,date,username,sum,project_id,reward_id";
    private static final String INSERTION = FIELDS.replaceAll("[^,]+", "?");
    
    private JdbcDispatcher dispatcher;

    public PaymentPostgreDAO(JdbcDispatcher dispatcher) {
        this.dispatcher = dispatcher;
        logger.info("dao created");
    }

    @Override
    public void clear() {
        String sql = "delete from " + TABLE;
        dispatcher.clear(sql);
    }

    @Override
    public Payment get(int index) {
        String sql = "select " + FIELDS + " from " + TABLE + " limit 1 offset " + index;
        Payment element = null;
        List<Payment> list = dispatcher.get(sql, this);
		if (!list.isEmpty()) {
			element = list.get(0);
		}
        return element;
    }

    @Override
    public void add(Payment element) {
        String sql = "insert into " + TABLE + " (" + FIELDS + ") values (" + INSERTION + ")";
        dispatcher.add(sql, element, this);
    }

    @Override
    public void addAll(List<Payment> elements) {
        String sql = "insert into " + TABLE + " (" + FIELDS + ") values (" + INSERTION + ")";
        dispatcher.add(sql, elements, this);
    }

    @Override
    public List<Payment> getAll() {
        String sql = "select " + FIELDS + " from " + TABLE;
        List<Payment> result = dispatcher.get(sql, this);
        return result;
    }

    @Override
    public List<Payment> getByProject(int projectId) {
        String sql = "select " + FIELDS + " from " + TABLE + " where project_id = " + projectId;
        List<Payment> result = dispatcher.get(sql, this);
        return result;
    }

    @Override
    public long getSum(int projectId) {
        String sql = "select SUM(sum) from " + TABLE + " where project_id = " + projectId;
        long result = 0;
        try(Connection connection = dispatcher.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            if (resultSet.next()) {
                result =  resultSet.getLong("sum");
            }
        } catch (SQLException e) {
            dispatcher.processException(e);
        }       
        return result;
    }

	@Override
	public Payment read(ResultSet resultSet) throws SQLException {
		Payment element = new Payment();
        element.setCardId(resultSet.getInt("cardId"));
        element.setDate(resultSet.getDate("date"));
        element.setUser(resultSet.getString("username"));        
        element.setSum(resultSet.getLong("sum"));
        element.setRewardId(resultSet.getInt("reward_id"));
        element.setProjectId(resultSet.getInt("project_id"));
        return element;
	}

	@Override
	public void prepare(Payment element, PreparedStatement statement) throws SQLException {
		statement.setLong(1, element.getCardId());
        statement.setDate(2, element.getDate());
        statement.setString(3, element.getUser());
        statement.setLong(4, element.getSum());
        if (element.getProjectId() == 0) {
            statement.setNull(5, java.sql.Types.INTEGER);   
        } else {
            statement.setInt(5, element.getProjectId());             
        }
        if (element.getRewardId() == 0) {
            statement.setNull(6, java.sql.Types.INTEGER);   
        } else {
            statement.setInt(6, element.getRewardId());             
        }
	}
}
