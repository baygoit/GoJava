package ua.goit.kyrychok.kickstarter.dao.factory;

import ua.goit.kyrychok.kickstarter.dao.CategoryDao;
import ua.goit.kyrychok.kickstarter.dao.FaqDao;
import ua.goit.kyrychok.kickstarter.dao.ProjectDao;
import ua.goit.kyrychok.kickstarter.dao.RewardDao;
import ua.goit.kyrychok.kickstarter.dao.xml.*;

public class XmlDaoFactory implements AbstractDaoFactory {
    private XmlStorage storage;

    public XmlDaoFactory(XmlStorage storage) {
        this.storage = storage;
    }

    @Override
    public CategoryDao createCategory() {
        return new XmlCategoryDao(storage);
    }

    @Override
    public ProjectDao createProject() {
        return new XmlProjectDao(storage);
    }

    @Override
    public RewardDao createReward() {
        return new XmlRewardDao(storage);
    }

    @Override
    public FaqDao createFaq() {
        return new XmlFaqDao(storage);
    }
}
