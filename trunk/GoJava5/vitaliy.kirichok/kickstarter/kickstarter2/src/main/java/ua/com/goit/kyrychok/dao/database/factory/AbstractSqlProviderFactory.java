package ua.com.goit.kyrychok.dao.database.factory;

import ua.com.goit.kyrychok.dao.database.sql_provider.*;

public interface AbstractSqlProviderFactory {
    CategorySqlProvider createCategorySqlProvider();

    FaqSqlProvider createFaqSqlProvider();

    ProjectSqlProvider createProjectSqlProvider();

    RewardSqlProvider createRewardSqlProvider();

    ProjectEventSqlProvider createProjectEventSqlProvider();
}
