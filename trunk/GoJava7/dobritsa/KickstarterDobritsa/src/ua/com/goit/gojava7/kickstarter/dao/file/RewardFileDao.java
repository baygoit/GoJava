package ua.com.goit.gojava7.kickstarter.dao.file;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.FileDao;
import ua.com.goit.gojava7.kickstarter.dao.storage.RewardStorage;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

public class RewardFileDao extends FileDao<Reward> implements RewardStorage {

	public RewardFileDao(List<Reward> data) {
		super(data);
	}
}
