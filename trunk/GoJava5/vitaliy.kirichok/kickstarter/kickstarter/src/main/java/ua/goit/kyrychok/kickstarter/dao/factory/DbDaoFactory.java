package ua.goit.kyrychok.kickstarter.dao.factory;

import ua.goit.kyrychok.kickstarter.dao.CategoryDao;
import ua.goit.kyrychok.kickstarter.dao.FaqDao;
import ua.goit.kyrychok.kickstarter.dao.ProjectDao;
import ua.goit.kyrychok.kickstarter.dao.RewardDao;
import ua.goit.kyrychok.kickstarter.dao.database.*;

public class DbDaoFactory implements AbstractDaoFactory {
    private DbDataSourceProvider dataSourceProvider;

    public DbDaoFactory(DbDataSourceProvider dataSourceProvider) {
        this.dataSourceProvider = dataSourceProvider;
    }

    private DbFaqDao createCurrentFaq() {
        return new DbFaqDao(dataSourceProvider);
    }

    private DbProjectDao createCurrentProject() {
        DbProjectDao result = new DbProjectDao(dataSourceProvider,
                createCurrentFaq());
        return result;
    }

    @Override
    public CategoryDao createCategory() {
        DbCategoryDao result = new DbCategoryDao(dataSourceProvider, createCurrentProject());
        return result;
    }

    @Override
    public ProjectDao createProject() {
        return createCurrentProject();
    }

    @Override
    public RewardDao createReward() {
        return new DbRewardDao(dataSourceProvider);
    }

    @Override
    public FaqDao createFaq() {
        return createCurrentFaq();
    }

}
