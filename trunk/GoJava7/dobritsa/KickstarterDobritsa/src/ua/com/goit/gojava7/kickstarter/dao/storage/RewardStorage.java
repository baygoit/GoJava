package ua.com.goit.gojava7.kickstarter.dao.storage;

import java.util.List;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

public interface RewardStorage extends Storage<Reward> {

	public List<Reward> getByProject(String projectName);

}
