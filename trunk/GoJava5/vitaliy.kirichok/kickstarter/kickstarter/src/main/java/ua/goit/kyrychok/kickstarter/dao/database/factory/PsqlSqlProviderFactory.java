package ua.goit.kyrychok.kickstarter.dao.database.factory;

import ua.goit.kyrychok.kickstarter.dao.database.*;
import ua.goit.kyrychok.kickstarter.dao.database.sql_provider.*;

public class PsqlSqlProviderFactory implements AbstractSqlProviderFactory {
    @Override
    public CategorySqlProvider createCategorySqlProvider() {
        return new PsqlCategorySqlProvider();
    }

    @Override
    public FaqSqlProvider createFaqSqlProvider() {
        return new PsqlFaqSqlProvider();
    }

    @Override
    public ProjectSqlProvider createProjectSqlProvider() {
        return new PsqlProjectSqlProvider();
    }

    @Override
    public RewardSqlProvider createRewardSqlProvider() {
        return new PsqlRewardSqlProvider();
    }

    @Override
    public ProjectEventSqlProvider createProjectEventSqlProvider() {
        return new PsqlProjectEventSqlProvider();
    }
}
