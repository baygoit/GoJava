package ua.com.goit.gojava7.kickstarter.dao;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.dao.file.ProjectFileDAO;
import ua.com.goit.gojava7.kickstarter.dao.file.QuestionFileDAO;
import ua.com.goit.gojava7.kickstarter.dao.file.util.FileDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre.CategoryPostgreDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre.PaymentPostgreDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre.ProjectPostgreDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre.QuestionPostgreDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre.QuotePostgreDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.ProjectMemoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.QuestionMemoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.util.MemoryDAO;

public class StorageFactoryTest {

    @Test
    public void testGetDataType() {
        assertThat(new StorageFactory(DataType.MEMORY).getDataType(), is(DataType.MEMORY));
        assertThat(new StorageFactory(DataType.FILE).getDataType(), is(DataType.FILE));
        assertThat(new StorageFactory(DataType.POSTGRE).getDataType(), is(DataType.POSTGRE));
    }
    
    @Test
    public void testGetCategoryDAO() {
        assertThat(new StorageFactory(DataType.MEMORY).getCategoryDAO(), instanceOf(MemoryDAO.class));
        assertThat(new StorageFactory(DataType.FILE).getCategoryDAO(), instanceOf(FileDAO.class));
        assertThat(new StorageFactory(DataType.POSTGRE).getCategoryDAO(), instanceOf(CategoryPostgreDAO.class));
    }

    @Test
    public void testGetQuoteDAO() {
        assertThat(new StorageFactory(DataType.MEMORY).getQuoteDAO(), instanceOf(MemoryDAO.class));
        assertThat(new StorageFactory(DataType.FILE).getQuoteDAO(), instanceOf(FileDAO.class));
        assertThat(new StorageFactory(DataType.POSTGRE).getQuoteDAO(), instanceOf(QuotePostgreDAO.class));
    }

    @Test
    public void testGetProjectDAO() {
        assertThat(new StorageFactory(DataType.MEMORY).getProjectDAO(), instanceOf(ProjectMemoryDAO.class));
        assertThat(new StorageFactory(DataType.FILE).getProjectDAO(), instanceOf(ProjectFileDAO.class));
        assertThat(new StorageFactory(DataType.POSTGRE).getProjectDAO(), instanceOf(ProjectPostgreDAO.class));
    }

    @Test
    public void testGetPledgeDAO() {
        assertThat(new StorageFactory(DataType.MEMORY).getQuestionsDAO(), instanceOf(QuestionMemoryDAO.class));
        assertThat(new StorageFactory(DataType.FILE).getQuestionsDAO(), instanceOf(QuestionFileDAO.class));        
        assertThat(new StorageFactory(DataType.POSTGRE).getQuestionsDAO(), instanceOf(QuestionPostgreDAO.class));
    }

    @Test
    public void testGetPaymentDAO() {
        assertThat(new StorageFactory(DataType.MEMORY).getPaymentDAO(), instanceOf(MemoryDAO.class));
        assertThat(new StorageFactory(DataType.FILE).getPaymentDAO(), instanceOf(FileDAO.class));
        assertThat(new StorageFactory(DataType.POSTGRE).getPaymentDAO(), instanceOf(PaymentPostgreDAO.class));
    }

}
