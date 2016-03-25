package ua.dborisenko.kickstarter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.dborisenko.kickstarter.dao.CategoryDao;
import ua.dborisenko.kickstarter.dao.CategoryDaoFile;
import ua.dborisenko.kickstarter.dao.CategoryDaoMemory;
import ua.dborisenko.kickstarter.dao.CategoryDaoSql;
import ua.dborisenko.kickstarter.dao.DaoSql;
import ua.dborisenko.kickstarter.dao.QuoteDao;
import ua.dborisenko.kickstarter.dao.QuoteDaoFile;
import ua.dborisenko.kickstarter.dao.QuoteDaoMemory;
import ua.dborisenko.kickstarter.dao.QuoteDaoSql;

class DaoInitializer {
    private static final String DAO_MODE_ENV_NAME = "KICKSTARTER_DAO_MODE";

    private static enum DaoMode {
        MEMORY, FILES, SQL;

        public static DaoMode fromName(String mode) {
            try {
                return DaoMode.valueOf(mode.toUpperCase());
            } catch (NullPointerException | IllegalArgumentException e) {
                return DaoMode.MEMORY;
            }
        }
    }

    private List<DaoSql> daoSqlList = new ArrayList<>();

    QuoteDao getQuoteDao() {
        DaoMode daoMode = DaoMode.fromName(System.getenv(DAO_MODE_ENV_NAME));
        if (daoMode == DaoMode.SQL) {
            QuoteDaoSql quoteDaoSql = new QuoteDaoSql();
            daoSqlList.add(quoteDaoSql);
            return quoteDaoSql;
        } else if (daoMode == DaoMode.FILES) {
            QuoteDaoFile quoteDao = new QuoteDaoFile();
            quoteDao.fillQuotes();
            return quoteDao;
        } else {
            QuoteDaoMemory quoteDao = new QuoteDaoMemory();
            quoteDao.fillQuotes();
            return quoteDao;
        }
    }

    CategoryDao getCategoryDao() {
        DaoMode daoMode = DaoMode.fromName(System.getenv(DAO_MODE_ENV_NAME));
        if (daoMode == DaoMode.SQL) {
            CategoryDaoSql categoryDaoSql = new CategoryDaoSql();
            daoSqlList.add(categoryDaoSql);
            return categoryDaoSql;
        } else if (daoMode == DaoMode.FILES) {
            CategoryDaoFile categoryDao = new CategoryDaoFile();
            categoryDao.fillData();
            return categoryDao;
        } else {
            CategoryDaoMemory categoryDao = new CategoryDaoMemory();
            categoryDao.fillData();
            return categoryDao;
        }
    }

    void closeSqlConnections() throws SQLException {
        for (DaoSql daoSql : daoSqlList) {
            daoSql.closeConnection();
        }
    }
}
