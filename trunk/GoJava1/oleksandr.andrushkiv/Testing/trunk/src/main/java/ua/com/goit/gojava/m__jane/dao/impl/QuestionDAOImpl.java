package ua.com.goit.gojava.m__jane.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import ua.com.goit.gojava.m__jane.dao.QuestionDAO;
import ua.com.goit.gojava.m__jane.exceptions.TestingRuntimeException;
import ua.com.goit.gojava.m__jane.model.question.SimpleQuestion;
import ua.com.goit.gojava.m__jane.utils.DBConnectionSystem;

public class QuestionDAOImpl implements QuestionDAO {

	private DBConnectionSystem dbConnectionSystem;
	
	public QuestionDAOImpl() {
		dbConnectionSystem = DBConnectionSystem.getInstance(); 
	}
	
	
	@Override
	public void saveSimpleQuestion(SimpleQuestion question) {
		
		try(Connection connection = dbConnectionSystem.getConnection();){
						
			String sql = "Insert Into simple_question(content,standart_answer) "
	    			+ "Values(?,?)";
			PreparedStatement st = connection.prepareStatement(sql);	    	  		   		
	    	st.setString(1, question.getContent());
	    	st.setString(2, question.getStandartAnswer());
	    	st.executeUpdate();
			
		} catch (SQLException e) {
			throw new TestingRuntimeException("Can't save question to DB!");
			//TODO write to log
		}
		
	}

}
