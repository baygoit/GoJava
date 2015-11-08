package ua.goit.kyrychok.kickstarter.dao.database.factory;

import ua.goit.kyrychok.kickstarter.dao.database.*;
import ua.goit.kyrychok.kickstarter.dao.database.sql_provider.*;

public class OraSqlProviderFactory implements AbstractSqlProviderFactory {
    @Override
    public CategorySqlProvider createCategorySqlProvider() {
        return new OraCategorySqlProvider();
    }

    @Override
    public FaqSqlProvider createFaqSqlProvider() {
        return new OraFaqSqlProvider();
    }

    @Override
    public ProjectSqlProvider createProjectSqlProvider() {
        return new OraProjectSqlProvider();
    }

    @Override
    public RewardSqlProvider createRewardSqlProvider() {
        return new OraRewardSqlProvider();
    }

    @Override
    public ProjectEventSqlProvider createProjectEventSqlProvider() {
        return new OraProjectEventSqlProvider();
    }
}
