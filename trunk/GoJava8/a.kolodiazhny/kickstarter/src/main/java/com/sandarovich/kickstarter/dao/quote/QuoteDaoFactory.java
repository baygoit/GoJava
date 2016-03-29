package com.sandarovich.kickstarter.dao.quote;

import com.sandarovich.kickstarter.ConnectionManager;
import com.sandarovich.kickstarter.dao.DaoMode;

/**
 * Quote Dao Factory
 */
public class QuoteDaoFactory {

    public QuoteDao getQuotaDao(DaoMode mode) {
        if (DaoMode.MEMORY == mode) {
            return new QuoteDaoMemoryImpl();
        }
        if (DaoMode.FILE == mode) {
            return new QuoteDaoFileImpl();
        }
        if (DaoMode.DB == mode) {
            ConnectionManager connectionManager = new ConnectionManager();
            return new QuoteDaoDbImpl(connectionManager);
        }
        return null;
    }
}
