package ua.com.goit.gojava7.kickstarter.dao.file;

import java.util.List;
import java.util.stream.Collectors;

import ua.com.goit.gojava7.kickstarter.dao.RewardDAO;
import ua.com.goit.gojava7.kickstarter.dao.file.util.FileDAO;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

public class RewardFileDAO extends FileDAO<Reward> implements RewardDAO {

    public RewardFileDAO() {
        super(Reward.class);
    }

    public RewardFileDAO(String pathToFile) {
        super(Reward.class, pathToFile);
    }

    @Override
    public Reward get(int index) {
        for (Reward element : getAll()) {
            if (element.getId() == index) {
                return element;
            }
        }
        return null;
    }

    @Override
    public List<Reward> getByProject(int projectId) {
        return getAll().stream()
                .filter(reward -> reward.getProjectId() == projectId)
                .collect(Collectors.toList());
    }
}
