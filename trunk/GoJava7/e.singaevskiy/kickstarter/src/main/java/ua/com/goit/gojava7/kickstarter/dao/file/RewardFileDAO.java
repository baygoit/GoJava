package ua.com.goit.gojava7.kickstarter.dao.file;

import ua.com.goit.gojava7.kickstarter.beans.Reward;
import ua.com.goit.gojava7.kickstarter.dao.RewardStorage;

public class RewardFileDAO extends FileDAO<Reward> implements RewardStorage {

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
}
