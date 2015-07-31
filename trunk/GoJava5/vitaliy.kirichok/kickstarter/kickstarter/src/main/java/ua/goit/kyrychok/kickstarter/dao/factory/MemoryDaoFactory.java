package ua.goit.kyrychok.kickstarter.dao.factory;

import ua.goit.kyrychok.kickstarter.dao.CategoryDao;
import ua.goit.kyrychok.kickstarter.dao.FaqDao;
import ua.goit.kyrychok.kickstarter.dao.ProjectDao;
import ua.goit.kyrychok.kickstarter.dao.RewardDao;
import ua.goit.kyrychok.kickstarter.dao.memory.*;

public class MemoryDaoFactory implements AbstractDaoFactory {
    private MemoryStorage storage;

    public MemoryDaoFactory(MemoryStorage storage) {
        this.storage = storage;
    }

    @Override
    public CategoryDao createCategory() {
        return new MemoryCategoryDao(storage);
    }

    @Override
    public ProjectDao createProject() {
        return new MemoryProjectDao(storage);
    }

    @Override
    public RewardDao createReward() {
        return new MemoryRewardDao(storage);
    }

    @Override
    public FaqDao createFaq() {
        return new MemoryFaqDao(storage);
    }
}
