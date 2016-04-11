package ua.nenya.dao;

import java.util.List;

import ua.nenya.domain.Reward;

public interface InvestmentDao {
	
	List<Reward> getRewards(String projectName);
	void writeIvestmentInProject(String projectName, int amount);

}
