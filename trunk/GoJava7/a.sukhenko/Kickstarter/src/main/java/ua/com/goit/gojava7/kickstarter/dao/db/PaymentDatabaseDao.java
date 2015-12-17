package ua.com.goit.gojava7.kickstarter.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Level;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava7.kickstarter.dao.DatabaseDao;
import ua.com.goit.gojava7.kickstarter.domain.Payment;

@Component
public class PaymentDatabaseDao extends DatabaseDao<Payment>{
	private static final org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getLogger(PaymentDatabaseDao.class);
	
	private static String table  = "payments";
    private static String fields = "id,cardOwner,cardNumber,projectId,amount";
	@Override
	public Connection getConnection() throws SQLException {
		return super.dataSource.getConnection();
	}

	@Override
	protected Payment readElement(ResultSet resultSet) throws SQLException {
		Payment payment = new Payment();
		payment.setAmount(resultSet.getLong("amount"));
		payment.setCardNumber(resultSet.getLong("cardNumber"));
		payment.setCardOwner(resultSet.getString("cardOwner"));
		payment.setProjectId(resultSet.getInt("projectId"));
		payment.setId(resultSet.getInt("id"));
		return payment;
	}

	@Override
	public Payment getByNumber(int number) {
		logger.warn("method not done");
		return null;
	}

	@Override
	public void setAll(List<Payment> data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Payment> getAll() {
		List<Payment> data = new ArrayList<>();
        String query = "select " + fields + " from " + table;
        try (PreparedStatement ps = getConnection().prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
            while (resultSet.next()) {
                data.add(readElement(resultSet));
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR, e);

        }
        return data;
	}
	
	
	/*
	public List<Payment> getAllJdbcTemplate() {
		List<Payment> data = new ArrayList<>();
        String query = "select " + fields + " from " + table;
        List<Map<String,Object>> paymentsRows = jdbcTemplate.queryForList(query);
        jdbc
        for(Map<String,Object> paymentRow : paymentsRows){
        	Payment payment = new Payment();
        	payment.setId(Integer.parseInt(String.valueOf(paymentRow.get("id"))));
        	payment.setAmount(Integer.parseInt(String.valueOf(paymentRow.get("amount"))));
        	payment.setCardNumber();
        	payment.setCardOwner(Integer.parseInt(String.valueOf(paymentRow.get("cardNumber"))));
        	//
        	payment.setAmount(resultSet.getLong("amount"));
    		payment.setCardNumber(resultSet.getLong("cardNumber"));
    		payment.setCardOwner(resultSet.getString("cardOwner"));
    		payment.setProjectId(resultSet.getInt("projectId"));
    		payment.setId(resultSet.getInt("id"));
    		//
            emp.setName(String.valueOf(empRow.get("name")));
            emp.setRole(String.valueOf(empRow.get("role")));
            empList.add(emp);
        }
        return data;
	}
	*/
	@Override
	public Payment get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Payment element) {
		logger.warn("Function not working yet");
		String query  = "INSERT INTO " + table + " values";
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
