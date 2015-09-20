package ua.com.goit.kyrychok.dao.factory;

import ua.com.goit.kyrychok.dao.CategoryDao;
import ua.com.goit.kyrychok.dao.FaqDao;
import ua.com.goit.kyrychok.dao.ProjectDao;
import ua.com.goit.kyrychok.dao.RewardDao;

public interface AbstractDaoFactory {

    CategoryDao createCategory();

    ProjectDao createProject();

    RewardDao createReward();

    FaqDao createFaq();
}
