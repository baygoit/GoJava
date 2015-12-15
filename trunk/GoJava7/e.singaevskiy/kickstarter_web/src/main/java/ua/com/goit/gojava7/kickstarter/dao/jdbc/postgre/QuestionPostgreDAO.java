package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.goit.gojava7.kickstarter.dao.QuestionsDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.JdbcDataSource;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.JdbcDispatcher;
import ua.com.goit.gojava7.kickstarter.domain.Question;

public class QuestionPostgreDAO implements QuestionsDAO, JdbcDataSource<Question> {

	final static Logger logger = LoggerFactory.getLogger(QuestionPostgreDAO.class);
	
    private static final String TABLE = "question";
    private static final String FIELDS = "project_id,question,answer";
    private static final String INSERTION = FIELDS.replaceAll("[^,]+", "?");
   
    private JdbcDispatcher dispatcher;

    public QuestionPostgreDAO(JdbcDispatcher dispatcher) {
        this.dispatcher = dispatcher;
        logger.info("dao created");
    }

    @Override
    public void clear() {
        String sql = "delete from " + TABLE;
        dispatcher.clear(sql);
    }

    @Override
    public Question get(int index) {
        String sql = "select " + FIELDS + " from " + TABLE + " limit 1 offset  " + index;
        Question element = null;
        List<Question> list = dispatcher.get(sql, this);
		if (!list.isEmpty()) {
			element = list.get(0);
		}
        return element;
    }

    @Override
    public void add(Question element) {
        String sql = "insert into " + TABLE + " (" + FIELDS + ") values (" + INSERTION + ")";
        dispatcher.add(sql, element, this);
    }

    @Override
    public void addAll(List<Question> elements) {
        String sql = "insert into " + TABLE + " (" + FIELDS + ") values (" + INSERTION + ")";
        dispatcher.add(sql, elements, this);
    }

    @Override
    public List<Question> getAll() {
        String sql = "select " + FIELDS + " from " + TABLE;
        List<Question> result = dispatcher.get(sql, this);
        return result;
    }

    @Override
    public List<Question> getByProject(int projectId) {
        String sql = "select " + FIELDS + " from " + TABLE + " where project_id = " + projectId;
        List<Question> result = dispatcher.get(sql, this);      
        return result;
    }

	@Override
	public Question read(ResultSet resultSet) throws SQLException {
		Question element = new Question();
        element.setQuestion(resultSet.getString("question"));
        element.setAnswer(resultSet.getString("answer"));
        element.setProjectId(resultSet.getInt("project_id"));
        return element;
	}

	@Override
	public void prepare(Question element, PreparedStatement statement) throws SQLException {
		int i = 0;
        if (element.getProjectId() == 0) {
            statement.setNull(++i, java.sql.Types.INTEGER);   
        } else {
            statement.setInt(++i, element.getProjectId());             
        }
        statement.setString(++i, element.getQuestion());
        statement.setString(++i, element.getAnswer());
	}
}
