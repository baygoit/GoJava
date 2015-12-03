package main.ua.com.goit.gojava7.kickstarter.dao.mysql;

import java.sql.Connection;
import java.util.List;

import main.ua.com.goit.gojava7.kickstarter.beans.Reward;
import main.ua.com.goit.gojava7.kickstarter.dao.RewardDao;

public class RewardDaoMysqlImpl implements RewardDao {

	private Connection connection;
	
	public RewardDaoMysqlImpl(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void add(Reward reward) {
		
	}

	@Override
	public void remove(Reward reward) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Reward> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
