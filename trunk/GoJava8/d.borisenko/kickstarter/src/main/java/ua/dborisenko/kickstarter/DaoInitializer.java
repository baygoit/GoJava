package ua.dborisenko.kickstarter;

import ua.dborisenko.kickstarter.dao.CategoryDao;
import ua.dborisenko.kickstarter.dao.CategoryDaoFile;
import ua.dborisenko.kickstarter.dao.CategoryDaoMemory;
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

    private DaoMode getDaoMode() {
        return DaoMode.fromName(System.getenv(DAO_MODE_ENV_NAME));
    }

    QuoteDao initQuoteDao() {
        DaoMode daoMode = getDaoMode();
        QuoteDao quoteDao = null;
		if (daoMode == DaoMode.SQL) {
			quoteDao = new QuoteDaoSql();
		} else if (daoMode == DaoMode.FILES) {
            try {
                quoteDao = new QuoteDaoFile();
                quoteDao.fillQuotes();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
		if (quoteDao == null) {
            quoteDao = new QuoteDaoMemory();
            quoteDao.fillQuotes();
        }
        return quoteDao;
    }

    CategoryDao initCategoryDao() {
        DaoMode daoMode = getDaoMode();
        CategoryDao categoryDao = null;
        if (DaoMode.FILES == daoMode) {
            try {
                categoryDao = new CategoryDaoFile();
                categoryDao.fillCategories();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
		if (categoryDao == null) {
            categoryDao = new CategoryDaoMemory();
            categoryDao.fillCategories();
        }
        return categoryDao;
    }
}
