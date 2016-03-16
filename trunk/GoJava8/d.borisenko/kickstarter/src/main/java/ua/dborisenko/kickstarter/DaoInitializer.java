package ua.dborisenko.kickstarter;

import ua.dborisenko.kickstarter.dao.CategoryDao;
import ua.dborisenko.kickstarter.dao.CategoryDaoFile;
import ua.dborisenko.kickstarter.dao.CategoryDaoMemory;
import ua.dborisenko.kickstarter.dao.CategoryDaoSql;
import ua.dborisenko.kickstarter.dao.QuoteDao;
import ua.dborisenko.kickstarter.dao.QuoteDaoFile;
import ua.dborisenko.kickstarter.dao.QuoteDaoMemory;
import ua.dborisenko.kickstarter.dao.QuoteDaoSql;

class DaoInitializer {
    private static final String DAO_MODE_ENV_NAME = "KICKSTARTER_DAO_MODE";

    static enum DaoMode {
        MEMORY, FILES, SQL;

        public static DaoMode fromName(String mode) {
            try {
                return DaoMode.valueOf(mode.toUpperCase());
            } catch (NullPointerException | IllegalArgumentException e) {
                return DaoMode.MEMORY;
            }
        }
    }

    QuoteDao initQuoteDao() {
        DaoMode daoMode = DaoMode.fromName(System.getenv(DAO_MODE_ENV_NAME));
        if (daoMode == DaoMode.SQL) {
            return new QuoteDaoSql();
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

    CategoryDao initCategoryDao() {
        DaoMode daoMode = DaoMode.fromName(System.getenv(DAO_MODE_ENV_NAME));
        if (daoMode == DaoMode.SQL) {
            return new CategoryDaoSql();
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
}
