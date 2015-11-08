package ua.goit.kyrychok.kickstarter.dao.factory;

import ua.goit.kyrychok.kickstarter.dao.CategoryDao;
import ua.goit.kyrychok.kickstarter.dao.FaqDao;
import ua.goit.kyrychok.kickstarter.dao.ProjectDao;
import ua.goit.kyrychok.kickstarter.dao.RewardDao;
import ua.goit.kyrychok.kickstarter.dao.database.*;
import ua.goit.kyrychok.kickstarter.dao.database.factory.AbstractSqlProviderFactory;

public class DbDaoFactory implements AbstractDaoFactory {
    private DbCategoryDao dbCategoryDao;
    private DbProjectDao dbProjectDao;
    private DbProjectEventDao dbProjectEventDao;
    private DbRewardDao dbRewardDao;
    private DbFaqDao dbFaqDao;

    public DbDaoFactory(DbDataSourceProvider dataSourceProvider, AbstractSqlProviderFactory sqlProviderFactory) {
        dbFaqDao = new DbFaqDao(dataSourceProvider, sqlProviderFactory.createFaqSqlProvider());
        dbRewardDao = new DbRewardDao(dataSourceProvider, sqlProviderFactory.createRewardSqlProvider());
        dbProjectEventDao = new DbProjectEventDao(sqlProviderFactory.createProjectEventSqlProvider());
        dbProjectDao = new DbProjectDao(dataSourceProvider, dbFaqDao, dbRewardDao, dbProjectEventDao, sqlProviderFactory.createProjectSqlProvider());
        dbCategoryDao = new DbCategoryDao(dataSourceProvider, dbProjectDao, sqlProviderFactory.createCategorySqlProvider());
    }

    @Override
    public CategoryDao createCategory() {
        return dbCategoryDao;
    }

    @Override
    public ProjectDao createProject() {
        return dbProjectDao;
    }

    @Override
    public RewardDao createReward() {
        return dbRewardDao;
    }

    @Override
    public FaqDao createFaq() {
        return dbFaqDao;
    }

}
