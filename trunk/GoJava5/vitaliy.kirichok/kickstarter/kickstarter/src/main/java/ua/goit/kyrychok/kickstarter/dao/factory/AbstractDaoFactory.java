package ua.goit.kyrychok.kickstarter.dao.factory;

import ua.goit.kyrychok.kickstarter.dao.CategoryDao;
import ua.goit.kyrychok.kickstarter.dao.FaqDao;
import ua.goit.kyrychok.kickstarter.dao.ProjectDao;
import ua.goit.kyrychok.kickstarter.dao.RewardDao;

public interface AbstractDaoFactory {

    CategoryDao createCategory();

    ProjectDao createProject();

    RewardDao createReward();

    FaqDao createFaq();
}
