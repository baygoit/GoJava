package ua.com.goit.gojava7.salivon.dao;

import ua.com.goit.gojava7.salivon.dao.memory.FaqDaoMemoryImp;
import ua.com.goit.gojava7.salivon.dao.memory.CategoryDaoMemoryImp;
import ua.com.goit.gojava7.salivon.dao.memory.QuoteDaoMemoryImp;
import ua.com.goit.gojava7.salivon.dao.memory.PaymentDaoMemoryImp;
import ua.com.goit.gojava7.salivon.dao.memory.ProjectDaoMemoryImp;
import ua.com.goit.gojava7.salivon.dao.file.CategoryDaoFileImp;
import ua.com.goit.gojava7.salivon.dao.file.FaqDaoFileImp;
import ua.com.goit.gojava7.salivon.dao.file.QuoteDaoFileImp;
import ua.com.goit.gojava7.salivon.dao.file.PaymentDaoFileImp;
import ua.com.goit.gojava7.salivon.dao.file.ProjectDaoFileImp;
import ua.com.goit.gojava7.salivon.dao.db.PaymentDaoDbImp;
import ua.com.goit.gojava7.salivon.dao.db.ProjectDaoDbImp;
import ua.com.goit.gojava7.salivon.dao.db.CategoryDaoDbImp;
import ua.com.goit.gojava7.salivon.dao.db.FaqDaoDbImp;
import ua.com.goit.gojava7.salivon.dao.db.QuoteDaoDbImp;

public class DaoFactory {

    public static QuoteDao getQuoteDao(DataType currentDataType) {
        QuoteDao tyoeDao = null;
        if (currentDataType == DataType.FILE) {
            tyoeDao = new QuoteDaoFileImp();
        } else if (currentDataType == DataType.MEMORY) {
            tyoeDao = new QuoteDaoMemoryImp();
        } else if (currentDataType == DataType.DB) {
            tyoeDao = new QuoteDaoDbImp();
        }
        return tyoeDao;
    }

    public static CategoryDao getCategoryDao(DataType currentDataType) {
        CategoryDao typeDao = null;
        if (currentDataType == DataType.FILE) {
            typeDao = new CategoryDaoFileImp();
        } else if (currentDataType == DataType.MEMORY) {
            typeDao = new CategoryDaoMemoryImp();
        } else if (currentDataType == DataType.DB) {
            typeDao = new CategoryDaoDbImp();
        }
        return typeDao;
    }

    public static ProjectDao getProjectDao(DataType currentDataType) {
        ProjectDao typeDao = null;
        if (currentDataType == DataType.FILE) {
            typeDao = new ProjectDaoFileImp();
        } else if (currentDataType == DataType.MEMORY) {
            typeDao = new ProjectDaoMemoryImp();
        } else if (currentDataType == DataType.DB) {
            typeDao = new ProjectDaoDbImp();
        }
        return typeDao;
    }

    public static FaqDao getFaqDao(DataType currentDataType) {
        FaqDao typeDao = null;
        if (currentDataType == DataType.FILE) {
            typeDao = new FaqDaoFileImp();
        } else if (currentDataType == DataType.MEMORY) {
            typeDao = new FaqDaoMemoryImp();
        } else if (currentDataType == DataType.DB) {
            typeDao = new FaqDaoDbImp();
        }
        return typeDao;
    }

    public static PaymentDao getPaymentDao(DataType currentDataType) {
        PaymentDao typeDao = null;
        if (currentDataType == DataType.FILE) {
            typeDao = new PaymentDaoFileImp();
        } else if (currentDataType == DataType.MEMORY) {
            typeDao = new PaymentDaoMemoryImp();
        } else if (currentDataType == DataType.DB) {
            typeDao = new PaymentDaoDbImp();
        }
        return typeDao;
    }
}
