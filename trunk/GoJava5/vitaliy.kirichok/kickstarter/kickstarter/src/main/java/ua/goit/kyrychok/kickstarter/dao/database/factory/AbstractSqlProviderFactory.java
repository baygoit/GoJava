package ua.goit.kyrychok.kickstarter.dao.database.factory;

import ua.goit.kyrychok.kickstarter.dao.database.*;

public interface AbstractSqlProviderFactory {
    CategorySqlProvider createCategorySqlProvider();

    FaqSqlProvider createFaqSqlProvider();

    ProjectSqlProvider createProjectSqlProvider();

    RewardSqlProvider createRewardSqlProvider();

    ProjectEventSqlProvider createProjectEventSqlProvider();
}
