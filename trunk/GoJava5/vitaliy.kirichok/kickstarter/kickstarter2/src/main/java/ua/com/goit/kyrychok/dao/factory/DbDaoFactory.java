package ua.com.goit.kyrychok.dao.factory;

import ua.com.goit.kyrychok.dao.CategoryDao;
import ua.com.goit.kyrychok.dao.FaqDao;
import ua.com.goit.kyrychok.dao.ProjectDao;
import ua.com.goit.kyrychok.dao.RewardDao;
import ua.com.goit.kyrychok.dao.database.*;
import ua.com.goit.kyrychok.dao.database.factory.AbstractSqlProviderFactory;

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
