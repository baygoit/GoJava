package main.ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import main.ua.com.goit.gojava7.kickstarter.beans.Reward;

public interface RewardDao {
		
	public void add(Reward reward);

	public void remove(Reward reward);
	
	public int getSize();
	
	public List<Reward> getAll();
}
