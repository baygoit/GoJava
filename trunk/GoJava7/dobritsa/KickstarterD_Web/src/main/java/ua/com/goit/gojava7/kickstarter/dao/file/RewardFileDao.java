package ua.com.goit.gojava7.kickstarter.dao.file;

import java.util.List;
import java.util.stream.Collectors;

import ua.com.goit.gojava7.kickstarter.dao.FileDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

public class RewardFileDao extends FileDao<Reward> implements RewardDao {

	public RewardFileDao(List<Reward> data) {
		super(data);
	}

	@Override
	public List<Reward> getByProject(int projectId) {
		 return this.getAll().stream()
	                .filter(project -> project.getProjectId() == projectId)
	                .collect(Collectors.toList());
	}
}
