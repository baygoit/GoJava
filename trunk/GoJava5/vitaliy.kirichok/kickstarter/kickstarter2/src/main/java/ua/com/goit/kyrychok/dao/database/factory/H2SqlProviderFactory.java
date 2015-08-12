package ua.com.goit.kyrychok.dao.database.factory;

import ua.com.goit.kyrychok.dao.database.*;
import ua.com.goit.kyrychok.dao.database.sql_provider.*;

public class H2SqlProviderFactory implements AbstractSqlProviderFactory {
    @Override
    public CategorySqlProvider createCategorySqlProvider() {
        return new H2CategorySqlProvider();
    }

    @Override
    public FaqSqlProvider createFaqSqlProvider() {
        return new H2FaqSqlProvider();
    }

    @Override
    public ProjectSqlProvider createProjectSqlProvider() {
        return new H2ProjectSqlProvider();
    }

    @Override
    public RewardSqlProvider createRewardSqlProvider() {
        return new H2RewardSqlProvider();
    }

    @Override
    public ProjectEventSqlProvider createProjectEventSqlProvider() {
        return new H2ProjectEventSqlProvider();
    }
}
