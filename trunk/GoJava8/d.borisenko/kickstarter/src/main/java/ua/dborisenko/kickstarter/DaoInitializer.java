package ua.dborisenko.kickstarter;

import ua.dborisenko.kickstarter.dao.CategoryDao;
import ua.dborisenko.kickstarter.dao.CategoryDaoFile;
import ua.dborisenko.kickstarter.dao.CategoryDaoMemory;
import ua.dborisenko.kickstarter.dao.QuoteDao;
import ua.dborisenko.kickstarter.dao.QuoteDaoFile;
import ua.dborisenko.kickstarter.dao.QuoteDaoMemory;

class DaoInitializer {

    static enum DaoMode {
        MEMORY, FILES
    }

    private DaoMode getDaoMode() {
        String envVariable = System.getenv("KICKSTARTER_DAO_MODE"); 
        if (null == envVariable) {
            return DaoMode.MEMORY;
        }
        DaoMode daoMode;
        if (envVariable.equals(DaoMode.FILES.toString())) {
            daoMode = DaoMode.FILES;
        } else {
            daoMode = DaoMode.MEMORY;
        }
        return daoMode;
    }

    QuoteDao initQuoteDao() {
        DaoMode daoMode = getDaoMode();
        QuoteDao quoteDao = null;
        if (DaoMode.FILES == daoMode) {
            try {
                quoteDao = new QuoteDaoFile();
                quoteDao.fillQuotes();
            } catch (IllegalStateException e) {
                e.printStackTrace();
                daoMode = DaoMode.MEMORY;
            }
        }
        if (DaoMode.MEMORY == daoMode) {
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
                daoMode = DaoMode.MEMORY;
            }
        }
        if (DaoMode.MEMORY == daoMode) {
            categoryDao = new CategoryDaoMemory();
            categoryDao.fillCategories();
        }
        return categoryDao;
    }
}
