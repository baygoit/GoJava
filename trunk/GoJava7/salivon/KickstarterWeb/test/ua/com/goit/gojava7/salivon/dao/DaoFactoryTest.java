package ua.com.goit.gojava7.salivon.dao;

import org.junit.Test;
import static org.junit.Assert.*;
import ua.com.goit.gojava7.salivon.dao.db.CategoryDaoDbImp;
import ua.com.goit.gojava7.salivon.dao.db.FaqDaoDbImp;
import ua.com.goit.gojava7.salivon.dao.db.PaymentDaoDbImp;
import ua.com.goit.gojava7.salivon.dao.db.ProjectDaoDbImp;
import ua.com.goit.gojava7.salivon.dao.db.QuoteDaoDbImp;
import ua.com.goit.gojava7.salivon.dao.file.CategoryDaoFileImp;
import ua.com.goit.gojava7.salivon.dao.file.FaqDaoFileImp;
import ua.com.goit.gojava7.salivon.dao.file.PaymentDaoFileImp;
import ua.com.goit.gojava7.salivon.dao.file.ProjectDaoFileImp;
import ua.com.goit.gojava7.salivon.dao.file.QuoteDaoFileImp;
import ua.com.goit.gojava7.salivon.dao.memory.CategoryDaoMemoryImp;
import ua.com.goit.gojava7.salivon.dao.memory.FaqDaoMemoryImp;
import ua.com.goit.gojava7.salivon.dao.memory.PaymentDaoMemoryImp;
import ua.com.goit.gojava7.salivon.dao.memory.ProjectDaoMemoryImp;
import ua.com.goit.gojava7.salivon.dao.memory.QuoteDaoMemoryImp;

public class DaoFactoryTest {

    @Test
    public void testGetQuoteDao() {
        DataType currentDataType = null;
        QuoteDao result = DaoFactory.getQuoteDao(currentDataType);
        assertEquals(null, result);
        result = DaoFactory.getQuoteDao(DataType.DB);
        assertTrue(result instanceof QuoteDaoDbImp);
        result = DaoFactory.getQuoteDao(DataType.FILE);
        assertTrue(result instanceof QuoteDaoFileImp);
        result = DaoFactory.getQuoteDao(DataType.MEMORY);
        assertTrue(result instanceof QuoteDaoMemoryImp);
    }

    @Test
    public void testGetCategoryDao() {

        DataType currentDataType = null;
        CategoryDao result = DaoFactory.getCategoryDao(currentDataType);
        assertEquals(null, result);
        result = DaoFactory.getCategoryDao(DataType.DB);
        assertTrue(result instanceof CategoryDaoDbImp);
        result = DaoFactory.getCategoryDao(DataType.FILE);
        assertTrue(result instanceof CategoryDaoFileImp);
        result = DaoFactory.getCategoryDao(DataType.MEMORY);
        assertTrue(result instanceof CategoryDaoMemoryImp);

    }

    @Test
    public void testGetProjectDao() {
        DataType currentDataType = null;
        ProjectDao result = DaoFactory.getProjectDao(currentDataType);
        assertEquals(null, result);
        result = DaoFactory.getProjectDao(DataType.DB);
        assertTrue(result instanceof ProjectDaoDbImp);
        result = DaoFactory.getProjectDao(DataType.FILE);
        assertTrue(result instanceof ProjectDaoFileImp);
        result = DaoFactory.getProjectDao(DataType.MEMORY);
        assertTrue(result instanceof ProjectDaoMemoryImp);

    }

    @Test
    public void testGetFaqDao() {
        DataType currentDataType = null;
        FaqDao result = DaoFactory.getFaqDao(currentDataType);
        assertEquals(null, result);
        result = DaoFactory.getFaqDao(DataType.DB);
        assertTrue(result instanceof FaqDaoDbImp);
        result = DaoFactory.getFaqDao(DataType.FILE);
        assertTrue(result instanceof FaqDaoFileImp);
        result = DaoFactory.getFaqDao(DataType.MEMORY);
        assertTrue(result instanceof FaqDaoMemoryImp);
    }

    @Test
    public void testGetPaymentDao() {
        DataType currentDataType = null;
        PaymentDao result = DaoFactory.getPaymentDao(currentDataType);
        assertEquals(null, result);
        result = DaoFactory.getPaymentDao(DataType.DB);
        assertTrue(result instanceof PaymentDaoDbImp);
        result = DaoFactory.getPaymentDao(DataType.FILE);
        assertTrue(result instanceof PaymentDaoFileImp);
        result = DaoFactory.getPaymentDao(DataType.MEMORY);
        assertTrue(result instanceof PaymentDaoMemoryImp);
    }

}
