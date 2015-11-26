package ua.com.goit.gojava7.kickstarter.dao;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.dao.file.QuestionFileDAO;
import ua.com.goit.gojava7.kickstarter.dao.file.util.FileDAO;
import ua.com.goit.gojava7.kickstarter.dao.file.ProjectFileDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.QuestionMemoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.util.MemoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.ProjectMemoryDAO;

public class StorageFactoryTest {

    StorageFactory factory;
    
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testGetCategoryDAO() {
        assertThat(new StorageFactory(DataType.MEMORY).getCategoryDAO(), instanceOf(MemoryDAO.class));
        assertThat(new StorageFactory(DataType.FILE).getCategoryDAO(), instanceOf(FileDAO.class));
    }

    @Test
    public void testGetDataType() {
        assertThat(new StorageFactory(DataType.MEMORY).getDataType(), is(DataType.MEMORY));
        assertThat(new StorageFactory(DataType.FILE).getDataType(), is(DataType.FILE));
    }

    @Test
    public void testGetQuoteDAO() {
        assertThat(new StorageFactory(DataType.MEMORY).getQuoteDAO(), instanceOf(MemoryDAO.class));
        assertThat(new StorageFactory(DataType.FILE).getQuoteDAO(), instanceOf(FileDAO.class));
    }

    @Test
    public void testGetProjectDAO() {
        assertThat(new StorageFactory(DataType.MEMORY).getProjectDAO(), instanceOf(ProjectMemoryDAO.class));
        assertThat(new StorageFactory(DataType.FILE).getProjectDAO(), instanceOf(ProjectFileDAO.class));
    }

    @Test
    public void testGetPledgeDAO() {
        assertThat(new StorageFactory(DataType.MEMORY).getQuestionsDAO(), instanceOf(QuestionMemoryDAO.class));
        assertThat(new StorageFactory(DataType.FILE).getQuestionsDAO(), instanceOf(QuestionFileDAO.class));
    }

    @Test
    public void testGetPaymentDAO() {
        assertThat(new StorageFactory(DataType.MEMORY).getPaymentDAO(), instanceOf(MemoryDAO.class));
        assertThat(new StorageFactory(DataType.FILE).getPaymentDAO(), instanceOf(FileDAO.class));
    }

}
