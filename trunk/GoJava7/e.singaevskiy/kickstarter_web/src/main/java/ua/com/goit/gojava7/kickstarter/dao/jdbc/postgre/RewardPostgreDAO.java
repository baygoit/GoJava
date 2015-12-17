package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.goit.gojava7.kickstarter.dao.RewardDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.JdbcDataSource;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.JdbcDispatcher;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

public class RewardPostgreDAO implements RewardDAO, JdbcDataSource<Reward> {

	final static Logger logger = LoggerFactory.getLogger(RewardPostgreDAO.class);
	
    private static final String TABLE = "reward";
    private static final String FIELDS = "id,description,pledgeSum,project_id";
    private static final String INSERTION = FIELDS.replaceAll("[^,]+", "?");
    private static final String KEY = "id";
    
    private JdbcDispatcher dispatcher;

    public RewardPostgreDAO(JdbcDispatcher dispatcher) {
        this.dispatcher = dispatcher;
        logger.info("dao created");
    }

    @Override
    public void clear() {
        String sql = "delete from " + TABLE;
        dispatcher.clear(sql);
    }

    @Override
    public Reward get(int index) {
        String sql = "select " + FIELDS + " from " + TABLE + " where " + KEY + " = " + index;
        Reward element = null;
        List<Reward> list = dispatcher.get(sql, this);
		if (!list.isEmpty()) {
			element = list.get(0);
		}
        return element;
    }

    @Override
    public void add(Reward element) {
        String sql = "insert into " + TABLE + " (" + FIELDS + ") values (" + INSERTION + ")";
        dispatcher.add(sql, element, this);
    }

    @Override
    public void addAll(List<Reward> elements) {
        String sql = "insert into " + TABLE + " (" + FIELDS + ") values (" + INSERTION + ")";
        dispatcher.add(sql, elements, this);
    }

    @Override
    public List<Reward> getAll() {
        String sql = "select " + FIELDS + " from " + TABLE;
        List<Reward> result = dispatcher.get(sql, this);
        return result;
    }

    @Override
    public List<Reward> getByProject(int projectId) {
        String sql = "select " + FIELDS + " from " + TABLE + " where project_id = " + projectId;
        List<Reward> result = dispatcher.get(sql, this);      
        return result;
    }

	@Override
	public Reward read(ResultSet resultSet) throws SQLException {
		Reward element = new Reward();
        element.setId(resultSet.getInt("id"));
        element.setDescription(resultSet.getString("description"));
        element.setPledgeSum(resultSet.getLong("pledgeSum"));
        element.setProjectId(resultSet.getInt("project_id"));
        return element;
	}

	@Override
	public void prepare(Reward element, PreparedStatement statement) throws SQLException {
		int i = 0;
        statement.setInt(++i, element.getId());
        statement.setString(++i, element.getDescription());
        statement.setLong(++i, element.getPledgeSum());
        if (element.getProjectId() == 0) {
        	statement.setNull(++i, Types.INTEGER);
		} else {
			statement.setInt(++i, element.getProjectId());
		}
	}
}
