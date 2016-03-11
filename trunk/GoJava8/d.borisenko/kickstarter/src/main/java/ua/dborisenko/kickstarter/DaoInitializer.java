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

    private DaoMode getDaoMode(String[] args) {
        DaoMode daoMode = DaoMode.MEMORY;
        if (args.length > 0) {
            String arg1 = args[0].toUpperCase().trim();
            if (arg1.equals(DaoMode.FILES.toString())) {
                daoMode = DaoMode.FILES;
            }
        }
        return daoMode;
    }

    QuoteDao initQuoteDao(String[] args) {
        DaoMode daoMode = getDaoMode(args);
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

    CategoryDao initCategoryDao(String[] args) {
        DaoMode daoMode = getDaoMode(args);
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
