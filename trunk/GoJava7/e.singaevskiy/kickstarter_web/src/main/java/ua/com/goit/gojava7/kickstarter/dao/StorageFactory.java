package ua.com.goit.gojava7.kickstarter.dao;

import java.io.InputStream;
import java.util.Properties;

import ua.com.goit.gojava7.kickstarter.dao.file.CategoryFileDAO;
import ua.com.goit.gojava7.kickstarter.dao.file.PaymentFileDAO;
import ua.com.goit.gojava7.kickstarter.dao.file.ProjectFileDAO;
import ua.com.goit.gojava7.kickstarter.dao.file.QuestionFileDAO;
import ua.com.goit.gojava7.kickstarter.dao.file.QuoteFileDAO;
import ua.com.goit.gojava7.kickstarter.dao.file.RewardFileDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre.CategoryPostgreDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre.PaymentPostgreDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre.ProjectPostgreDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre.QuestionPostgreDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre.QuotePostgreDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre.RewardPostgreDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.JdbcDispatcher;
import ua.com.goit.gojava7.kickstarter.dao.memory.CategoryMemoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.PaymentMemoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.ProjectMemoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.QuestionMemoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.QuoteMemoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.RewardMemoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.util.Memory;
import ua.com.goit.gojava7.kickstarter.util.Utils;

public class StorageFactory {
    private DataType dataType;
    private QuoteDAO quoteDAO;
    private CategoryDAO categoryDAO;
    private ProjectDAO projectDAO;
    private QuestionsDAO questionsDAO;
    private PaymentDAO paymentDAO;
    private RewardDAO rewardDAO;
    private Properties properties;
    
    public StorageFactory(DataType dataType, Properties properties){
        this.dataType = dataType;
        this.properties = properties;
        init();
    }
    
    public StorageFactory(DataType dataType) {
        this.dataType = dataType;
        properties = Utils.readProperties("./kicks-files/config.properties");        
        init();
        
    }
    
    public StorageFactory(DataType dataType, InputStream resourceStream) {
        this.dataType = dataType;
        properties = Utils.readProperties(resourceStream);        
        init();
        
    }

    private void init() {
        switch (dataType) {
        case MEMORY:
            initMemoryStorage();
            break;
            
        case FILE:
            initFileStorage();
            break;
            
        case POSTGRE:
            initPostgreStorage();
            break;

        default:
            break;
        }
    }
    
    private void initMemoryStorage(){
        Memory mem = new Memory();
        quoteDAO = new QuoteMemoryDAO(mem.getQuotes());
        categoryDAO = new CategoryMemoryDAO(mem.getCategories());
        paymentDAO = new PaymentMemoryDAO(mem.getPayments());
        
        projectDAO = new ProjectMemoryDAO(mem.getProjects());
        questionsDAO = new QuestionMemoryDAO(mem.getQuestions());
        rewardDAO = new RewardMemoryDAO(mem.getRewards());
    }
    
    private void initFileStorage(){
        quoteDAO = new QuoteFileDAO();
        categoryDAO = new CategoryFileDAO();
        
        paymentDAO = new PaymentFileDAO();       
        projectDAO = new ProjectFileDAO();
        questionsDAO = new QuestionFileDAO();
        rewardDAO = new RewardFileDAO();
    }
    
    private void initPostgreStorage(){

        try {
            Class.forName(properties.getProperty("driver"));
            JdbcDispatcher dispatcher = new JdbcDispatcher(
                    properties.getProperty("driver"),
                    properties.getProperty("url"),
                    properties.getProperty("user"), 
                    properties.getProperty("password"));
            
            quoteDAO = new QuotePostgreDAO(dispatcher);
            categoryDAO = new CategoryPostgreDAO(dispatcher);
            projectDAO = new ProjectPostgreDAO(dispatcher);
            questionsDAO = new QuestionPostgreDAO(dispatcher);
            rewardDAO = new RewardPostgreDAO(dispatcher);
            paymentDAO = new PaymentPostgreDAO(dispatcher);        
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }       
    }

    public CategoryDAO getCategoryDAO() {
        return categoryDAO;
    }

    public DataType getDataType() {
        return dataType;
    }

    public QuoteDAO getQuoteDAO() {
        return quoteDAO;
    }

    public ProjectDAO getProjectDAO() {
        return projectDAO;
    }

    public QuestionsDAO getQuestionsDAO() {
        return questionsDAO;
    }

    public PaymentDAO getPaymentDAO() {
        return paymentDAO;
    }

    public RewardDAO getRewardDAO() {
        return rewardDAO;
    }
}
