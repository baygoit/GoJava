package ua.com.goit.kyrychok.dao.database.factory;

import ua.com.goit.kyrychok.dao.database.*;

public interface AbstractSqlProviderFactory {
    CategorySqlProvider createCategorySqlProvider();

    FaqSqlProvider createFaqSqlProvider();

    ProjectSqlProvider createProjectSqlProvider();

    RewardSqlProvider createRewardSqlProvider();

    ProjectEventSqlProvider createProjectEventSqlProvider();
}
